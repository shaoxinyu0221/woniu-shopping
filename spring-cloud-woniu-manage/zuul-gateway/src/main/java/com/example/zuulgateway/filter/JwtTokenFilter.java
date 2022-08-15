package com.example.zuulgateway.filter;

import com.commons.utils.JsonUtils;
import com.commons.utils.JwtUtils;
import com.commons.utils.MapUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/15 19:26
 */
@Slf4j
public class JwtTokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();

        String strToken = request.getHeader("x-jwt-token");

        if (StringUtils.isEmpty(strToken)){
            log.info("jwt-token为空,请求放行");
            context.setSendZuulResponse(true);
            return null;
        }

        //如果jwtToken不为空,判断JwtToken是否错误
        try {
            boolean flag = JwtUtils.verify(strToken);
            if (flag){
                log.info("jwt-token正确,请求放行");
                context.setSendZuulResponse(true);
                return null;
            }
        } catch (Exception e) {
           e.printStackTrace();
            try {
                log.info("jwt-token非法,请求被打回");
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                PrintWriter out = response.getWriter();
                LinkedHashMap<String, String> map = MapUtils.of(
                        "code", "400",
                        "msg", "请求非法"
                );
                String jsonString = JsonUtils.toJSONString(map);
                out.write(jsonString);
                out.flush();
                out.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        context.setSendZuulResponse(false);
        return null;
    }
}

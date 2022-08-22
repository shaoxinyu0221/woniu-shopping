package com.authservice.config;

import com.commons.utils.JsonUtils;
import com.commons.utils.JwtUtils;
import com.commons.utils.MapUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/16 9:26
 */
@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        log.info("用户 {} 登录成功", user.getUsername());

        extracted(authentication, user);

        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setStatus(HttpStatus.OK.value());
        PrintWriter out = httpServletResponse.getWriter();

        String jwtStr = JwtUtils.createJWT(user.getUsername());

        Map<String, String> map = MapUtils.of(
                "code", "10000",
                "msg", "success",
                "data", jwtStr);

        String s = JsonUtils.toJSONString(map);

        out.write(s);
    }

    private void extracted(Authentication authentication, User user) {
        //将用户权限以账号为键,权限集的字符串为值,存到redis中
        StringBuilder builder = new StringBuilder();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            builder.append(authority.getAuthority()).append(",");
        }

        String substring = builder.substring(0, builder.length() - 1);
        stringRedisTemplate.opsForValue().append(user.getUsername(),substring);
    }


}

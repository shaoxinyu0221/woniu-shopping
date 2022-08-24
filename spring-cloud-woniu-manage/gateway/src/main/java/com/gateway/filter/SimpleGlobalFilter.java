package com.gateway.filter;

import com.commons.utils.JwtUtils;
import com.commons.utils.MapUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/24 19:04
 */
@Component
@Slf4j
public class SimpleGlobalFilter implements GlobalFilter {

    @Resource
    private ReactiveStringRedisTemplate reactiveStringRedisTemplate;
    @Resource
    private ObjectMapper defaultObjectMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //判断当前请求是否为登录请求
        String path = request.getPath().toString();
        if (path.endsWith("/login")){
            log.info("当前请求为登录请求,直接放行");
            return chain.filter(exchange);
        }

        HttpHeaders headers = request.getHeaders();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<String> stringList = headers.get("x-jwt-token");
        if (stringList == null || stringList.size()==0){
            log.info("当前请求未携带JwtToken,直接放行");
            return chain.filter(exchange);
        }

        String strToken = stringList.get(0);
        try {
            boolean flag = JwtUtils.verify(strToken);
            if (flag){
                log.info("JwtToken合法,直接放行");
                return chain.filter(exchange);
            }
            log.info("JwtToken非法,请求被拦截");
            Mono<DataBuffer> dataBufferMono = responseError(response, "403", "请求非法");
            return response.writeWith(dataBufferMono);
        } catch (Exception e) {
            log.info("JwtToken非法,请求被拦截");
            Mono<DataBuffer> dataBufferMono = responseError(response, "403", "请求非法");
            return response.writeWith(dataBufferMono);
        }

    }



    @SneakyThrows
    public Mono<DataBuffer> responseError(ServerHttpResponse response, String code, String msg){
        Map<String, String> map = MapUtils.of("code", code, "msg", msg);
        String jsonStr = defaultObjectMapper.writeValueAsString(map);
        byte[] bytes = jsonStr.getBytes(StandardCharsets.UTF_8);
        DataBuffer dataBuffer = response.bufferFactory().wrap(bytes);
        return Mono.just(dataBuffer);
    }


}

package org.ncmao.filter;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOG.info("AccessToken executing ...");
        boolean flag = false;
        String token = request.getHeader("token");
        if (!StringUtils.isEmpty(token)) {
            flag = true;
        }
        if (!flag) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().print("AccessToken ERROR");
        }
        return flag;
    }
}

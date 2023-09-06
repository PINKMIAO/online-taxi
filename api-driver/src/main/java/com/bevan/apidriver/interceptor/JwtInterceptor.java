package com.bevan.apidriver.interceptor;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.bevan.internalcommon.constant.TokenConstants;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.TokenResult;
import com.bevan.internalcommon.util.JwtUtils;
import com.bevan.internalcommon.util.RedisPreFixUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author zbf
 * 2023/7/10 23:28
 */
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = true;
        String resultString = "";
        String token = request.getHeader("Authorization");

        TokenResult tokenResult = JwtUtils.checkToken(token);

        // 从redis中取出token
        if (null == tokenResult) {
            resultString = "token invalid";
            result = false;
        } else {
            String redisKey = RedisPreFixUtils.generatorTokenKey(tokenResult.getPhone(), tokenResult.getIdentity(),
                    TokenConstants.ACCESS_TOKEN_TYPE);
            String tokenRedis = stringRedisTemplate.opsForValue().get(redisKey);

            if ((StringUtils.isBlank(tokenRedis)) || (!token.trim().equals(tokenRedis.trim()))) {
                resultString = "token invalid";
                result = false;
            }
        }

        if (!result) {
            PrintWriter out = response.getWriter();
            out.println(ResponseResult.fail(resultString).toString());
        }


        return result;
    }
}

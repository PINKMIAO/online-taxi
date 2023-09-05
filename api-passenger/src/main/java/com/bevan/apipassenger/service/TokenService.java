package com.bevan.apipassenger.service;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.bevan.internalcommon.util.JwtUtils;
import com.bevan.internalcommon.util.RedisPreFixUtils;
import com.bevan.internalcommon.constant.CommonStatusEnum;
import com.bevan.internalcommon.constant.TokenConstants;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.TokenResponse;
import com.bevan.internalcommon.responese.TokenResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zbf
 * 2023/7/17 07:57
 */
@Service
public class TokenService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult refreshToken(String refreshTokenSrc) {
        // 解析 refresh
        TokenResult tokenResult = JwtUtils.checkToken(refreshTokenSrc);
        if (null == tokenResult) {
            return ResponseResult.fail(CommonStatusEnum.TOKEN_ERROR.getCode(), CommonStatusEnum.TOKEN_ERROR.getValue());
        }
        String phone = tokenResult.getPhone();
        String identity = tokenResult.getIdentity();

        // 获取 refreshToken
        String refreshTokenKey = RedisPreFixUtils.generatorTokenKey(phone, identity, TokenConstants.REFRESH_TOKEN_TYPE);
        String refreshTokenRedis = stringRedisTemplate.opsForValue().get(refreshTokenKey);

        // 校验
        if ((StringUtils.isBlank(refreshTokenRedis)) || !refreshTokenSrc.trim().equals(refreshTokenRedis.trim())) {
            return ResponseResult.fail(CommonStatusEnum.TOKEN_ERROR.getCode(), CommonStatusEnum.TOKEN_ERROR.getValue());
        }

        // 生产双Token
        String accessToken = JwtUtils.generatorToken(phone, identity, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken(phone, identity, TokenConstants.REFRESH_TOKEN_TYPE);

        // 再次存入Redis
        String accessTokenKey = RedisPreFixUtils.generatorTokenKey(phone, identity, TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey, accessToken, 30, TimeUnit.DAYS);
        stringRedisTemplate.opsForValue().set(refreshTokenKey, refreshToken, 30, TimeUnit.DAYS);

        // 返回
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);

        return ResponseResult.success(tokenResponse);
    }
}

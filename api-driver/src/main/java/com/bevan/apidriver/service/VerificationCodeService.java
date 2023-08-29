package com.bevan.apidriver.service;

import com.bevan.internalcommon.constant.CommonStatusEnum;
import com.bevan.internalcommon.constant.IdentityConstants;
import com.bevan.internalcommon.constant.TokenConstants;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.dto.VerificationCodeDto;
import com.bevan.internalcommon.responese.NumberCodeResponse;
import com.bevan.internalcommon.responese.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zbf
 * 2023/7/1 12:32
 */
@Service
public class VerificationCodeService {
    // @Autowired
    // private ServiceVerificationCodeClient serviceVerificationCodeClient;
    // @Autowired
    // private ServicePassengerUserClient servicePassengerUserClient;

    //官方推荐，如果kv是字符串的，就用这个StringRedisTemplate；如果是非字符串的就用RedisTemplate
    // @Autowired
    // private StringRedisTemplate stringRedisTemplate;

    public ResponseResult<Integer> generatorCode(String driverPhone) {
        // ResponseResult<NumberCodeResponse> response = serviceVerificationCodeClient.getNumberCode(6);
        // System.out.println("remote result: " + response.getData().getNumberCode());
        // int numberCode = response.getData().getNumberCode();

        // 存入redis
        // String key = RedisPreFixUtils.generatorKeyPhone(passengerPhone);
        // stringRedisTemplate.opsForValue().set(key, String.valueOf(numberCode), 2, TimeUnit.MINUTES);
        //
        // // 通过短信-发送短信到手机上
        //
        // return ResponseResult.success(numberCode);
        return ResponseResult.success(driverPhone);
    }

    public ResponseResult<TokenResponse> checkCode(String driverPhone, String verificationCode) {
        // // 根据手机号 获取redis里面的验证码
        // String key = RedisPreFixUtils.generatorKeyPhone(passengerPhone);
        // String value = stringRedisTemplate.opsForValue().get(key);
        // System.out.println("获取redis验证码：" + value);
        // // 校验验证码
        // if (null == value || !verificationCode.trim().equals(value.trim())) {
        //     return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),
        //             CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        // }
        //
        // // 判断原来是否有用户（按照目前这样，无论是否有，也都没有做结果处理），主要意思是无论是否有库里都要有这个手机账号
        // VerificationCodeDto verificationCodeDto = new VerificationCodeDto();
        // verificationCodeDto.setPassengerPhone(passengerPhone);
        // servicePassengerUserClient.loginOrRegister(verificationCodeDto);
        //
        // // 颁发令牌 使用jwt => json web token 官网 jwt.io
        // System.out.println("颁发令牌");
        // String accessToken = JwtUtils.generatorToken(passengerPhone, IdentityConstants.PASSENGER_IDENTITY,
        //         TokenConstants.ACCESS_TOKEN_TYPE);
        // String refreshToken = JwtUtils.generatorToken(passengerPhone, IdentityConstants.PASSENGER_IDENTITY,
        //         TokenConstants.REFRESH_TOKEN_TYPE);
        //
        // String accessTokenKey = RedisPreFixUtils.generatorTokenKey(passengerPhone, IdentityConstants.PASSENGER_IDENTITY,
        //         TokenConstants.ACCESS_TOKEN_TYPE);
        // stringRedisTemplate.opsForValue().set(accessTokenKey, accessToken, 30, TimeUnit.DAYS);
        // String refreshTokenKey = RedisPreFixUtils.generatorTokenKey(passengerPhone, IdentityConstants.PASSENGER_IDENTITY,
        //         TokenConstants.REFRESH_TOKEN_TYPE);
        // stringRedisTemplate.opsForValue().set(refreshTokenKey, refreshToken, 31, TimeUnit.DAYS);
        //
        // TokenResponse tokenResponse = new TokenResponse();
        // tokenResponse.setAccessToken(accessToken);
        // tokenResponse.setRefreshToken(refreshToken);
        // return ResponseResult.success(tokenResponse);
        return ResponseResult.success(driverPhone);
    }
}
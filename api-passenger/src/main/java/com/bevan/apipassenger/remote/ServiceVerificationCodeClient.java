package com.bevan.apipassenger.remote;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zbf
 * 2023/7/2 16:42
 */
@FeignClient("service-verificationcode")
public interface ServiceVerificationCodeClient {

    /**
     * 通过Feign 获得验证码
     * @param size 验证码长度
     * @return 返回统一返回值，内包含验证码
     */
    @RequestMapping(method = RequestMethod.GET, value = "/numberCode/{size}")
    ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable int size);

}

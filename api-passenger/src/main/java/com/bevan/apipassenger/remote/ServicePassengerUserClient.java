package com.bevan.apipassenger.remote;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.dto.VerificationCodeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zbf
 * 2023/7/9 17:51
 */
@FeignClient("service-passenger-user")
public interface ServicePassengerUserClient {

    /**
     * 判断是否存在这个手机号码，没有则默认注册
     * @param dto 乘客手机号和验证码的类
     * @return 统一的返回结果
     */
    @RequestMapping(method = RequestMethod.POST, value = "/passengerUser")
    ResponseResult loginOrRegister(@RequestBody VerificationCodeDto dto);

    /**
     * 获取到基本的用户信息
     * @param phone 用户的手机号码
     * @return 统一的返回结果
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getBaseInfo")
    ResponseResult getBaseInfo(@RequestParam("phone") String phone);

}

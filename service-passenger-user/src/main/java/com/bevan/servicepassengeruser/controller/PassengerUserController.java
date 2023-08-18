package com.bevan.servicepassengeruser.controller;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.dto.VerificationCodeDto;
import com.bevan.servicepassengeruser.service.PassengerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbf
 * 2023/7/4 00:01
 */
@RestController
public class PassengerUserController {
    @Autowired
    PassengerUserService passengerUserService;

    @PostMapping("/passengerUser")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDto dto) {
        String passengerPhone = dto.getPassengerPhone();
        System.out.println("user: 手机号：" + passengerPhone);
        return passengerUserService.loginOrReg(passengerPhone);
    }

    @GetMapping("/getBaseInfo")
    public ResponseResult getBaseInfo(@RequestParam("phone") String phone) {
        System.out.println("passengerUserController phone: " + phone);
        return passengerUserService.getBaseInfo(phone);
    }
}

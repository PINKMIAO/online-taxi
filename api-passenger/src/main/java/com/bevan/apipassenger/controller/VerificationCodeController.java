package com.bevan.apipassenger.controller;

import com.bevan.internalcommon.responese.TokenResponse;
import com.bevan.internalcommon.dto.VerificationCodeDto;
import com.bevan.apipassenger.service.VerificationCodeService;
import com.bevan.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * 2023/7/1 12:17
 */
@RestController
public class VerificationCodeController {
    @Autowired
    VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult<Integer> getVerificationCode(@RequestBody VerificationCodeDto dto) {
        System.out.println(dto.getPassengerPhone());
        return verificationCodeService.generatorCode(dto.getPassengerPhone());
    }

    @PostMapping("/verification-code-check")
    public ResponseResult<TokenResponse> checkVerificationCode(@RequestBody VerificationCodeDto dto) {
        String passengerPhone = dto.getPassengerPhone();
        String verificationCode = dto.getVerificationCode();

        System.out.println("phone: " + passengerPhone + ", code: " + verificationCode);
        return verificationCodeService.checkCode(passengerPhone, verificationCode);
    }

    @GetMapping("/forTest")
    public String forTest() {
        return "forTest";
    }
}

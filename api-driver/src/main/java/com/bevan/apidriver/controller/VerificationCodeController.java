package com.bevan.apidriver.controller;

import com.bevan.apidriver.service.VerificationCodeService;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.dto.VerificationCodeDto;
import com.bevan.internalcommon.responese.TokenResponse;
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
        System.out.println(dto.getDriverPhone());
        return verificationCodeService.generatorCode(dto.getDriverPhone());
    }

    @PostMapping("/verification-code-check")
    public ResponseResult<TokenResponse> checkVerificationCode(@RequestBody VerificationCodeDto dto) {
        String passengerPhone = dto.getPassengerPhone();
        String verificationCode = dto.getVerificationCode();

        System.out.println("phone: " + passengerPhone + ", code: " + verificationCode);
        return verificationCodeService.checkCode(passengerPhone, verificationCode);
    }
}

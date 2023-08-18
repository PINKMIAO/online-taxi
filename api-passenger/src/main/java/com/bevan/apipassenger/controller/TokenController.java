package com.bevan.apipassenger.controller;

import com.bevan.apipassenger.service.TokenService;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * 2023/7/17 07:55
 */
@RestController("/token")
public class TokenController {

    @Autowired
    TokenService tokenService;

    @PostMapping("/token-refresh")
    public ResponseResult refreshToken(@RequestBody TokenResponse response) {

        return tokenService.refreshToken(response.getRefreshToken());
    }
}

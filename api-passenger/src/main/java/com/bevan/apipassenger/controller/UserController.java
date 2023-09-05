package com.bevan.apipassenger.controller;

import com.bevan.apipassenger.service.UserService;
import com.bevan.internalcommon.util.JwtUtils;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.TokenResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zbf
 * 2023/7/23 17:09
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userBaseInfo")
    public ResponseResult getUserBaseInfo(HttpServletRequest request) {
        // 先拿到token
        String token = request.getHeader("Authorization");
        TokenResult tokenResult = JwtUtils.checkToken(token);

        String phone = tokenResult.getPhone();
        // 根据手机号进行查询对应的信息
        return userService.userBaseInfo(phone);
    }
}

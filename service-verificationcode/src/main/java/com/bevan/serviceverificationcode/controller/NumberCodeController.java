package com.bevan.serviceverificationcode.controller;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * 2023/7/2 00:21
 */
@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable Integer size) {
        System.out.println("size:" + size);
        int result = (int) ((Math.random() * 9 + 1) * (Math.pow(10, size - 1)));

        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(result);

        return ResponseResult.success(response);
    }
}

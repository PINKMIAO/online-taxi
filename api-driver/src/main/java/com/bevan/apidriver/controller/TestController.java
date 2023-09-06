package com.bevan.apidriver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * @since 2023/9/6 21:37
 */
@RestController
public class TestController {

    @GetMapping("/auth")
    public String forTest() {
        return "auth";
    }

    @GetMapping("/noAuth")
    public String forTest1() {
        return "noAuth";
    }

}

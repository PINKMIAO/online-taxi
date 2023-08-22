package com.bevan.apidriver.controller;

import com.bevan.apidriver.remote.ServiceDriverUserClient;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * 2023/8/18 07:57
 */
@RestController
public class DriverUserController {

    @GetMapping("/")
    public String forTest() {
        return "api-driver";
    }
    @GetMapping("/sum")
    public String for1Test() {
        return "api-driver";
    }

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    @PutMapping("/user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser) {
        return serviceDriverUserClient.updateDriverUser(driverUser);
    }
}

package com.bevan.apiboss.controller;

import com.bevan.apiboss.service.ApiBossService;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbf
 * 2023/8/14 11:07
 */
@RestController
public class ApiBossController {
    @Autowired
    private ApiBossService apiBossService;

    @GetMapping("/")
    public String forTest() {
        return "api-boss";
    }

    @GetMapping("/user")
    public ResponseResult<DriverUser> getDriverUser() {
        return apiBossService.getDriverUser();
    }

    @PostMapping("/user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser) {
        return apiBossService.addDriverUser(driverUser);
    }

    @PutMapping("/user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser) {
        return apiBossService.updateDriverUser(driverUser);
    }
}

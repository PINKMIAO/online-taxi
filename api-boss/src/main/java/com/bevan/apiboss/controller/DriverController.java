package com.bevan.apiboss.controller;

import com.bevan.apiboss.service.DriverService;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbf
 * 2023/8/14 11:07
 */
@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/")
    public String forTest() {
        return "api-boss";
    }

    @GetMapping("/user")
    public ResponseResult<DriverUser> getDriverUser() {
        return driverService.getDriverUser();
    }

    @PostMapping("/user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser) {
        return driverService.addDriverUser(driverUser);
    }

    @PutMapping("/user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser) {
        return driverService.updateDriverUser(driverUser);
    }
}

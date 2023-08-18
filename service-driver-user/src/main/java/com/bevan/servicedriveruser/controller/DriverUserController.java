package com.bevan.servicedriveruser.controller;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import com.bevan.servicedriveruser.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbf
 * 2023/8/14 07:35
 */
@RestController
public class DriverUserController {

    @Autowired
    private DriverUserService driverUserService;

    @GetMapping("/user")
    public ResponseResult<DriverUser> getDriverInfo() {
        return driverUserService.getUserInfo();
    }

    @PostMapping("/user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser) {
        return driverUserService.addDriver(driverUser);
    }

    @PutMapping("/user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser) {
        return driverUserService.updateDriver(driverUser);
    }
}

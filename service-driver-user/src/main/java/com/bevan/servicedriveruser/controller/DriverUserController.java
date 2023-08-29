package com.bevan.servicedriveruser.controller;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import com.bevan.internalcommon.responese.DriverUserExistsResponse;
import com.bevan.servicedriveruser.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zbf
 * 2023/8/14 07:35
 */
@RestController
public class DriverUserController {

    @Autowired
    private DriverUserService driverUserService;

    @GetMapping("/")
    public String forTest() {
        return "service-driver-user";
    }

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

    @GetMapping("/user/{driverPhone}")
    public ResponseResult<DriverUserExistsResponse> getUserByPhone(@PathVariable("driverPhone") String driverPhone) {
        ResponseResult<DriverUser> queryResult = driverUserService.getUserByPhone(driverPhone);
        DriverUser driverUser = queryResult.getData();

        DriverUserExistsResponse driverUserExistsResponse = new DriverUserExistsResponse();
        driverUserExistsResponse.setDriverPhone(driverUser.getDriverPhone());
        driverUserExistsResponse.setIsExists(1);
        return ResponseResult.success(driverUserExistsResponse);
    }
}

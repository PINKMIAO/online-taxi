package com.bevan.servicedriveruser.service;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import com.bevan.servicedriveruser.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zbf
 * 2023/8/14 07:36
 */
@Service
public class DriverUserService {
    @Autowired
    DriverUserMapper driverUserMapper;

    public ResponseResult<DriverUser> getUserInfo() {
        DriverUser driverUser = driverUserMapper.selectById(1);
        return ResponseResult.success(driverUser);
    }

    public ResponseResult addDriver(DriverUser driverUser) {
        LocalDateTime now = LocalDateTime.now();
        driverUser.setContractOn(now);
        driverUser.setContractOff(now);
        driverUserMapper.insert(driverUser);
        return ResponseResult.success();
    }

    public ResponseResult updateDriver(DriverUser driverUser) {
        driverUserMapper.updateById(driverUser);
        return ResponseResult.success();
    }
}

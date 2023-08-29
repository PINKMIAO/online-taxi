package com.bevan.servicedriveruser.service;

import com.bevan.internalcommon.constant.CommonStatusEnum;
import com.bevan.internalcommon.constant.DriverCarConstants;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import com.bevan.servicedriveruser.mapper.DriverUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

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

    public ResponseResult<DriverUser> getUserByPhone(String driverPhone) {
        HashMap<String, Object> queryMap = new HashMap<>();
        queryMap.put("driver_phone", driverPhone);
        queryMap.put("state", DriverCarConstants.DRIVER_STATE_VALID);
        List<DriverUser> driverUsers = driverUserMapper.selectByMap(queryMap);
        if (driverUsers.isEmpty()) {
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXISTS.getCode(), CommonStatusEnum.DRIVER_NOT_EXISTS.getValue());
        }

        return ResponseResult.success(driverUsers.get(0));
    }
}

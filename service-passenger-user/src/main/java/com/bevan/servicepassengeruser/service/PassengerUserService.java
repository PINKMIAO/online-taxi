package com.bevan.servicepassengeruser.service;

import com.bevan.internalcommon.constant.CommonStatusEnum;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.servicepassengeruser.model.PassengerUser;
import com.bevan.servicepassengeruser.mapper.PassengerUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author zbf
 * 2023/7/4 00:05
 */
@Service
public class PassengerUserService {
    @Autowired
    private PassengerUserMapper passengerUserMapper;

    public ResponseResult loginOrReg(String passengerPhone) {
        System.out.println("userService: 手机号：" + passengerPhone);
        // 根据手机号查询用户信息
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("passenger_phone", passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
        System.out.println(passengerUsers.isEmpty() ? "无记录" : passengerUsers.get(0).getPassengerName());

        // 判断用户信息是否存在
        if (passengerUsers.isEmpty()) {
            // 如果不存在，插入用户信息
            PassengerUser passengerUser = new PassengerUser();
            passengerUser.setPassengerGender((byte) 0);
            passengerUser.setPassengerPhone(passengerPhone);
            passengerUser.setPassengerName(passengerPhone);
            passengerUser.setState((byte) 0);
            passengerUserMapper.insert(passengerUser);
        }

        return ResponseResult.success();
    }

    public ResponseResult getBaseInfo(String passengerPhone) {
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("passenger_phone", passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
        if (passengerUsers.isEmpty()) {
            return ResponseResult.fail(CommonStatusEnum.USER_NOT_EXISTS.getCode(), CommonStatusEnum.USER_NOT_EXISTS.getValue());
        }
        return ResponseResult.success(passengerUsers.get(0));
    }
}

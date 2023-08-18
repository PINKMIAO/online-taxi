package com.bevan.apipassenger.service;

import com.bevan.apipassenger.remote.ServicePassengerUserClient;
import com.bevan.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zbf
 * 2023/7/23 17:17
 */
@Service
public class UserService {

    @Autowired
    ServicePassengerUserClient servicePassengerUserClient;

    public ResponseResult userBaseInfo(String phone) {
        return servicePassengerUserClient.getBaseInfo(phone);
    }
}

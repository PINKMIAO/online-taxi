package com.bevan.apiboss.service;

import com.bevan.apiboss.remote.ServiceDriverUserClient;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zbf
 * 2023/8/14 14:01
 */
@Service
public class ApiBossService {

    @Autowired
    private ServiceDriverUserClient driverUserClient;

    public ResponseResult<DriverUser> getDriverUser() {
        return driverUserClient.getDriverUserInfo();
    }

    public ResponseResult addDriverUser(DriverUser driverUser) {
        return driverUserClient.addDriverUser(driverUser);
    }

    public ResponseResult updateDriverUser(DriverUser driverUser) {
        return driverUserClient.updateDriverUser(driverUser);
    }
}

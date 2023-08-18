package com.bevan.apidriver.remote;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zbf
 * 2023/8/14 13:58
 */
@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {
    /**
     * 更新出租车司机信息
     * @param driverUser 司机信息
     * @return 0/1
     */
    @PutMapping("/user")
    ResponseResult updateDriverUser(@RequestBody DriverUser driverUser);
}

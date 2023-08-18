package com.bevan.apiboss.remote;

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
     * 获取司机信息
     * @return 司机信息
     */
    @GetMapping("/user")
    ResponseResult<DriverUser> getDriverUserInfo();

    /**
     * 新增司机信息
     * @param driverUser 司机信息
     * @return 0/1
     */
    @PostMapping("/user")
    ResponseResult addDriverUser(@RequestBody DriverUser driverUser);

    /**
     * 更新出租车司机信息
     * @param driverUser 司机信息
     * @return 0/1
     */
    @PutMapping("/user")
    ResponseResult updateDriverUser(@RequestBody DriverUser driverUser);
}

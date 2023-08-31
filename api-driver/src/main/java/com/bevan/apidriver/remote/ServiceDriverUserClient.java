package com.bevan.apidriver.remote;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverUser;
import com.bevan.internalcommon.responese.DriverUserExistsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据电话号码获取到司机信息
     * @param driverPhone 司机电话号码
     * @return 司机信息
     */
    @GetMapping("/user/{driverPhone}")
    ResponseResult<DriverUserExistsResponse> getUserByPhone(@PathVariable("driverPhone") String driverPhone);
}

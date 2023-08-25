package com.bevan.servicedriveruser.service;

import com.bevan.internalcommon.constant.CommonStatusEnum;
import com.bevan.internalcommon.constant.DriverCarConstants;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverCarBindingRelations;
import com.bevan.servicedriveruser.mapper.DriverCarBindingRelationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author zbf
 * @since 2023/8/22 08:09
 */
@Service
public class DriverCarBindingRelationsService {
    @Autowired
    private DriverCarBindingRelationsMapper driverCarBindingRelationsMapper;

    public ResponseResult addBind(DriverCarBindingRelations driverCarBindingRelations) {
        LocalDateTime now = LocalDateTime.now();
        Map<String, Object> query = new HashMap<>(16);
        query.put("driver_id", driverCarBindingRelations.getDriverId());
        query.put("car_id", driverCarBindingRelations.getCarId());
        query.put("state", DriverCarConstants.DRIVER_CAR_BIND);
        List<DriverCarBindingRelations> queryResults = driverCarBindingRelationsMapper.selectByMap(query);
        if (!queryResults.isEmpty()) {
            return ResponseResult.fail(CommonStatusEnum.DRIVER_CAR_BIND_EXISTS.getCode(),
                    CommonStatusEnum.DRIVER_CAR_BIND_EXISTS.getValue());
        }

        driverCarBindingRelations.setState(DriverCarConstants.DRIVER_CAR_BIND);
        driverCarBindingRelations.setBindingTime(now);
        driverCarBindingRelationsMapper.insert(driverCarBindingRelations);
        return ResponseResult.success();
    }

    public ResponseResult unbind(DriverCarBindingRelations driverCarBindingRelations) {

        return ResponseResult.success();
    }
}

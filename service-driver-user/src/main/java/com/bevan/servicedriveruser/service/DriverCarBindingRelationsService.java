package com.bevan.servicedriveruser.service;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverCarBindingRelations;
import com.bevan.servicedriveruser.mapper.DriverCarBindingRelationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zbf
 * @since 2023/8/22 08:09
 */
@Service
public class DriverCarBindingRelationsService {
    @Autowired
    private DriverCarBindingRelationsMapper driverCarBindingRelationsMapper;

    public ResponseResult addBind(DriverCarBindingRelations driverCarBindingRelations) {
        driverCarBindingRelations.setState(0);
        driverCarBindingRelationsMapper.insert(driverCarBindingRelations);
        return ResponseResult.success();
    }

}

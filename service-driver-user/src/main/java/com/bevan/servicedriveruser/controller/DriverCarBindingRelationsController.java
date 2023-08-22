package com.bevan.servicedriveruser.controller;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverCarBindingRelation;
import com.bevan.servicedriveruser.service.DriverCarBindingRelationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 司机与车辆绑定关系表 前端控制器
 * </p>
 *
 * @author bevan
 * @since 2023-08-22
 */
@RestController
public class DriverCarBindingRelationsController {
    @Autowired
    private DriverCarBindingRelationsService driverCarBindingRelationsService;

    @GetMapping("/bind")
    public ResponseResult addBind(DriverCarBindingRelation driverCarBindingRelation) {
        return driverCarBindingRelationsService.addBind(driverCarBindingRelation);
    }
}

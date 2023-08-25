package com.bevan.servicedriveruser.controller;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverCarBindingRelations;
import com.bevan.servicedriveruser.service.DriverCarBindingRelationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/bind")
    public ResponseResult addBind(@RequestBody DriverCarBindingRelations driverCarBindingRelations) {
        return driverCarBindingRelationsService.addBind(driverCarBindingRelations);
    }

    @PostMapping("/unbind")
    public ResponseResult unBind(@RequestBody DriverCarBindingRelations driverCarBindingRelations) {
        return driverCarBindingRelationsService.unbind(driverCarBindingRelations);
    }
}

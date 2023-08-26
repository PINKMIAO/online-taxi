package com.bevan.apiboss.controller;

import com.bevan.apiboss.service.DriverCarBindingRelationsService;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverCarBindingRelations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * @since 2023/8/26 16:30
 */
@RestController
public class DriverCarBindingRelationsController {
    @Autowired
    private DriverCarBindingRelationsService bindingRelationsService;

    @PostMapping("/bind")
    public ResponseResult bind(@RequestBody DriverCarBindingRelations driverCarBindingRelations) {
        return bindingRelationsService.addBind(driverCarBindingRelations);
    }

    @PostMapping("/unbind")
    public ResponseResult unbind(@RequestBody DriverCarBindingRelations driverCarBindingRelations) {
        return bindingRelationsService.unBind(driverCarBindingRelations);
    }
}

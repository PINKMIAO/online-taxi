package com.bevan.apiboss.service;

import com.bevan.apiboss.remote.ServiceDriverUserClient;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.DriverCarBindingRelations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zbf
 * @since 2023/8/26 16:35
 */
@Service
public class DriverCarBindingRelationsService {
    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult addBind(@RequestBody DriverCarBindingRelations driverCarBindingRelations) {
        return serviceDriverUserClient.addBind(driverCarBindingRelations);
    }

    public ResponseResult unBind(@RequestBody DriverCarBindingRelations driverCarBindingRelations) {
        return serviceDriverUserClient.unBind(driverCarBindingRelations);
    }
}

package com.bevan.apiboss.service;

import com.bevan.apiboss.remote.ServiceDriverUserClient;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zbf
 * @since 2023/8/26 16:34
 */
@Service
public class CarService {
    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    public ResponseResult<Car> getCar() {
        return serviceDriverUserClient.getCar();
    }

    public ResponseResult addCar(@RequestBody Car car) {
        return serviceDriverUserClient.addCar(car);
    }

}

package com.bevan.servicedriveruser.controller;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.Car;
import com.bevan.servicedriveruser.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bevan
 * @since 2023-08-18
 */
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/car")
    public ResponseResult<Car> getCar() {
        return carService.getCar();
    }

    @PostMapping("/car")
    public ResponseResult addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

}

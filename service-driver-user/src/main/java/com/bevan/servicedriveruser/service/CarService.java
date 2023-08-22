package com.bevan.servicedriveruser.service;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.model.Car;
import com.bevan.servicedriveruser.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author zbf
 * @since 2023/8/18 11:00
 */
@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    public ResponseResult<Car> getCar() {
        Car car = new Car();
        car.setId(1584359540577861633L);
        Car result = carMapper.selectById(car);
        return ResponseResult.success(result);
    }

    public ResponseResult addCar(Car car) {
        LocalDateTime now = LocalDateTime.now();
        car.setGmtCreate(now);
        car.setGmtModified(now);
        carMapper.insert(car);
        return ResponseResult.success();
    }
}

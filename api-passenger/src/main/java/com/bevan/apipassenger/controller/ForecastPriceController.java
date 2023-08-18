package com.bevan.apipassenger.controller;

import com.bevan.apipassenger.remote.ServicePriceClient;
import com.bevan.apipassenger.service.ForecastPriceService;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.dto.ForecastPriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * 2023/7/25 08:10
 */
@RestController
@Slf4j
public class ForecastPriceController {
    @Autowired
    private ForecastPriceService forecastPriceService;

    @PostMapping("/forecast-price")
    public ResponseResult forecastPrice(@RequestBody ForecastPriceDto forecastPriceDto) {
        String depLongitude = forecastPriceDto.getDepLongitude();
        String depLatitude = forecastPriceDto.getDepLatitude();
        String desLongitude = forecastPriceDto.getDesLongitude();
        String desLatitude = forecastPriceDto.getDesLatitude();


        return forecastPriceService.getForecastPrice(depLongitude, depLatitude, desLongitude, desLatitude);
    }
}

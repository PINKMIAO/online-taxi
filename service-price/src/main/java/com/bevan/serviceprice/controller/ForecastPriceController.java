package com.bevan.serviceprice.controller;

import com.bevan.internalcommon.dto.ForecastPriceDto;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.serviceprice.service.ForecastPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * 2023/7/26 08:01
 */
@RestController
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

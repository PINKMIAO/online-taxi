package com.bevan.servicemap.controller;

import com.bevan.internalcommon.dto.ForecastPriceDto;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.servicemap.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * 2023/7/26 08:27
 */
@RestController
@RequestMapping(("/direction"))
public class DirectionController {
    @Autowired
    private DirectionService directionService;

    @GetMapping("/driving")
    public ResponseResult driving(@RequestBody ForecastPriceDto forecastPriceDto) {
        String depLongitude = forecastPriceDto.getDepLongitude();
        String depLatitude = forecastPriceDto.getDepLatitude();
        String desLongitude = forecastPriceDto.getDesLongitude();
        String desLatitude = forecastPriceDto.getDesLatitude();
        return directionService.driving(depLongitude, depLatitude, desLongitude, desLatitude);
    }


}

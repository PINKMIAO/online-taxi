package com.bevan.serviceprice.remote;

import com.bevan.internalcommon.dto.ForecastPriceDto;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.DirectionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zbf
 * 2023/7/30 23:11
 */
@FeignClient("service-map")
public interface ServiceMapClient {

    @GetMapping("/direction/driving")
    ResponseResult<DirectionResponse> driving(@RequestBody ForecastPriceDto forecastPriceDto);
}

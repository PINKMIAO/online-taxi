package com.bevan.apipassenger.remote;

import com.bevan.internalcommon.dto.ForecastPriceDto;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.ForecastPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zbf
 * 2023/8/1 19:34
 */
@FeignClient("service-price")
public interface ServicePriceClient {

    /**
     * 估算价格
     * @param forecastPriceDto 出发地和目的地的经纬度
     * @return 估算值
     */
    @PostMapping("/forecast-price")
    ResponseResult<ForecastPriceResponse> forecastPrice(@RequestBody ForecastPriceDto forecastPriceDto);
}

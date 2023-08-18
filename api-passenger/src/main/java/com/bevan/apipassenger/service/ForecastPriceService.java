package com.bevan.apipassenger.service;

import com.bevan.apipassenger.remote.ServicePriceClient;
import com.bevan.internalcommon.dto.ForecastPriceDto;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.ForecastPriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zbf
 * 2023/7/25 08:17
 */
@Service
@Slf4j
public class ForecastPriceService {
    @Autowired
    private ServicePriceClient servicePriceClient;

    public ResponseResult getForecastPrice(String depLongitude, String depLatitude, String desLongitude, String desLatitude) {
        log.info("客户端接受用户出发地和目的地：");
        log.info("出发地经度：" + depLongitude);
        log.info("出发地纬度：" + depLatitude);
        log.info("目的地经度：" + desLongitude);
        log.info("目的地纬度：" + desLatitude);

        log.info("调用价格估算服务");
        ForecastPriceDto forecastPriceDto = new ForecastPriceDto();
        forecastPriceDto.setDepLongitude(depLongitude);
        forecastPriceDto.setDepLatitude(depLatitude);
        forecastPriceDto.setDesLongitude(desLongitude);
        forecastPriceDto.setDesLatitude(desLatitude);
        ResponseResult<ForecastPriceResponse> responseResult = servicePriceClient.forecastPrice(forecastPriceDto);
        Double price = responseResult.getData().getPrice();
        log.info("预估价格为：" + price);

        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);
        return ResponseResult.success(forecastPriceResponse);
    }
}

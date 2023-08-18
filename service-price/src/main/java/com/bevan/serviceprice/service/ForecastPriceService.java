package com.bevan.serviceprice.service;

import com.bevan.internalcommon.constant.CommonStatusEnum;
import com.bevan.internalcommon.dto.ForecastPriceDto;
import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.DirectionResponse;
import com.bevan.internalcommon.responese.ForecastPriceResponse;
import com.bevan.internalcommon.util.BigDecimalUtils;
import com.bevan.serviceprice.mapper.PriceRuleMapper;
import com.bevan.serviceprice.model.PriceRule;
import com.bevan.serviceprice.remote.ServiceMapClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author zbf
 * 2023/7/26 08:03
 */
@Service
@Slf4j
public class ForecastPriceService {
    @Autowired
    private ServiceMapClient serviceMapClient;
    @Autowired
    private PriceRuleMapper priceRuleMapper;

    public ResponseResult getForecastPrice(String depLongitude, String depLatitude, String desLongitude, String desLatitude) {
        log.info("估算服务接受用户出发地和目的地：");
        log.info("出发地经度：" + depLongitude);
        log.info("出发地纬度：" + depLatitude);
        log.info("目的地经度：" + desLongitude);
        log.info("目的地纬度：" + desLatitude);

        ForecastPriceDto forecastPriceDto = new ForecastPriceDto();
        forecastPriceDto.setDepLongitude(depLongitude);
        forecastPriceDto.setDepLatitude(depLatitude);
        forecastPriceDto.setDesLongitude(desLongitude);
        forecastPriceDto.setDesLatitude(desLatitude);
        log.info("调用地图服务");
        ResponseResult<DirectionResponse> forecastResult = serviceMapClient.driving(forecastPriceDto);
        Integer duration = forecastResult.getData().getDuration();
        Integer distance = forecastResult.getData().getDistance();

        log.info("distance: " + distance + ", duration" + duration);

        log.info("读取计价规则");
        HashMap<String, Object> queryMap = new HashMap<>(16);
        queryMap.put("city_code", "11000");
        queryMap.put("vehicle_type", "1");
        List<PriceRule> priceRules = priceRuleMapper.selectByMap(queryMap);
        if (0 == priceRules.size()) {
            return ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(), CommonStatusEnum.PRICE_RULE_EMPTY.getValue());
        }
        PriceRule priceRule = priceRules.get(0);

        log.info("根据举、时常和计价规则，计算价格");
        Double price = getPrice(duration, distance, priceRule);

        ForecastPriceResponse forecastPriceResponse = new ForecastPriceResponse();
        forecastPriceResponse.setPrice(price);
        return ResponseResult.success(forecastPriceResponse);
    }

    private Double getPrice(Integer duration, Integer distance, PriceRule priceRule) {
        double price = 0;
        // 起步价
        price = BigDecimalUtils.add(price, priceRule.getStartFare());
        // 里程费 - 将获取的距离m转换成km
        double distanceMile = BigDecimalUtils.divide(distance, 1000);
        double distanceSubtract = BigDecimalUtils.subtract(distanceMile, priceRule.getStartMile());
        distanceSubtract = distanceSubtract > 0 ? distanceSubtract : 0;
        double distancePrice = BigDecimalUtils.multiply(distanceSubtract, priceRule.getUnitPricePerMile());
        price = BigDecimalUtils.add(price, distancePrice);

        // 时常费
        double time = BigDecimalUtils.divide(duration, 60);
        double timePrice = BigDecimalUtils.multiply(time, priceRule.getUnitPricePerMinute());
        price = BigDecimalUtils.add(price, timePrice);

        return price;
    }
}

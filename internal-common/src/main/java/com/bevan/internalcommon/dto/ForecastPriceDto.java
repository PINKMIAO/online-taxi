package com.bevan.internalcommon.dto;

import lombok.Data;

/**
 * @author zbf
 * 2023/7/25 08:14
 */
@Data
public class ForecastPriceDto {
    private String depLongitude;
    private String depLatitude;
    private String desLongitude;
    private String desLatitude;
}

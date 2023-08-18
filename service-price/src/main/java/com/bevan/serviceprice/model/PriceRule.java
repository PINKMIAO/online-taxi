package com.bevan.serviceprice.model;

import lombok.Data;

/**
 * @author zbf
 * 2023/7/31 07:49
 */
@Data
public class PriceRule {
    private String cityCode;
    private String vehicleType;
    private Double startFare;
    private Integer startMile;
    private Double unitPricePerMile;
    private Double unitPricePerMinute;
}

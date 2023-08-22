package com.bevan.internalcommon.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 司机与车辆绑定关系表
 * </p>
 *
 * @author bevan
 * @since 2023-08-22
 */
@Data
public class DriverCarBindingRelation implements Serializable {
    private Long id;

    /**
     * 司机Id
     */
    private Long driverId;

    /**
     * 车辆ID
     */
    private Long carId;

    /**
     * 绑定状态
     */
    private Integer state;

    /**
     * 绑定时间
     */
    private LocalDateTime bindingTime;

    /**
     * 解绑时间
     */
    private LocalDateTime unBindingTime;
}

package com.bevan.internalcommon.responese;

import lombok.Data;

/**
 * @author zbf
 * @since 2023/8/29 08:13
 */
@Data
public class DriverUserExistsResponse {
    private String driverPhone;

    private Boolean isExists;
}

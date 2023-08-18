package com.bevan.internalcommon.model;

import lombok.Data;

/**
 * @author zbf
 * 2023/8/3 08:16
 */
@Data
public class DicDistrict {
    private String addressCode;
    private String addressName;
    private String parentAddressCode;
    private Integer level;
}

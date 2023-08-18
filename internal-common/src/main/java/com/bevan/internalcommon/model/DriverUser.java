package com.bevan.internalcommon.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * driver_user
 * @author bevan
 */
@Data
public class DriverUser implements Serializable {
    /**
     * 公司标识
     */
    private Long id;

    /**
     * 注册地行政区划代码
     */
    private String address;

    /**
     * 机动车驾驶员姓名
     */
    private String driverName;

    /**
     * 驾驶员手机号
     */
    private String driverPhone;

    /**
     * 驾驶员性别
     */
    private Byte driverGender;

    /**
     * 出生日期
     */
    private LocalDate driverBirthday;

    /**
     * 驾驶员民族
     */
    private String driverNation;

    /**
     * 驾驶员通信地址
     */
    private String driverContactAddress;

    /**
     * 机动车驾驶证号
     */
    private String licenseId;

    /**
     * 初次领取驾驶证日期
     */
    private LocalDate getDriverLicenseDate;

    /**
     * 驾驶证有效期限起
     */
    private LocalDate driverLicenseOn;

    /**
     * 驾驶证有效期限止
     */
    private LocalDate driverLicenseOff;

    /**
     * 是否巡游出租汽车驾驶员；0否 1是
     */
    private Byte taxiDriver;

    /**
     * 网络预约出租汽车驾驶员资格证号
     */
    private String certificateNo;

    /**
     * 网络预约出租汽车驾驶员证发证机构
     */
    private String networkCarIssueOrganization;

    /**
     * 资格证发证日期
     */
    private LocalDate networkCarIssueDate;

    /**
     * 初次领取资格证日期
     */
    private LocalDate getNetworkCarProofDate;

    /**
     * 资格证有效起始日期
     */
    private LocalDate networkCarProofOn;

    /**
     * 资格证有效截止日期
     */
    private LocalDate networkCarProofOff;

    /**
     * 报备日期
     */
    private LocalDate registerDate;

    /**
     * 1:网络预约出租汽车
     * 2:巡游出租汽车
     * 3:私人小客车合乘
     */
    private Byte commercialType;

    /**
     * 驾驶员合同（或协议）签署公司
     */
    private String contractCompany;

    /**
     * 合同(或协议)有效期起
     */
    private LocalDateTime contractOn;

    /**
     * 合同(或协议)有效期止
     */
    private LocalDateTime contractOff;

    /**
     * 0：有效 1：失效
     */
    private Byte state;

    private static final long serialVersionUID = 1L;
}
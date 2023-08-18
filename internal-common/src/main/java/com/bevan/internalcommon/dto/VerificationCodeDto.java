package com.bevan.internalcommon.dto;

import lombok.Data;

/**
 * @author zbf
 * 2023/7/1 12:20
 */
@Data
public class VerificationCodeDto {
    private String passengerPhone;
    private String verificationCode;
}

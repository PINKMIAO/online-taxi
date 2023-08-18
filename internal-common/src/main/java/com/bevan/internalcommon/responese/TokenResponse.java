package com.bevan.internalcommon.responese;

import lombok.Data;

/**
 * @author zbf
 * 2023/7/2 01:30
 */
@Data
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
}

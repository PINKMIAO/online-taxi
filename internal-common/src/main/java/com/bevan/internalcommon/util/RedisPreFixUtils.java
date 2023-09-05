package com.bevan.internalcommon.util;

/**
 * @author zbf
 * 2023/7/11 08:00
 */
public class RedisPreFixUtils {
    private static final String VERIFICATION_CODE_PREFIX = "verification-code-";
    private static final String TOKEN_PREFIX = "token-";

    public static String generatorKeyByPhone(String userPhone, String identity) {
        return VERIFICATION_CODE_PREFIX + identity + "-" + userPhone;
    }

    public static String generatorTokenKey(String passengerPhone, String identity, String tokenType) {
        return TOKEN_PREFIX + passengerPhone + "-" + identity + "-" + tokenType;
    }
}

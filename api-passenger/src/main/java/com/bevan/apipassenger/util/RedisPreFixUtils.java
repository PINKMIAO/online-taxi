package com.bevan.apipassenger.util;

/**
 * @author zbf
 * 2023/7/11 08:00
 */
public class RedisPreFixUtils {

    private static final String VERIFICATION_CODE_PREFIX = "passenger-verification-code-";
    private static final String TOKEN_PREFIX = "token-";

    public static String generatorKeyPhone(String passengerPhone) {
        return VERIFICATION_CODE_PREFIX + passengerPhone;
    }

    public static String generatorTokenKey(String passengerPhone, String identity, String tokenType) {
        return TOKEN_PREFIX + passengerPhone + "-" + identity + "-" + tokenType;
    }
}

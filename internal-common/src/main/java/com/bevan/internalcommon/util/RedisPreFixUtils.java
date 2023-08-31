package com.bevan.internalcommon.util;

/**
 * @author zbf
 * 2023/7/11 08:00
 */
public class RedisPreFixUtils {

    private static final String VERIFICATION_CODE_PASSENGER_PREFIX = "passenger-verification-code-";
    private static final String VERIFICATION_CODE_DRIVER_PREFIX = "driver-verification-code-";
    private static final String TOKEN_PREFIX = "token-";

    public static String generatorKeyByPassengerPhone(String passengerPhone) {
        return VERIFICATION_CODE_PASSENGER_PREFIX + passengerPhone;
    }

    public static String generatorKeyByDriverPhone(String driverPhone) {
        return VERIFICATION_CODE_DRIVER_PREFIX + driverPhone;
    }

    public static String generatorTokenKey(String passengerPhone, String identity, String tokenType) {
        return TOKEN_PREFIX + passengerPhone + "-" + identity + "-" + tokenType;
    }
}

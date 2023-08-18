package com.bevan.internalcommon.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zbf
 * 2023/8/1 16:54
 */
public class BigDecimalUtils {
    public static double add(double v1, double v2) {
        BigDecimal d1 = BigDecimal.valueOf(v1);
        BigDecimal d2 = BigDecimal.valueOf(v2);

        return d1.add(d2).doubleValue();
    }

    public static double subtract(double v1, double v2) {
        BigDecimal d1 = BigDecimal.valueOf(v1);
        BigDecimal d2 = BigDecimal.valueOf(v2);

        return d1.subtract(d2).doubleValue();
    }

    public static double multiply(double v1, double v2) {
        BigDecimal d1 = BigDecimal.valueOf(v1);
        BigDecimal d2 = BigDecimal.valueOf(v2);

        return d1.multiply(d2).setScale(2, RoundingMode.CEILING).doubleValue();
    }

    public static double divide(double v1, double v2) {
        if (0 >= v2) {
            throw new IllegalArgumentException("除数非法");
        }

        BigDecimal d1 = BigDecimal.valueOf(v1);
        BigDecimal d2 = BigDecimal.valueOf(v2);

        return d1.divide(d2, 2, RoundingMode.CEILING).doubleValue();
    }
}

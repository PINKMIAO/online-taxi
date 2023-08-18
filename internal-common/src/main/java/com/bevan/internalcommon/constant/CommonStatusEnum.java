package com.bevan.internalcommon.constant;

import lombok.Data;
import lombok.Getter;

/**
 * @author zbf
 * 2023/7/2 01:16
 */
public enum CommonStatusEnum {
    /**
     * 验证码提示错误：1000-1099
     */
    VERIFICATION_CODE_ERROR(1099, "验证码错误"),
    /**
     * Token类提示错误：1100-1199
     */
    TOKEN_ERROR(1099, "Token错误"),

    /**
     * 用户不存在：1200 -1299
     */
    USER_NOT_EXISTS(1200, "当前用户不存在"),

    /**
     * 计价规则：1300-1399
     */
    PRICE_RULE_EMPTY(1300, "计价规则不存在"),


    SUCCESS(1, "success"),
    FAIL(0, "fail");


    @Getter
    private int code;
    @Getter
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}

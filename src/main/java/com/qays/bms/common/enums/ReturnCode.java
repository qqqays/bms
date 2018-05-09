package com.qays.bms.common.enums;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-25-2018 9:16
 */

public enum ReturnCode {
    SUCCESS(1, "success"),
    UNKNOWN_ERROR(-1, "Servers internal error"),
    PARAM_ERROR(-2, "Params error"),
    UNMATCHED_METHOD(-3, "No method matched error"),
    VALID_ERROR(-4, "The param verification failed"),
    PRINCIPAL_NOT_FIND(-5, "Can not find the user information in session!"),
    PASSWORD_ERROR(-6, "Password incorrect"),
    EXECUTE_ERROR(-7,"Executed failed"),
    UNMATCHED_SYSTEM(-8,"Can not match the system initialed"),
    DELETE_SYSTEM_FILE(-9,"Can not delete system file");

    private Integer code;

    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

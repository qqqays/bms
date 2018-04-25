package com.qays.bms.common.exception;

import com.qays.bms.common.enums.ReturnCode;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-25-2018 9:21
 */

public class CustomException extends RuntimeException {

    private ReturnCode rc;

    CustomException(ReturnCode rc) {
        super();
        this.rc = rc;
    }

    public ReturnCode getRc() {
        return rc;
    }

    public void setRc(ReturnCode rc) {
        this.rc = rc;
    }
}

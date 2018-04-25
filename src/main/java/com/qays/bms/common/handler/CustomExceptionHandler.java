package com.qays.bms.common.handler;

import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.common.exception.CustomException;
import com.qays.bms.common.util.O2JUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-25-2018 9:26
 */
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handle(Exception e) {
        if (e instanceof CustomException) {
            CustomException ce = (CustomException) e;
            return O2JUtil.dataAndCode(ce.getRc());
        } else {
            log.error("[System exception] {}", e);
            return O2JUtil.dataAndCode(ReturnCode.UNKNOWN_ERROR);
        }

    }
}

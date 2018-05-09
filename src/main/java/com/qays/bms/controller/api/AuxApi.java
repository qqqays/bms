package com.qays.bms.controller.api;

import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.common.util.FileUtil;
import com.qays.bms.common.util.O2JUtil;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-08-2018 17:09
 */

public interface AuxApi {
    default String jointPath(String head, String tail) {
        return FileUtil.joint(head, tail);
    }

    default String code(ReturnCode rc) {
        return O2JUtil.dataAndCode(rc);
    }
}

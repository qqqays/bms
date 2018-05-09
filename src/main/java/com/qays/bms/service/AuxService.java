package com.qays.bms.service;

import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.common.util.FileUtil;
import com.qays.bms.common.util.O2JUtil;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-09-2018 13:15
 */

public interface AuxService {
    default String jointPath(String head, String tail) {
        return FileUtil.joint(head, tail);
    }

    default String code(ReturnCode rc) {
        return O2JUtil.dataAndCode(rc);
    }

    default String code(ReturnCode rc, Object o) {
        return O2JUtil.dataAndCode(rc, o);
    }

    default boolean checkDir(String path) {
        return FileUtil.checkDir(path);
    }
}

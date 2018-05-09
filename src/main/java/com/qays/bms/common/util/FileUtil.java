package com.qays.bms.common.util;

import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.common.exception.CustomException;

import java.io.File;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-08-2018 17:02
 */

public class FileUtil {

    public static String joint(String head, String tail) {

        String var0 = head.replace("\\", "/");
        String var1 = tail.replace("\\", "/");

        if (var0.endsWith("/") && var1.startsWith("/")) {
            return var0 + var1.substring(1);
        } else if (var0.endsWith("/") ^ var1.startsWith("/")) {
            return var0 + var1;
        } else {
            return var0 + "/" + var1;
        }
    }

    public static boolean checkDir(String path) {
        File file = new File(path);

        if (file.exists() && file.isDirectory()) {
            return true;
        } else {
            return file.mkdir();
        }
    }

}

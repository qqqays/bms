package com.qays.bms.common.util;

import com.qays.bms.common.enums.ReturnCode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-25-2018 9:36
 */

public class O2JUtil {

    public static Object isNullData(Object data) {
        if (data == null) return "null of data";
        return data;
    }

    public static String list2JsonStr(Collection list) {
        return new JSONArray(list).toString();
    }

    public static String set2JsonStr(Collection set) {
        return list2JsonStr(set);
    }

    public static String map2JsonStr(Map map) {
        return new JSONObject(map).toString();
    }

    /**
     * Transforms data to json string after attaching the code and message
     *
     * @param rc return code
     * @param data object
     * @return json string
     */
    public static String dataAndCode(ReturnCode rc, Object data) {
        return dataAndCode(rc.getCode(), rc.getMsg(), data);
    }

    public static String dataAndCode(ReturnCode rc) {
        return dataAndCode(rc.getCode(), rc.getMsg(), null);
    }

    public static String dataAndCode(Integer code, String msg, Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status-code: ", code);
        jsonObject.put("message: ", msg);
        jsonObject.put("data", isNullData(data));

        return jsonObject.toString();
    }
}

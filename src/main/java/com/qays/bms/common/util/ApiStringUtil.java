package com.qays.bms.common.util;

import com.github.pagehelper.PageInfo;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-05-2018 15:11
 */

public interface ApiStringUtil {

    default String list2JsonStr(Collection list){
        return O2JUtil.list2JsonStr(list);
    }

    default String set2JsonStr(Collection set){
        return list2JsonStr(set);
    }

    default String map2JsonStr(Map map) {
        return O2JUtil.map2JsonStr(map);
    }

    default String O2JsonStr(Object o) {
        return new JSONObject(o).toString();
    }

    default String Page2Json(PageInfo pageInfo) {
        return new JSONObject(pageInfo).toString();
    }

    default void chooseContent() {

    }
}

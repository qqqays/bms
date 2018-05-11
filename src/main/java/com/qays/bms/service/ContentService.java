package com.qays.bms.service;

import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-11-2018 11:26
 */
@Service
public class ContentService implements AuxService {

    @Autowired
    private ContentMapper contentMapper;

    public String fullList(String search) {
        return code(ReturnCode.SUCCESS, contentMapper.fullList(search));
    }

    public String listByType(String type, String search) {
        return code(ReturnCode.SUCCESS, contentMapper.listByType(type, search));
    }
}

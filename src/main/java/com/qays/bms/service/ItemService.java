package com.qays.bms.service;

import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.common.exception.CustomException;
import com.qays.bms.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-09-2018 17:28
 */
@Service
@Transactional
public class ItemService implements AuxService{

    @Autowired
    private ItemMapper itemMapper;

    @Value("${spring.servlet.multipart.location}")
    private String location;

    public String addItem(String typeId, String name, String value, String description) {
        return code(ReturnCode.SUCCESS, itemMapper.insertItem(typeId, name, value, description));
    }

    public String checkDir(String typeId, String name, String value, String description) {
        String typePath = jointPath("/uploads", value);
        String absolutionPath = jointPath(location, typePath);

        if (checkDir(absolutionPath)) {
            return addItem(typeId, name, value, description);
        } else {
            throw new CustomException(ReturnCode.EXECUTE_ERROR);
        }
    }
}

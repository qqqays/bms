package com.qays.bms.service;

import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.common.exception.CustomException;
import com.qays.bms.dao.ItemRepository;
import com.qays.bms.domain.ItemEntity;
import com.qays.bms.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Autowired
    private ItemRepository itemRepository;

    @Value("${spring.servlet.multipart.location}")
    private String location;

    public String addItem(String typeId, String name, String value, String description) {
        return code(ReturnCode.SUCCESS, itemMapper.insertItem(typeId, name, value, description));
    }

    /**
     * add new folder to disk
     *
     * @param typeId
     * @param name
     * @param value
     * @param description
     * @return
     */
    public String checkDir(String typeId, String name, String value, String description) {
        String typePath = jointPath("/uploads", value);
        String absolutionPath = jointPath(location, typePath);

        if (checkDir(absolutionPath)) {
            return addItem(typeId, name, value, description);
        } else {
            throw new CustomException(ReturnCode.EXECUTE_ERROR);
        }
    }

    public String listByType(String type) {
        List<ItemEntity> list = itemMapper.listByType(type);
        return code(ReturnCode.SUCCESS, list);
    }
}

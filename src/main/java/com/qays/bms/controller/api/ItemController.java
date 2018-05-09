package com.qays.bms.controller.api;

import com.qays.bms.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-09-2018 17:34
 */
@RestController
@RequestMapping("/api/dic-item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("check-dir")
    public String checkDir(String typeId, String name, String value, String description) {
       return itemService.checkDir(typeId, name, value, description);
    }
}

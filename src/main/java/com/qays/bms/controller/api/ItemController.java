package com.qays.bms.controller.api;

import com.qays.bms.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{content}")
    public String listByType(@PathVariable String content) {
        return itemService.listByType(content);
    }
}

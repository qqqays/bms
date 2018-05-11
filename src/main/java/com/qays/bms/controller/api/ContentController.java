package com.qays.bms.controller.api;

import com.qays.bms.service.ContentService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-11-2018 11:30
 */
@RestController
@RequestMapping("/api/contents")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping
    @ApiImplicitParam(name = "search")
    public String fullList(@RequestParam(defaultValue = "") String search) {
        return contentService.fullList(search);
    }

    @GetMapping("{type}")
    @ApiImplicitParam(name = "search")
    public String listByType(@PathVariable String type, @RequestParam(defaultValue = "") String search) {
        return contentService.listByType(type, search);
    }
}

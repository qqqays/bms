package com.qays.bms.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-05-2018 13:28
 */
@RestController
@RequestMapping("/api/images")
public class ImgController {

    @GetMapping("test")
    public String aa() {
        return "success";
    }


}

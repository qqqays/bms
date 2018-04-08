package com.qays.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-08-2018 14:26
 */
@Controller
@RequestMapping
public class TestController {

    @GetMapping("/hello")
    public String hello(){

        return "test";
    }

    @GetMapping("/test1")
    @ResponseBody
    public String test(){
        return "test";
    }
}

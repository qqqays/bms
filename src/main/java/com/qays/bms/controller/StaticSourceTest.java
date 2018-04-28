package com.qays.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-28-2018 11:40 AM
 */
@Controller
@RequestMapping("/js")
public class StaticSourceTest {

    @RequestMapping("{abc}")
    @ResponseBody
    public String abc(@PathVariable String abc) {
        return abc;
    }
}

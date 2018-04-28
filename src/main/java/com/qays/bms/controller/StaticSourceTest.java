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
public class StaticSourceTest {

    @RequestMapping("{ab}/{abc}")
    @ResponseBody
    public String abc(@PathVariable String abc) {
        return abc;
    }

    @RequestMapping("{ab}/{abc}/{aaa}")
    @ResponseBody
    public String ccc(@PathVariable String ab, @PathVariable String abc, @PathVariable String aaa) {

        return ab + abc + aaa;

    }

}

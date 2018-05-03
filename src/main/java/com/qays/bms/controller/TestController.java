package com.qays.bms.controller;

import com.qays.bms.domain.JpaTestEntity;
import com.qays.bms.group.TestGroup;
import com.qays.bms.repository.JpaTestRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    JpaTestRepository jtr;

    @GetMapping("/hello")
    public String hello(){

        return "test";
    }

    @GetMapping("/test1")
    @ResponseBody
    public String test(){
        return "test";
    }

    @PostMapping("/singleEntity")
    @ResponseBody
    public String single(JpaTestEntity jte) {
        System.out.println(jte.getContents());
        jtr.save(jte);

        return "aa";
    }

    @PostMapping("/multiEntity")
    @ResponseBody
    public String multiple(TestGroup tg) {
        jtr.save(tg.getJte());
        return "cc";
    }
}

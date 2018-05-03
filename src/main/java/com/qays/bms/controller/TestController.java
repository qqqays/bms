package com.qays.bms.controller;

import com.qays.bms.domain.JpaTestEntity;
import com.qays.bms.group.TestGroup;
import com.qays.bms.dao.AddRepository;
import com.qays.bms.dao.JpaTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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

    @Autowired
    AddRepository ar;

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
        ar.save(tg.getAe());
        return "cc";
    }

    @PostMapping("/uploads")
    @ResponseBody
    public String uploads(MultipartFile[] files) {
        try {
            if (files != null)
                if (files.length > 0) {
                    for (MultipartFile file : files) {
                        file.transferTo(new File("/abc/" + file.getOriginalFilename()));
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/abc/1274933_qays.png";
    }
}

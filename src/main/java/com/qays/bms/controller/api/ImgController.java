package com.qays.bms.controller.api;

import com.qays.bms.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-05-2018 13:28
 */
@RestController
@RequestMapping("/api/images")
public class ImgController implements AuxApi {

    @Autowired
    ImgService imgService;

    @PostMapping("{content}")
    public String postImg(
            @RequestParam(defaultValue = "") String alt,
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") Integer width,
            @RequestParam(defaultValue = "0") Integer height,
            @PathVariable String content,
            @RequestParam MultipartFile[] files
    ) {
        return imgService.postImg(alt, title, width, height, content, files);
    }

    @PostMapping("/ckEditor")
    public void ckEditor(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile[] upload) {
        imgService.postImg4ck(request, response, upload);
    }

    @PutMapping()
    public String updateImg(@RequestParam String id, @RequestParam String alt, @RequestParam String title) {
        return imgService.putImg(id, alt, title);
    }

    @DeleteMapping()
    public String deleteImg(@RequestParam String id) {
        return imgService.deleteImg(id);
    }

    /**
     * @param pn page number
     * @param ps page size
     * @param s  keywords for searching
     * @return one page of image table
     */
    @GetMapping("")
    public String acquireAllImg(
            @RequestParam(defaultValue = "0") Integer pn,
            @RequestParam(defaultValue = "15") Integer ps,
            @RequestParam(defaultValue = "") String s
    ) {
        return imgService.acquireAllImg(pn, ps, s);
    }

    @GetMapping("single")
    public String gainImg(@RequestParam String id) {
        return imgService.gainImgById(id);
    }

    @GetMapping("ck")
    public void path4ck(HttpServletRequest request, HttpServletResponse response, @RequestParam("imgPath") String imgPath) {
        imgService.path4ck(request,response,imgPath);
    }
}

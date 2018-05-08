package com.qays.bms.controller.api;

import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.common.exception.CustomException;
import com.qays.bms.dao.ImgRepository;
import com.qays.bms.domain.ImgEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-05-2018 13:28
 */
@RestController
@RequestMapping("/api/images")
public class ImgController {

    @Autowired
    private ImgRepository imgRepository;

    @GetMapping("test")
    public String aa(HttpServletRequest request) throws NullPointerException {
//        return WebUtils.getRealPath(request.getServletContext(), "resources");
//        return request.getServletContext().getRealPath("/static/image");
        return ClassUtils.getDefaultClassLoader().getResource("static/image").getPath().substring(1);
    }

    private String addImg(String relationPath,
                          String absolutionPath,
                          String alt,
                          String title,
                          Integer width,
                          Integer height,
                          String class1,
                          MultipartFile file) {

        String originName = file.getOriginalFilename();
        String imgRelationPath = relationPath + originName;
        String imgAbsolutionPath = absolutionPath + originName;

        ImgEntity ie = new ImgEntity();

        ie.setName(originName);
        ie.setRelativePath(relationPath);
        ie.setAbsolutePath(absolutionPath);
        ie.setAlt(alt);
        ie.setTitle(title);
        ie.setWidth(width);
        ie.setHeight(height);
        ie.setClass1(class1);
        ie.setUrl(imgRelationPath);

        try {
            file.transferTo(new File(imgAbsolutionPath));
            imgRepository.save(ie);
            return imgRelationPath;
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new CustomException(ReturnCode.EXECUTE_ERROR);
    }

}

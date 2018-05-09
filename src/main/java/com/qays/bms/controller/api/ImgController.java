package com.qays.bms.controller.api;

import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.common.exception.CustomException;
import com.qays.bms.common.util.FileUtil;
import com.qays.bms.dao.ImgRepository;
import com.qays.bms.domain.ImgEntity;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-05-2018 13:28
 */
@RestController
@RequestMapping("/api/images")
public class ImgController implements AuxApi {

    @Autowired
    private ImgRepository imgRepository;

    @Value("${spring.servlet.multipart.location}")
    private String location;

    @GetMapping("test")
    public String aa(HttpServletRequest request) throws NullPointerException {
//        return WebUtils.getRealPath(request.getServletContext(), "resources");
//        return request.getServletContext().getRealPath("/static/image");
        return ClassUtils.getDefaultClassLoader().getResource("static/image").getPath().substring(1);
    }

    private String addImg(
            String relationPath,
            String absolutionPath,
            String alt,
            String title,
            Integer width,
            Integer height,
            String class1,
            MultipartFile file
    ) {

        String name = file.getOriginalFilename();
        String imgRelationPath = jointPath(relationPath, name);
        String imgAbsolutionPath = jointPath(absolutionPath, name);

        ImgEntity ie = new ImgEntity();

        ie.setId(imgRelationPath);
        ie.setName(name);
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

    @PostMapping("{content}")
    public String postImg(
            @RequestParam(defaultValue = "") String alt,
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") Integer width,
            @RequestParam(defaultValue = "0") Integer height,
            @PathVariable String content,
            @RequestParam MultipartFile[] files
    ) {
        String typePath = jointPath("/uploads", content);
        String absolutionPath = jointPath(location, typePath);
        String relationPath = jointPath("", typePath);

        JSONArray jsonArray = new JSONArray();

        try {
            if (files != null)
                if (files.length > 0) {
                    for (MultipartFile file : files) {
                        jsonArray.put(addImg(relationPath, absolutionPath, alt, title, width, height, content, file));
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray.toString();
    }

    @PutMapping()
    @Transactional
    public String updateImg(@RequestParam String id, @RequestParam String alt, @RequestParam String title) {
        Optional<ImgEntity> o = imgRepository.findById(id);

        ImgEntity ie = o.get();

        ie.setAlt(alt);
        ie.setTitle(title);

        imgRepository.save(ie);

        return code(ReturnCode.SUCCESS);
    }
}

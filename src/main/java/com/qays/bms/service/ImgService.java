package com.qays.bms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qays.bms.common.enums.ReturnCode;
import com.qays.bms.common.exception.CustomException;
import com.qays.bms.common.util.SKTUtil;
import com.qays.bms.dao.ImgRepository;
import com.qays.bms.domain.ImgEntity;
import com.qays.bms.mapper.ImgMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-09-2018 11:46
 */
@Service
@Transactional
public class ImgService implements AuxService, SKTUtil {

    @Autowired
    private ImgMapper imgMapper;

    @Autowired
    private ImgRepository imgRepository;

    @Value("${spring.servlet.multipart.location}")
    private String location;

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
            return code(ReturnCode.SUCCESS, imgRelationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new CustomException(ReturnCode.EXECUTE_ERROR);
    }

    public String postImg(String alt, String title, Integer width, Integer height, String content, MultipartFile[] files) {
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

        return code(ReturnCode.SUCCESS, jsonArray);
    }

    public void postImg4ck(HttpServletRequest request, HttpServletResponse response, MultipartFile[] files) {

        String typePath = jointPath("/uploads", "ckEditor");
        String absolutionPath = jointPath(location, typePath);
        String relationPath = jointPath("", typePath);

        try {
            if (files != null)
                if (files.length > 0) {
                    for (MultipartFile file : files) {
                        addImg(relationPath, absolutionPath, "", "", 0, 0, "ckEditor", file);
                        imgUrl4CK(request, response, jointPath(relationPath, file.getOriginalFilename()), false);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void path4ck(HttpServletRequest request, HttpServletResponse response, String imgPath) {
        imgUrl4CK(request, response, imgPath, true);
    }

    public String deleteImg(String id) {
        Optional<ImgEntity> o = imgRepository.findById(id);

        ImgEntity ie = o.get();

        if (ie.getClass1().equals("system"))
            throw new CustomException(ReturnCode.DELETE_SYSTEM_FILE);

        try {
            File targetFile = new File(ie.getAbsolutePath(), ie.getName());

            if (targetFile.exists()) {
                if (!targetFile.delete()) {
                    throw new IOException("Deletes file failed");
                }
            }

            imgRepository.delete(ie);
            return code(ReturnCode.SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return code(ReturnCode.EXECUTE_ERROR);

    }

    public String putImg(String id, String alt, String title) {
        Optional<ImgEntity> o = imgRepository.findById(id);

        ImgEntity ie = o.get();

        ie.setAlt(alt);
        ie.setTitle(title);

        imgRepository.save(ie);

        return code(ReturnCode.SUCCESS);
    }

    public String acquireAllImg(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);

        PageInfo<ImgEntity> page = new PageInfo<>(imgMapper.allImg(search));

        return code(ReturnCode.SUCCESS, page);
    }

    public String acquireImg(Integer pageNum, Integer pageSize, String search, String type) {
        PageHelper.startPage(pageNum, pageSize);

        PageInfo<ImgEntity> page = new PageInfo<>(imgMapper.typeOfImg(search, type));

        return code(ReturnCode.SUCCESS, page);
    }

    public String gainImgById(String id) {
        Optional<ImgEntity> o = imgRepository.findById(id);

        ImgEntity ie = o.get();

        return code(ReturnCode.SUCCESS, ie);
    }
}

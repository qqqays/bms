package com.qays.bms;

import com.qays.bms.dao.ImgRepository;
import com.qays.bms.domain.ImgEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-08-2018 11:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PathTest {

    @Autowired
    ImgRepository imgRepository;

    @Value("${spring.servlet.multipart.location}")
    private String location;

    public static void listFile(String path, List<String> list) {
        File dir = new File(path);

        if (dir.exists()) {
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    list.add(file.toString().replace("\\", "/"));
//                    System.out.println(file.getName());
//                    System.out.println(file.getPath());
//                    System.out.println(file.getParent());
                } else if (file.isDirectory()) {
                    listFile(file.toString(), list);
                }
            }
        }
    }

    @Test
    public void path() {
        System.out.println();
        String path = ClassUtils.getDefaultClassLoader().getResource("static/image").getPath().substring(1);

        List<String> list = new ArrayList<>();

        listFile(path, list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void scanImg() {
        String sPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath().substring(1);
//        System.out.println(sPath);
        String path = sPath + "/image";
//        System.out.println(path.substring(sPath.length()));

        List<String> list = new ArrayList<>();
        listFile(path, list);
        for (String s : list) {
//            System.out.println(s.substring(sPath.length()));
//            System.out.println(s.substring(s.lastIndexOf("/") + 1));
//            System.out.println(s.substring(0, s.lastIndexOf("/")));
//            System.out.println(s.substring(sPath.length(),s.lastIndexOf("/")));
            if (!imgRepository.existsById(s.substring(sPath.length()))) {
                ImgEntity ie = new ImgEntity();
                ie.setId(s.substring(sPath.length()));
                ie.setUrl(s.substring(sPath.length()));
                ie.setName(s.substring(s.lastIndexOf("/") + 1));
                ie.setAbsolutePath(s.substring(0, s.lastIndexOf("/")));
                ie.setRelativePath(s.substring(sPath.length(), s.lastIndexOf("/")));
                ie.setClass1("system");
                imgRepository.save(ie);
            }
        }
    }

    @Test
    public void location() {
        System.out.println(location);
    }
}

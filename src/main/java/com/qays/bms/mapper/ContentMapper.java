package com.qays.bms.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-10-2018 13:47
 */
@Mapper
public interface ContentMapper {

    @Select("SELECT a.*, \n" +
            "b.page_title, b.keywords, b.description AS seo_description, b.author, \n" +
            "c.alt AS img_alt, c.title AS img_title, c.class1 AS image_class \n" +
            "FROM content AS a \n" +
            "LEFT JOIN seo AS b \n" +
            "ON a.seo_id = b.id \n" +
            "LEFT JOIN image AS c\n" +
            "ON a.cover_img = c.id\n" +
            "WHERE a.state = TRUE\n" +
            "AND (a.name LIKE '%${s}%' OR a.description LIKE '%${s}%')\n" +
            "ORDER BY a.tag ASC, a.update_date DESC, click DESC")
    List<Map> fullList(@Param("s") String s);

    @Select("SELECT a.*, \n" +
            "b.page_title, b.keywords, b.description AS seo_description, b.author, \n" +
            "c.alt AS img_alt, c.title AS img_title, c.class1 AS image_class \n" +
            "FROM content AS a \n" +
            "LEFT JOIN seo AS b \n" +
            "ON a.seo_id = b.id \n" +
            "LEFT JOIN image AS c\n" +
            "ON a.cover_img = c.id\n" +
            "WHERE a.state = TRUE\n" +
            "AND (a.name LIKE '%${s}%' OR a.description LIKE '%${s}%')\n" +
            "AND a.class1 = #{type} \n" +
            "ORDER BY a.tag ASC, a.update_date DESC, click DESC")
    List<Map> listByType(@Param("type") String type, @Param("s") String s);
}

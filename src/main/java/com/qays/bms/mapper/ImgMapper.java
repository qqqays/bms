package com.qays.bms.mapper;

import com.qays.bms.domain.ImgEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-09-2018 11:20
 */
@Mapper
public interface ImgMapper {
    @Select("select * from image where name like '%${s}%'")
    List<ImgEntity> allImg(@Param("s") String s);
}

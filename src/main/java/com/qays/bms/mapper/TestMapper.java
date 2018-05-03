package com.qays.bms.mapper;

import com.github.pagehelper.PageInfo;
import com.qays.bms.domain.JpaTestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 04-26-2018 10:53
 */
@Mapper
public interface TestMapper {

    @Select("select * from test_table limit 1")
    JpaTestEntity one();

    @Select("select * from test_table")
    List<JpaTestEntity> all();

    @Select("select * from test_table")
    List<JpaTestEntity> page();

    @Select("select a.*, b.contents from add_table as a join test_table as b")
    List<Map> mixResult();
}

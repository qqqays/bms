package com.qays.bms.mapper;

import com.qays.bms.domain.ItemEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Q-ays
 * whosqays@gmail.com
 * 05-09-2018 17:14
 */
@Mapper
public interface ItemMapper {

    @Insert("insert into dic_item(id, type_id, name, `value`, `sort`, `description`) " +
            "SELECT((SELECT id from dic_item where type_id = #{typeId} order by id desc limit 1) + 1), " +
            "#{typeId}, #{name}, #{value}, 5,#{description}")
    Integer insertItem(@Param("typeId") String typeId,@Param("name") String name,@Param("value") String value,@Param("description") String description);

    @Select("select * from dic_item where type_id = #{type_id} order by sort")
    List<ItemEntity> listByType(@Param("type_id") String typeId);
}

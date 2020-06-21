package com.cxq.mapper;

import com.cxq.entities.Houses;
import com.cxq.mapper.provider.HouseProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HousesMapper {

    @Select("select * from h_house h,h_users u,h_district d,h_type t\n" +
            "where h.user_id=u.uid and\n" +
            "h.district_id=d.did and\n" +
            "h.type_id=t.typeid")
    @Results(id = "houseMap",value = {
            //users表
            @Result(column = "uid",property = "users.uid"),
            @Result(column = "name",property = "users.name"),
            @Result(column = "psw",property = "users.psw"),
            @Result(column = "psw",property = "users.psw"),
            @Result(column = "sex",property = "users.sex"),
            @Result(column = "birth",property = "users.birth"),
            @Result(column = "headImg",property = "users.headImg"),
            @Result(column = "role",property = "users.role"),
            //district表
            @Result(column = "did",property = "district.did"),
            @Result(column = "parentid",property = "district.parentId"),
            @Result(column = "dis_name",property = "district.dis_name"),
            //type表
            @Result(column = "typeid",property = "type.typeid"),
            @Result(column = "typedesc",property = "type.typedesc"),
    })
    List<Houses> selectAll();

    @Insert("insert into h_house values (null,#{user_id},#{district_id},#{type_id},#{price},#{areas}" +
            ",#{title},#{mark},#{equipment},#{address},#{imgs})")
    void addHouse(Houses house);

    @Delete("delete from h_house where hid=#{hid}")
    void deleteById(Integer id);

    //条件查询
    @SelectProvider(type = HouseProvider.class,method = "selectByQuery")
    @ResultMap("houseMap")//引用上面的 @Results
    List<Houses> selectByCondition(Map<String, String> query);

}

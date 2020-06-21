package com.cxq.mapper;

import com.cxq.entities.Users;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UsersMapper {

    @Select("select * from h_users")
    List<Users> selectAll();

    @Select("select * from h_users where role='房东'")
    List<Users> selectLandlord();

}

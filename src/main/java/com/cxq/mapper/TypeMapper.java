package com.cxq.mapper;

import com.cxq.entities.Type;
import com.cxq.entities.Users;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * cHEnXQ on 20/6/18
 */

@Repository
public interface TypeMapper {

    @Select("select * from h_type")
    List<Type> selectAll();

}

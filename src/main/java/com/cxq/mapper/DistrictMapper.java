package com.cxq.mapper;

import com.cxq.entities.District;
import com.cxq.entities.Users;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * cHEnXQ on 20/6/18
 */

@Repository
public interface DistrictMapper {

    @Select("select * from h_district where parentId=#{did}")
    List<District> selectDis(Integer did);

}

package com.cxq.entities;

import lombok.Data;

@Data
public class Houses {

    //房源信息
    private Integer hid;
    private Integer price;
    private Integer areas;
    private String title;
    private String mark;
    private String equipment;
    private String address;
    private String imgs;

    //实现新增封装，表中的原始字段
    private Integer user_id;
    private Integer district_id;
    private Integer type_id;

    //其他信息
    private Users users;
    private District district;
    private Type type;

}

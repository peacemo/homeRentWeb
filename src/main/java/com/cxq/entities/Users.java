package com.cxq.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Users {

    private Integer uid;
    private String name;
    private String psw;
    private String sex;
    private Date birth;
    private String headImg;
    private String role;

}

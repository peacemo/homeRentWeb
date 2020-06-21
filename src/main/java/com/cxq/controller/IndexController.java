package com.cxq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //跳转到工程首页
    @RequestMapping("/index")
    public String index() {
        //跳转index.html
        return "index";
    }

    @RequestMapping("/admin")
    public String admin() {

        //跳转到后台管理页面
        return "admin/admin";

    }

    @RequestMapping("/front")
    public String front() {

        return "front/home_index";

    }

}

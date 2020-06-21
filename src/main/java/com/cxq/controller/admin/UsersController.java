package com.cxq.controller.admin;

import com.cxq.entities.Users;
import com.cxq.mapper.UsersMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;

    @RequestMapping("/show")
    public String showUsers(Model model,
                            @RequestParam(defaultValue = "1") Integer pageNo,
                            @RequestParam(defaultValue = "3") Integer pageSize) {

        //pageHelper分页
        PageHelper.startPage(pageNo,pageSize);
        //通用mapper查询
        List<Users> users = usersMapper.selectAll();
        //封装users到pageInfo
        PageInfo<Users> usersPage = new PageInfo<>(users);
        //将结果放入model中
        model.addAttribute("usersPage", usersPage);
        //跳转到show_users页面
        return "admin/users/show_users";

    }

    //通用mapper用户名模糊查询
//    @RequestMapping("/search")
//    public String searchUsers(Model model, String searchContent) {
//
//        List<Users> users = null;
//        //通用mapper查询
//        if(searchContent.isEmpty()) {
//            users = usersMapper.selectAll();
//        }
//        else {
//            //模糊查询
//            Example example = new Example(Users.class);//示例对象
//            Example.Criteria criteria = example.createCriteria();//条件对象
//            criteria.andLike("name", "%" + searchContent +"%");
//            users = usersMapper.selectByExample(example);
//        }
//
//        System.out.println(users);
//
//        //封装users到pageInfo
//        PageInfo<Users> usersPage = new PageInfo<>(users);
//        //将结果放入model中
//        model.addAttribute("usersPage", usersPage);
//        //跳转到show_users页面
//        return "admin/users/show_users";
//    }


}

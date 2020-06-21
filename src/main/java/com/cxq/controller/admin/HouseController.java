package com.cxq.controller.admin;

import com.cxq.entities.District;
import com.cxq.entities.Houses;
import com.cxq.entities.Type;
import com.cxq.entities.Users;
import com.cxq.mapper.DistrictMapper;
import com.cxq.mapper.HousesMapper;
import com.cxq.mapper.TypeMapper;
import com.cxq.mapper.UsersMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private HousesMapper housesMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private TypeMapper typeMapper;

    //房屋信息新增
    @RequestMapping("/addPage")
    public String addPage(Model model) {

        //查询房东信息
        List<Users> landlords = usersMapper.selectLandlord();
        //查询区域信息
        List<District> districts = districtMapper.selectDis(1);
        //房型查询
        List<Type> types = typeMapper.selectAll();
        //存入model
        model.addAttribute("landlords",landlords);
        model.addAttribute("types",types);
        model.addAttribute("districts",districts);
        System.out.println(districts);
        return "admin/house/add_houses";

    }

    //实现房源的新增
    @RequestMapping("/add")
    public String add(Houses house) {

        housesMapper.addHouse(house);
        System.out.println(house);
        return "admin/admin";

    }

    //删除房源
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        housesMapper.deleteById(id);
        return "admin/admin";

    }

    @RequestMapping("/getStreetById")
    @ResponseBody//城区和街道二级联动
    public List<District> getStreetById(Integer id) {

        List<District> streets = districtMapper.selectDis(id);
        System.out.println(streets);
        return streets;

    }

    //房屋信息查询
    @RequestMapping("/show")
    public String show(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNo,
                       @RequestParam(defaultValue = "3") Integer pageSize) {

        PageHelper.startPage(pageNo, pageSize);
        List<Houses> houses = housesMapper.selectAll();
        PageInfo<Houses> housesPage = new PageInfo<>(houses);

        System.out.println(housesPage);

        model.addAttribute("housesPage",housesPage);
        return "admin/house/show_houses";

    }

}

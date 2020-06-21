package com.cxq.controller.front;

import com.cxq.entities.District;
import com.cxq.entities.Houses;
import com.cxq.entities.Type;
import com.cxq.mapper.DistrictMapper;
import com.cxq.mapper.HousesMapper;
import com.cxq.mapper.TypeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * cHEnXQ on 20/6/19
 */

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private HousesMapper housesMapper;

    @RequestMapping("/list")
    public String homeList(Model model) {

        //查询城区信息
        List<District> districts = districtMapper.selectDis(1);
        //查询房屋信息
        List<Type> types = typeMapper.selectAll();
        model.addAttribute("districts", districts);
        model.addAttribute("types", types);
        return "front/home_list";

    }

    @RequestMapping("/showHomeList")
    @ResponseBody
    public PageInfo<Houses> showHomeList(@RequestParam(defaultValue = "1")Integer pageNum,
                             @RequestParam(defaultValue = "8")Integer pageSize,
                             String district_id, String price, String area, String type_id){

        System.out.println(district_id + "|" + price + "|" + area + "|" + type_id);
        //将参数存入一个map中，用于查询
        HashMap<String, String> condition = new HashMap<>();
        condition.put("district_id", district_id);
        condition.put("type_id", type_id);
        //拆分价格和面积
        if(price != null) {
            String[] arr_price = price.split("-");
            String min_price = arr_price[0];
            String max_price = arr_price[1];
            condition.put("min_price", min_price);
            condition.put("max_price", max_price);
        }

        if(area != null) {
            String[] arr_area = area.split("-");
            String min_area = arr_area[0];
            String max_area = arr_area[1];
            condition.put("min_area", min_area);
            condition.put("max_area", max_area);
        }

        PageHelper.startPage(pageNum, pageSize);

        List<Houses> houses = housesMapper.selectByCondition(condition);

        return new PageInfo<>(houses);
    }

}

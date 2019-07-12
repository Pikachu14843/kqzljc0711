package com.qf.web;

import com.qf.bean.District;
import com.qf.dao.DistrictMapper;
import com.qf.service.DistrictService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DistrictController {
    @Resource
    private DistrictService districtService;
    @RequestMapping("/findalldis")
    public String findalldis(ModelMap map){

        System.out.println("哈哈哈哈哈哈");
        List<District> findalldis = districtService.findalldis();
        map.put("dlist",findalldis);
        return "add";
    }
}

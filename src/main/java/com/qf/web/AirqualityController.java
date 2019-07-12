package com.qf.web;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Airquality;
import com.qf.bean.District;
import com.qf.service.AirqualityService;
import com.qf.service.DistrictService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
public class AirqualityController  {
    @Resource
    private AirqualityService airqualityService;

    @Resource
    private DistrictService districtService;


    //1.显示所有条目+分区域查询+分页
    @RequestMapping("/getairquality")
    public String getairquality(@RequestParam(defaultValue = "-1") int disid, @RequestParam(defaultValue = "1")int index, ModelMap map){
        List<District> districtList = districtService.findalldis();
        map.addAttribute("dlist",districtList);
        PageInfo<Airquality> findairs = airqualityService.findairs(disid, index, 3);
        map.addAttribute("pi",findairs);
       map.put("disid",disid);
        return "show";

    }

    //添加空气质量
    @RequestMapping("/insertair")
    public void insertair(Airquality airquality, HttpServletResponse response){
        airquality.setLastModifyTime(new Date());
        int i = airqualityService.insert(airquality);
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            if (i>0){
                writer.print("<script>alert('保存成功');location.href='/getairquality'</script>");
            }else {
                writer.print("<script>alert('保存失败');location.href='/findalldis'</script>");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //更新
    //(1)主键查找
    @RequestMapping("/findbyaid")
    public String findbyaid(int aid,ModelMap map){
        Airquality airquality = airqualityService.selectByPrimaryKey(aid);
        map.addAttribute("air",airquality);

        List<District> districtList = districtService.findalldis();
        map.addAttribute("dlist",districtList);

        return "update";
    }

    //更新
    @RequestMapping("/updateair")
    public void updateair(Airquality airquality, HttpServletResponse response){
        airquality.setLastModifyTime(new Date());
        int i = airqualityService.updateByPrimaryKey(airquality);
        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            if (i>0){
                writer.print("<script>alert('更新成功');location.href='/getairquality'</script>");
            }else {
                writer.print("<script>alert('更新失败');location.href='/findbyaid?aid="+airquality.getId()+"'</script>");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //删除
    @RequestMapping("/deleteair")
    public void deleteair(int aid, HttpServletResponse response){

        int i = airqualityService.deleteByPrimaryKey(aid);

        try {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            if (i>0){
                writer.print("<script>alert('删除成功');location.href='/getairquality'</script>");
            }else {
                writer.print("<script>alert('删除失败');location.href='/getairquality'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

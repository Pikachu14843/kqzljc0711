package com.qf.dao;

import com.qf.bean.Airquality;

import java.util.List;
import java.util.Map;

public interface AirqualityMapper {
    //删除
    int deleteByPrimaryKey(Integer id);

    //    添加
    int insert(Airquality record);

    int insertSelective(Airquality record);

    //主键查找
    Airquality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Airquality record);

    //更新
    int updateByPrimaryKey(Airquality record);

    //显示所有条目和按区域查询+分页
    List<Airquality> findairs(Map map);



}
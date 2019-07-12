package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.bean.Airquality;

import java.util.List;
import java.util.Map;

public interface AirqualityService {

    //显示所有条目和按区域查询+分页
    PageInfo<Airquality> findairs(int disid, int index, int size);

    // 添加
    int insert(Airquality airquality);

    //主键查找
    Airquality selectByPrimaryKey(int id);

    //更新
    int updateByPrimaryKey(Airquality airquality);

    //删除
    int deleteByPrimaryKey(int id);



}
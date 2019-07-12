package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.bean.Airquality;
import com.qf.dao.AirqualityMapper;
import com.qf.dao.DistrictMapper;
import com.qf.service.AirqualityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AirqualityServiceImpl implements AirqualityService {

    @Resource
    private AirqualityMapper airqualityMapper;

    @Resource
    private DistrictMapper districtMapper;


    @Override
    public PageInfo<Airquality> findairs(int disid,int index,int size) {
        PageHelper.startPage(index,size);
        Map map=new HashMap();
        map.put("disid",disid);
        List<Airquality> findairs = airqualityMapper.findairs(map);
        System.out.println(findairs+"1111");
        return new PageInfo<>(findairs);
    }

    //添加
    @Override
    public int insert(Airquality airquality) {
        return airqualityMapper.insert(airquality);
    }

    //主键查找
    @Override
    public Airquality selectByPrimaryKey(int id) {
        Airquality airquality = airqualityMapper.selectByPrimaryKey(id);
        return airquality;
    }

    //更新
    @Override
    public int updateByPrimaryKey(Airquality airquality) {
        return  airqualityMapper.updateByPrimaryKey(airquality);
    }

    //删除
    @Override
    public int deleteByPrimaryKey(int id) {
        return airqualityMapper.deleteByPrimaryKey(id);
    }


}

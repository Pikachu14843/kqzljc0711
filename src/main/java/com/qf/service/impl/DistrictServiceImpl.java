package com.qf.service.impl;

import com.qf.bean.District;
import com.qf.dao.DistrictMapper;
import com.qf.service.DistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Resource
    private DistrictMapper districtMapper;

    @Override
    public List<District> findalldis() {
        List<District> districtList = districtMapper.findalldis();
        System.out.println("///////");
        return districtList ;
    }
}

package com.bevan.servicemap.service;

import cn.hutool.core.util.NumberUtil;
import com.bevan.internalcommon.model.DicDistrict;
import com.bevan.servicemap.mapper.DicDistrictMapper;
import com.bevan.servicemap.remote.DistrictClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author zbf
 * 2023/8/3 08:22
 */
@Service
public class DicDistrictService {
    @Autowired
    DicDistrictMapper dicDistrictMapper;
    @Autowired
    private DistrictClient districtClient;

    public void getDic() {
        HashMap<String, Object> queryMap = new HashMap<>(16);
        queryMap.put("address_code", "110000");
        List<DicDistrict> dicDistricts = dicDistrictMapper.selectByMap(queryMap);
        System.out.println(dicDistricts.get(0));
    }
    public void getDicInite() {
        districtClient.direction();
    }
}

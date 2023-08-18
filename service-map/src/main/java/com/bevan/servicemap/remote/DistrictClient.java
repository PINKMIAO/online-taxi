package com.bevan.servicemap.remote;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bevan.internalcommon.constant.AmapConfigConstants;
import com.bevan.internalcommon.model.DicDistrict;
import com.bevan.servicemap.mapper.DicDistrictMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zbf
 * 2023/7/27 07:56
 */
@Service
@Slf4j
public class DistrictClient {
    @Value("${amap.key}")
    private String amapKey;
    @Autowired
    private DicDistrictMapper dicDistrictMapper;

    public void direction() {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(AmapConfigConstants.DISTRICT_URL);
        urlBuilder.append("?");
        urlBuilder.append("keywords=").append("中国");
        urlBuilder.append("&");
        urlBuilder.append("subdistrict=").append("3");
        urlBuilder.append("&");
        urlBuilder.append("key=").append(amapKey);
        log.info(urlBuilder.toString());

        String districtString = HttpUtil.get(urlBuilder.toString());
        paresDistrictEntity(districtString);
    }

    private void paresDistrictEntity(String entity) {
        JSONObject result = JSONUtil.parseObj(entity);
        if (!result.isNull(AmapConfigConstants.STATUS) && result.getInt(AmapConfigConstants.STATUS) == 1) {
            if (!result.isNull(AmapConfigConstants.DISTRICTS)) {
                JSONArray countryDistrictArray = result.getJSONArray(AmapConfigConstants.DISTRICTS);
                JSONObject china = countryDistrictArray.getJSONObject(0);
                insertDistrict(china, 0, "1");
                // province
                JSONArray provinceDistrictArray = china.getJSONArray(AmapConfigConstants.DISTRICTS);
                for (int i = 0; i < provinceDistrictArray.size(); i++) {
                    JSONObject province = provinceDistrictArray.getJSONObject(i);
                    insertDistrict(province, 1, "100000");
                    // city
                    JSONArray cityDistrictArray = province.getJSONArray(AmapConfigConstants.DISTRICTS);
                    for (int j = 0; j < cityDistrictArray.size(); j++) {
                        JSONObject city = cityDistrictArray.getJSONObject(j);
                        insertDistrict(city, 2, province.getStr(AmapConfigConstants.DISTRICT_ADCODE));
                        // district
                        JSONArray districtDistrictArray = city.getJSONArray(AmapConfigConstants.DISTRICTS);
                        for (int k = 0; k < districtDistrictArray.size(); k++) {
                            JSONObject district = districtDistrictArray.getJSONObject(k);
                            if ("street".equals(district.getStr("level"))) {
                                break;
                            }
                            insertDistrict(district, 3, city.getStr(AmapConfigConstants.DISTRICT_ADCODE));
                        }
                    }
                }
            }
        }
    }

    private void insertDistrict(JSONObject district, Integer level, String parentCode) {
        DicDistrict country = new DicDistrict();
        country.setAddressCode(district.getStr(AmapConfigConstants.DISTRICT_ADCODE));
        country.setAddressName(district.getStr(AmapConfigConstants.DISTRICT_NAME));
        country.setLevel(level);
        country.setParentAddressCode(parentCode);
        dicDistrictMapper.insert(country);
    }
}

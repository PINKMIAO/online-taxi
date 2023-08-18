package com.bevan.servicemap.remote;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bevan.internalcommon.constant.AmapConfigConstants;
import com.bevan.internalcommon.responese.DirectionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zbf
 * 2023/7/27 07:56
 */
@Service
@Slf4j
public class MapDirectionClient {
    @Value("${amap.key}")
    private String amapKey;

    public DirectionResponse direction(String depLongitude, String depLatitude, String desLongitude, String desLatitude) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(AmapConfigConstants.DIRECTION_URL);
        urlBuilder.append("?");
        urlBuilder.append("origin=").append(depLongitude).append(",").append(depLatitude);
        urlBuilder.append("&");
        urlBuilder.append("destination=").append(desLongitude).append(",").append(desLatitude);
        urlBuilder.append("&");
        urlBuilder.append("extensions=base");
        urlBuilder.append("&");
        urlBuilder.append("output=json");
        urlBuilder.append("&");
        urlBuilder.append("key=").append(amapKey);
        log.info(urlBuilder.toString());

        // ResponseEntity<String> directionEntity = restTemplate.getForEntity(urlBuilder.toString(), String.class);
        // String entity = directionEntity.getBody();
        String directionString = HttpUtil.get(urlBuilder.toString());
        return paresDirectionEntity(directionString);
    }

    public DirectionResponse paresDirectionEntity(String entity) {
        DirectionResponse directionResponse = null;
        JSONObject result = JSONUtil.parseObj(entity);
        if (!result.isNull(AmapConfigConstants.STATUS) && result.getInt(AmapConfigConstants.STATUS) == 1) {
            if (!result.isNull(AmapConfigConstants.ROUTE)) {
                JSONObject routeObject = result.getJSONObject(AmapConfigConstants.ROUTE);
                JSONArray pathsArray = routeObject.getJSONArray(AmapConfigConstants.PATHS);
                JSONObject path = pathsArray.getJSONObject(0);
                directionResponse = new DirectionResponse();
                if (!path.isNull(AmapConfigConstants.DISTANCE)) {
                    directionResponse.setDistance(path.getInt(AmapConfigConstants.DISTANCE));
                }
                if (!path.isNull(AmapConfigConstants.DURATION)) {
                    directionResponse.setDuration(path.getInt(AmapConfigConstants.DURATION));
                }
            }
        }
        return directionResponse;
    }
}

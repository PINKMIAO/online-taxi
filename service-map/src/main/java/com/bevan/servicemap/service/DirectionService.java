package com.bevan.servicemap.service;

import com.bevan.internalcommon.dto.ResponseResult;
import com.bevan.internalcommon.responese.DirectionResponse;
import com.bevan.servicemap.remote.MapDirectionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zbf
 * 2023/7/26 23:13
 */
@Service
public class DirectionService {
    @Autowired
    private MapDirectionClient mapDirectionClient;

    public ResponseResult driving(String depLongitude, String depLatitude, String desLongitude, String desLatitude) {

        DirectionResponse direction = mapDirectionClient.direction(depLongitude, depLatitude, desLongitude, desLatitude);
        return ResponseResult.success(direction);
    }
}

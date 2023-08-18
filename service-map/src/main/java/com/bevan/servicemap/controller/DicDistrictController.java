package com.bevan.servicemap.controller;

import com.bevan.servicemap.service.DicDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbf
 * 2023/8/3 08:21
 */
@RestController
public class DicDistrictController {
    @Autowired
    DicDistrictService dicDistrictService;

    @GetMapping("/getDic")
    public void getDict() {
        dicDistrictService.getDic();
    }

    @GetMapping("/getDicInite")
    public void getDicInite() {
        dicDistrictService.getDicInite();
    }
}

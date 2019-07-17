package com.anwei.cloud.nacos.discovery.openfeign.controller;

import com.anwei.cloud.nacos.discovery.openfeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    FeignService service;

    @RequestMapping("test")
    public Object test() {
        return service.test();
    }

}

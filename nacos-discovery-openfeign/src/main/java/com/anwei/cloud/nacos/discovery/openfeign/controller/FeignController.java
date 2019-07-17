package com.anwei.cloud.nacos.discovery.openfeign.controller;

import com.anwei.cloud.nacos.discovery.openfeign.service.FeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    FeignService service;

    @RequestMapping("test")
    public Object test() {
        return service.test();
    }

}

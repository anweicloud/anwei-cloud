package com.anwei.cloud.nacos.discovery.openfeign.service.impl;

import com.anwei.cloud.nacos.discovery.openfeign.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String test() {
        return "Test error";
    }
}

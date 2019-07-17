package com.anwei.cloud.nacos.discovery.openfeign.service;

import com.anwei.cloud.nacos.discovery.openfeign.service.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="nacos-discovery-provider", fallback = FeignServiceImpl.class)
public interface FeignService {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    Object test();

}

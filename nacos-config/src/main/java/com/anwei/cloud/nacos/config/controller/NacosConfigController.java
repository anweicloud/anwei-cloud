package com.anwei.cloud.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class NacosConfigController {

    @Value("${user.name}")
    String userName;

    // 25 是默认值，未配置user.age则使用25
    @Value("${user.age:25}")
    int age;

    @RequestMapping("echo/{msg}")
    public Object hello(@PathVariable String msg) {
        return "Hello Nacos Config! Hello " +msg+ "  config:" + userName + " " + age + "!";
    }

}

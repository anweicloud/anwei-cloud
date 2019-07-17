package com.anwei.cloud.nacos.discovery.consumer.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    ConfigurableApplicationContext cfgCtx;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("rest")
    public String echo() {
        String provider = cfgCtx.getEnvironment().getProperty("provider.name");
        ServiceInstance serviceInstance = loadBalancerClient.choose(provider);
        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), provider + ":" + serviceInstance.getPort());
        return  restTemplate.getForObject(url, String.class);
    }

    @RequestMapping(value = {"services", "services/{name}"})
    public Object services(@PathVariable(required = false) String name) {
        return StringUtils.isNotBlank(name) ?discoveryClient.getInstances(name):discoveryClient.getServices();
    }

}

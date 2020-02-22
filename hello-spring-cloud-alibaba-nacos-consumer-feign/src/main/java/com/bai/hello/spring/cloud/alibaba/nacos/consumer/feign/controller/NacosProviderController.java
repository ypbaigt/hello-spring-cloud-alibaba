package com.bai.hello.spring.cloud.alibaba.nacos.consumer.feign.controller;

import com.bai.hello.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController {

    @Autowired
    private NacosProviderService nacosProviderService;

    @GetMapping("/echo")
    public String echo() {
        return nacosProviderService.echo("hello feign");
    }


}

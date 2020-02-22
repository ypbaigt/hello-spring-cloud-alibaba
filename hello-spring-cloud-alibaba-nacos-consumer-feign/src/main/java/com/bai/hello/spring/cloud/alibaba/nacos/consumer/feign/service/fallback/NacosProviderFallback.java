package com.bai.hello.spring.cloud.alibaba.nacos.consumer.feign.service.fallback;

import com.bai.hello.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.stereotype.Component;

@Component
public class NacosProviderFallback implements NacosProviderService {

    @Override
    public String echo(String message1) {
        return "请求失败，请检查网络！";
    }
}

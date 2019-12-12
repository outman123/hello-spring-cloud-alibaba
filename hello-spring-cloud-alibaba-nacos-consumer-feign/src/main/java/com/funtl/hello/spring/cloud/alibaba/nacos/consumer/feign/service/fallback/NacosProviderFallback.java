package com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service.fallback;


import com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service.NacosProviderService;
import org.springframework.stereotype.Component;

@Component
public class NacosProviderFallback implements NacosProviderService {


    @Override
    public String echo(String message) {
        return "请求失败";
    }
}

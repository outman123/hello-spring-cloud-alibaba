package com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service;


import com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service.fallback.NacosProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//找到服务提供者，调用其提供的方法
@FeignClient(value = "nacos-provider",fallback = NacosProviderFallback.class)
public interface NacosProviderService {

    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable(value = "message") String message);
}

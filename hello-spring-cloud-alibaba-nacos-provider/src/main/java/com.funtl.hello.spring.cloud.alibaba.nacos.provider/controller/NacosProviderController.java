package com.funtl.hello.spring.cloud.alibaba.nacos.provider.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//通信：对内RPC，对外REST
@RestController
public class NacosProviderController {

    @Value(value = "${server.port}")
    private String port;

    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable(value = "message") String message){
        return "hello Nacos  "+message +" from port: "+port;
    }

    // 注入配置文件上下文
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    // 从上下文中读取配置
    @GetMapping(value = "/hi")
    public String sayHi() {
        return "Hello " + applicationContext.getEnvironment().getProperty("user.name");
    }
}

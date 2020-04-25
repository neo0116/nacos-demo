package com.example.nacos.nacosdemo.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName NacosController
 * @Description TODO
 * @Version 1.0
 **/
@NacosPropertySource(dataId = "demo", groupId = "nacos-demo", autoRefreshed = true)
@RestController
public class NacosController {

    @NacosValue(value = "${my.config:nacos}", autoRefreshed = true)
//    @Value(value = "${my.config:nacos}")
    private String info;

    @GetMapping(value = "/get")
    public String get() {
        return info;
    }


}

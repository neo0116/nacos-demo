package com.example.nacos.nacosdemo.httpRequestNacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @ClassName NacosRequest
 * @Description TODO
 * @Version 1.0
 **/
public class NacosRequest {

    public static void main(String[] args) {
        String dataId = "demo";
        String groupId = "nacos-demo";
        String serverAddr = "127.0.0.1:8848";
        Properties properties = new Properties();
        properties.put("dataId", dataId);
        properties.put("groupId", groupId);
        properties.put("serverAddr", serverAddr);
        try {
            ConfigService configService = NacosFactory.createConfigService(properties);
            String config = configService.getConfig(dataId, groupId, 5000L);
            System.out.println(config);

            configService.addListener(dataId, groupId, new Listener() {
                @Override
                public Executor getExecutor() {
                    return null;
                }

                @Override
                public void receiveConfigInfo(String s) {
                    System.out.println(s);
                }
            });
            Thread.sleep(100000L);
        } catch (NacosException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

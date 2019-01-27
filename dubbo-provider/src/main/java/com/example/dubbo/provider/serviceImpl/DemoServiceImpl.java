package com.example.dubbo.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.example.dubbo.common.serial.request.DemoRequestDTO;
import com.example.dubbo.common.serial.response.DemoResponseDTO;
import com.example.dubbo.common.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/26
 * @since 1.0
 */
@Service(version = "1.0.0",protocol = {"dubbo"},registry = {"zk","redis"},retries = 3,owner = "jaysong",loadbalance = "roundrobin")
@Slf4j
public class DemoServiceImpl implements DemoService {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @Override
    public DemoResponseDTO demoService(Integer intKey, String strKey, DemoRequestDTO demoRquestDTO) {

        log.info(intKey+" "+strKey);
        log.info(JSONObject.toJSONString(demoRquestDTO));

        return new DemoResponseDTO("000000","成功");
    }

    @Override
    public DemoResponseDTO errorTest(String name) {
        log.info(name);
        int a = 10/0;
        return new DemoResponseDTO("000001","异常失败");
    }

    @Override
    public DemoResponseDTO retryTest(String key) {
        log.info("SSSSSSSSSSSSSSS    "+key);
        int a = 10/0;
        return new DemoResponseDTO("000001","异常失败");
    }


}

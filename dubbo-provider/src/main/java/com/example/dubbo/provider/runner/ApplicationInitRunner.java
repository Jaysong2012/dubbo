package com.example.dubbo.provider.runner;

import com.alibaba.dubbo.config.ServiceConfig;
import com.example.dubbo.common.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/26
 * @since 1.0
 */
@Slf4j
@Component
public class ApplicationInitRunner implements ApplicationRunner {

    @Autowired
    @Qualifier("demoServiceConfig")
    private ServiceConfig<DemoService> demoServiceConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("系统启动完成，当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        log.info(demoServiceConfig.getClass().getName());
    }
}

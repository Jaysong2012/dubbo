package com.example.dubbo.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dubbo.common.serial.response.DemoResponseDTO;
import com.example.dubbo.common.service.WriteService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/27
 * @since 1.0
 */
@Service(version = "1.0.0",protocol = {"dubbo"},registry = {"zk"},cluster = "failfast",retries = 1,owner = "jaysong")
@Slf4j
public class WriteServiceImpl implements WriteService {

    @Override
    public DemoResponseDTO register(String account, String password) {
        log.info(account+ " "+ password);
        int a = 100/0;
        return new DemoResponseDTO("000000","成功");
    }
}

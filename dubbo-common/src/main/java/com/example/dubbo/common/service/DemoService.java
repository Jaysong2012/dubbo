package com.example.dubbo.common.service;

import com.example.dubbo.common.serial.request.DemoRequestDTO;
import com.example.dubbo.common.serial.response.DemoResponseDTO;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/26
 * @since 1.0
 */
public interface DemoService {

    String sayHello(String name);

    DemoResponseDTO demoService(Integer intKey, String strKey , DemoRequestDTO demoRquestDTO);

    DemoResponseDTO errorTest(String name);

    DemoResponseDTO retryTest(String key);

}

package com.example.dubbo.common.service;

import com.example.dubbo.common.serial.response.DemoResponseDTO;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/27
 * @since 1.0
 */
public interface WriteService {

    DemoResponseDTO register(String account,String password);

}

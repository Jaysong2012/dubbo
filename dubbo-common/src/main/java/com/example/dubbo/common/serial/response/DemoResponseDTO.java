package com.example.dubbo.common.serial.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/26
 * @since 1.0
 */
@Data
public class DemoResponseDTO implements Serializable {

    private String returnCode;

    private String returnMsg;

    public DemoResponseDTO(){}

    public DemoResponseDTO(String returnCode,String returnMsg){
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }
}

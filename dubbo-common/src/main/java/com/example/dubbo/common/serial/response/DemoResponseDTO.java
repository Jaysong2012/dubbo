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

    private String message;

    public DemoResponseDTO(){}

    public DemoResponseDTO(String returnCode,String message){
        this.returnCode = returnCode;
        this.message = message;
    }
}

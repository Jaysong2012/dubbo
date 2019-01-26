package com.example.dubbo.common.serial.request.bean;

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
public class WeatherDTO implements Serializable {

    private String type;

    private Integer degree;

    public WeatherDTO(){}

    public WeatherDTO(String type,Integer degree){
        this.type = type;
        this.degree = degree;
    }

}

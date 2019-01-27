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
public class DateDTO implements Serializable {

    private String date;

    private Integer year;

    private Integer month;

    private Integer day;

    public DateDTO(){}

    public DateDTO(String date,Integer year,Integer month,Integer day){
        this.date = date;
        this.year = year;
        this.month = month;
        this.day = day;
    }

}

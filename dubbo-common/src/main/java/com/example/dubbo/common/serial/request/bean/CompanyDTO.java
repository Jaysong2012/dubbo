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
public class CompanyDTO implements Serializable {

    private String name;

    private String address;

    public CompanyDTO(){}

    public CompanyDTO(String name,String address){
        this.name = name;
        this.address = address;
    }
}

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
public class JobDTO implements Serializable {

    private Integer id;

    private Boolean success;

    public JobDTO(){}

    public JobDTO(Integer id,Boolean success){
        this.id = id;
        this.success = success;
    }
}

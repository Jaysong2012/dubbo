package com.example.dubbo.common.serial.request.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/26
 * @since 1.0
 */
@Data
public class HumanDTO implements Serializable {

    private String name;

    private Integer age;

    private String birthday;

    private CompanyDTO company;

    private ArrayList<JobDTO> jobList;

    public HumanDTO(){}

    public HumanDTO(String name,Integer age,String birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
}

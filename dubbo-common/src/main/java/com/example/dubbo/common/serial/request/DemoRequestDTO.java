package com.example.dubbo.common.serial.request;

import com.example.dubbo.common.serial.request.bean.DateDTO;
import com.example.dubbo.common.serial.request.bean.HumanDTO;
import com.example.dubbo.common.serial.request.bean.WeatherDTO;
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
public class DemoRequestDTO implements Serializable {

    private HumanDTO human;

    private DateDTO date;

    private WeatherDTO weather;

}

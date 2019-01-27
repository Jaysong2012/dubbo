package com.example.dubbo.consumer.runner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.validation.MethodValidated;
import com.example.dubbo.common.serial.request.DemoRequestDTO;
import com.example.dubbo.common.serial.request.bean.*;
import com.example.dubbo.common.serial.response.DemoResponseDTO;
import com.example.dubbo.common.service.DemoService;
import com.example.dubbo.common.service.FileService;
import com.example.dubbo.common.service.WriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/26
 * @since 1.0
 */
@Slf4j
@Component
public class ApplicationInitRunner implements ApplicationRunner {

    @Reference(version = "1.0.0",registry = {"zk","redis"},timeout = 60000,check = false)
    private DemoService demoService;

    @Reference(version = "1.0.0",registry = {"zk"},timeout = 60000,check = false)
    private FileService fileService;

    @Reference(version = "1.0.0",registry = {"zk"},timeout = 60000,check = false)
    private WriteService writeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("系统启动完成，当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        log.info(demoService.sayHello("Jaysong"));
        DemoRequestDTO reuqest = new DemoRequestDTO();
        reuqest.setDate(new DateDTO("2018-08-18",2018,8,18));
        reuqest.setWeather(new WeatherDTO("snow",12));
        HumanDTO human = new HumanDTO("Jaysong",18,"2018-08-18");
        human.setCompany(new CompanyDTO("XXXX Company","XXXX street"));
        human.setJobList(new ArrayList<>(21));
        JobDTO job;
        for(int i =16;i<37;i++){
            job = new JobDTO(i,i%2==0?true:false);
            human.getJobList().add(job);
        }
        reuqest.setHuman(human);
        DemoResponseDTO response = demoService.demoService(1,"1",reuqest);

        log.info(response.getReturnMsg());

        try{
            log.info(demoService.errorTest("name").getReturnMsg());
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            log.info(demoService.retryTest("retry").getReturnMsg());
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            log.info(writeService.register("account","password").getReturnMsg());
        }catch (Exception e){
            e.printStackTrace();
        }

        InputStream inputStream = new FileInputStream(new File("/data/file/upload/stream.jpg"));

        log.info(fileService.uploadFileByInputStream(1,"stream.jpg",inputStream).getReturnMsg());

        inputStream = new FileInputStream(new File("/data/file/upload/byte.jpg"));
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        log.info("length "+bytes.length);

        log.info(fileService.uploadFileByBytes(1,"byte.jpg",bytes).getReturnMsg());


    }


}

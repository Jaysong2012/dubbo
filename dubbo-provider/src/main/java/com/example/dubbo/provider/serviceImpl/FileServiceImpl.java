package com.example.dubbo.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dubbo.common.serial.response.DemoResponseDTO;
import com.example.dubbo.common.service.FileService;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/27
 * @since 1.0
 */
@Service(version = "1.0.0",protocol = {"hessian"},registry = {"zk"})
@Slf4j
public class FileServiceImpl implements FileService {

    @Override
    public DemoResponseDTO uploadFileByBytes(int userId, String fileName, byte[] bytes) {
        log.info(String.valueOf(userId));
        log.info(fileName);
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file ;
        try {
            String filePath = "/data/file/upload";
            File dir = new File(filePath);
            if (!dir.exists() || !dir.isDirectory()) {//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + "/new_"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return new DemoResponseDTO("000001","失败");
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new DemoResponseDTO("000000","成功");
    }

    @Override
    public DemoResponseDTO uploadFileByInputStream(int userId, String fileName, InputStream inputStream) {

        log.info(String.valueOf(userId));
        log.info(fileName);
        OutputStream outStream = null;
        try {
            int n ;
            byte[] b = new byte[10240];
            outStream = new FileOutputStream("/data/file/upload/new_"+fileName);
            while((n=inputStream.read(b)) != -1){
                outStream.write(b, 0, n);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new DemoResponseDTO("000001","失败");
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outStream !=null){
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new DemoResponseDTO("000000","成功");
    }

}

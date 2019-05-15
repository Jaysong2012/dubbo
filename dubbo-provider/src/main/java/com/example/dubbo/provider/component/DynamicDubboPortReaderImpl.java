package com.example.dubbo.provider.component;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/5/13
 * @since 1.0
 */

import com.alibaba.dubbo.common.utils.NetUtils;
import com.alibaba.dubbo.config.ProtocolConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 通过ApplicationContextAware织入,ProtocolConfig构建完成后,执行port配置的init方法
 * 此时通过spring获取所有ProtocolConfig的实体,并将其端口设为随机一个未被使用的端口
 */
@Component
@Slf4j
public class DynamicDubboPortReaderImpl implements ApplicationContextAware {

    @Autowired
    private ApplicationContext applicationContext;
    private int port = 20880;

    @PostConstruct
    public void init() {
        Map<String, ProtocolConfig> beansOfType = applicationContext.getBeansOfType(ProtocolConfig.class);
        for (Map.Entry<String, ProtocolConfig> item : beansOfType.entrySet()) {
            port = NetUtils.getAvailablePort();
            log.info("##################use random###########################"+port);
            item.getValue().setPort(port);
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

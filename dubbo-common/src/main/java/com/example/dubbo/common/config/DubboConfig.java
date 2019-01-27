package com.example.dubbo.common.config;

import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.example.dubbo.common.service.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SongChao
 * @version 1.0
 * @website https://github.com/Jaysong2012
 * @date 2019/1/26
 * @since 1.0
 */
@Configuration
public class DubboConfig {
    //<dubbo:application name="dubbo-provider"></dubbo:application>
//    @Bean
//    public ApplicationConfig applicationConfig() {
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        applicationConfig.setName("dubbo-provider");
//        return applicationConfig;
//    }

    //<dubbo:registry protocol="zookeeper" address="127.0.0.1:2181"></dubbo:registry>
//    @Bean
//    public RegistryConfig registryConfig() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setProtocol("zookeeper");
//        registryConfig.setAddress("127.0.0.1:2181");
//        return registryConfig;
//    }

    //<dubbo:protocol name="dubbo" port="20882"></dubbo:protocol>
//    @Bean
//    public ProtocolConfig protocolConfig() {
//        ProtocolConfig protocolConfig = new ProtocolConfig();
//        protocolConfig.setName("dubbo");
//        protocolConfig.setPort(20882);
//        return protocolConfig;
//    }

    /**
     *<dubbo:service interface="com.example.dubbo.common.service.DemoService"
     ref="demoService" timeout="1000" version="1.0.0">
     <dubbo:method name="inserTest" timeout="1000"></dubbo:method>
     </dubbo:service>
     */
    @Bean
    public ServiceConfig<DemoService> demoServiceConfig(DemoService demoService){
        ServiceConfig<DemoService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setRef(demoService);
        serviceConfig.setVersion("1.0.0");

        //配置每一个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("errorTest");
        methodConfig.setTimeout(1000);
        methodConfig.setLoadbalance("random");
        methodConfig.setRetries(1);

        //将method的设置关联到service配置中
        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);
        serviceConfig.setMethods(methods);

        //ProviderConfig
        //MonitorConfig

        return serviceConfig;
    }
}

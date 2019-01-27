# dubbo
Dubbo教学案例聚合工程---BaseOn Dubbo 2.6.5

## 聚合工程结构
```
dubbo/
├── dubbo-admin                    #dubbo 控制台模块
├── dubbo-common                   #dubbo 通用及接口配置模块
├── dubbo-consumer                 #dubbo 消费者模块
├── dubbo-provider                 #dubbo 服务提供者模块
└── pom.xml
```

多协议多注册中心配置版
```yml
dubbo:
  application:
    name: dubbo-provider
  scan:
    base-packages: com.example.dubbo.provider.serviceImpl
  protocols:
    rmi:
      name: rmi
      port: 1088
      serialization: hessian2
    dubbo:
      name: dubbo
      port: 20880
      server: netty
      client: netty
      codec: dubbo
      serialization: hessian2
      charset: UTF-8
      threadpool: fixed
      threads: 100
      queues: 0
      iothreads: 9
      buffer: 8192
      accepts: 1000
      payload: 1048576
    hessian:
      name: hessian
      port: 18899
      serialization: hessian2
      payload: 10485760
      charset: UTF-8
      server: jetty
  registries:
    zk:
      address: zookeeper://192.168.199.8:2181
      default: true
    redis:
      address: redis://192.168.199.7:6379
```

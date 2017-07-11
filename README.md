# SpringBootDemo
spring boot 实战系列，主要是介绍使用方法，原理性分析以及一些基础性设施建设流程会抽时间单独拎出来讲；

## 各分支介绍

### master
公有依赖,最小化的配置,最简单的web项目helloworld!

### 集成Redis集群
整合redis集群,基本的两种使用方式demo;

### 集成thymeleaf模板引擎
整合thymeleaf模板引擎,前端引入th模版语法

### 集成mybatis
整合mybaits,使用tomcat-jdbc-pool连接池进行article小样演示,附sql

### 集成mongodb
整合mongodb,mongoRepsitory接口能满足多数增删改差功能,使用mongoTemplate结合QBC语法完成更高定制化的CRUD操作

### 集成mongodb
整合mongodb,mongoRepsitory接口能满足多数增删改差功能,使用mongoTemplate结合QBC语法完成更高定制化的CRUD操作

### 定时任务调度(不支持分布式)
使用spring内置的定时任务触发器完成简单的定时调度作业,给自己写了个简单的闹钟(打开QQ音乐并大声的唱出来!!),改天为大家集成Quartz实现带有分布式锁功能的高级定制定时任务调度中心实现

---

后续将会继续介绍SpringBoot项目整合更多诸如jpa,模版引擎 themeleaf,新一代分布式消息中间件rabbitmq,websocket,项目监控actuator ,非关系型数据库mongodb,Netflix(服务发现与注册eureka,服务隔离与整流Hystrix),集中配置中心spring cloud config,容器技术(docker+k8s)等框架/组件的实战应用,也会写一些配套基础设施搭建的攻略(比如redis集群搭建,eureka服务注册中心搭建等等)  

**大家可以先star这个项目占坑,后续不定期更新**

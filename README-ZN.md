# CommonUtil

[English]((https://github.com/cartoonYu/CommonUtil/blob/main/README.md)) | 简体中文

本项目主要用于日常开发中测试某些依赖第三方中间件或 API 功能。

1. usual
   1. 主要测试依赖 Java 相关 API 的功能
2. Common
   1. 包含公共代码
   2. 提供公共部分供不同包交互
   3. 这个模块通常不需要启动
3. spring
   1. 用于测试依赖 Spring 框架相关 API 功能
   2. 用于测试依赖第三方包相关 API 功能
   3. 依赖端口为7100
   4. api 文档地址: http://localhost:7100/api
4. redisDemo
   1. 用于测试依赖 redis 相关 API 功能
   2. 依赖端口为7110
   3. api 文档地址: http://localhost:7110/api
5. mysqlDemo
   1. 用于测试依赖数据库的功能
   2. 依赖端口为7120
   3. api 文档地址: http://localhost:7120/api
6. kafkaDemo
   1. 用于测试依赖 Kafka 相关 API 功能
   2. 依赖端口为7130
7. DubboProducer
   1. 用于测试 dubbo 相关 api
   2. 用于定义向外提供服务的实现类
   3. 依赖端口为7140
8. DubboConsumer
   1. 用于测试 dubbo 相关 api
   2. 用于消费提供者提供的服务
   3. 依赖端口为7150
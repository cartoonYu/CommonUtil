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
   4. api 文档为 http://localhost:7100/doc
4. redisDemo
   1. 用于测试依赖 redis 相关 API 功能
   2. 依赖端口为7110
   3. api 文档为 http://localhost:7110/doc
5. mysqlDemo
   1. 用于测试依赖数据库的功能
   2. 依赖端口为7120
   3. api 文档为 http://localhost:7120/doc
6. RabbitMqDemo
   1. 用于测试依赖 RabbitMq 相关 API 功能
   2. 依赖端口为7130
   3. api 文档为 http://localhost:7130/doc
7. kafkaDemo
   1. 用于测试依赖 Kafka 相关 API 功能
   2. 依赖端口为7140
   3. api 文档为 http://localhost:7140/doc
8. ShardingsephereDemo
   1. 用于测试依赖 Shardingsephere 相关 API 功能
   2. 依赖端口为7160
   3. api 文档为 http://localhost:7150/doc
9. spring2
   1. 用于测试依赖 Spring 框架相关 API 功能
   2. 用于测试依赖第三方包相关 API 功能
   3. 用于与 spring 包联动
   3. 依赖端口为7170
   4. api 文档为 http://localhost:7160/doc
10. DubboProducer
   1. 用于测试 dubbo 相关 api
   2. 用于定义向外提供服务的实现类
   3. 依赖端口为7180
   4. api 文档为 http://localhost:7170/doc
11. DubboConsumer
   1. 用于测试 dubbo 相关 api
   2. 用于消费提供者提供的服务
   3. 依赖端口为7190
   4. api 文档地址为 http://localhost:7180/doc
12. EurekaProducer
   1. 用于测试 Eureka 相关 api
   2. 用于定义向外提供服务的实现类
   3. 依赖端口为7200
   4. api 文档为 http://localhost:7190/doc
13. EurekaConsumer
   1. 用于测试 Eureka 相关 api
   2. 用于消费提供者提供的服务
   3. 依赖端口为7210
   4. api 文档地址为 http://localhost:7200/doc
14. MongoDemo
   1. 用于测试依赖 MongoDB 相关 API 功能
   2. 依赖端口为7220
   3. api 文档为 http://localhost:7210/doc
15. MybatisDemo
   1. 用于测试依赖 Mybatis 相关 API 功能
   2. 依赖端口为7230
   3. api 文档地址为 http://localhost:7220/doc
16. CanalDemo
   1. 用于测试依赖 Canal 相关 API 功能
   2. 本模块为后台进程项目
# CommonUtil

English | [简体中文](https://github.com/cartoonYu/CommonUtil/blob/main/README-ZN.md)

This project is primarily used to test the middleware separately in day-to-day development.
1. usual
   1. used to test api of java
2. Common
   1. include common code
   2. provide common part for different modules to interact
   3. this module will not start
3. spring
   1. used to test api of spring
   2. used to test third-party packages of Gradle
   3. bootstrap port is 7100
   4. api document url is http://localhost:7100/api
4. redisDemo
   1. used to test function which related with redis
   2. bootstrap port is 7110
   3. api document url is http://localhost:7110/api
5. mysqlDemo
   1. use jpa to test function which related with mysql
   2. bootstrap port is 7120
6. kafkaDemo
   1. used to test function which related with kafka
   2. bootstrap port is 7140
7. DubboProducer
   1. used to test api of dubbo
   2. define implementation class to provide service
   3. bootstrap port is 7180
8. DubboConsumer
   1. used to test api of dubbo
   2. consume provider's service
   3. bootstrap port is 7190
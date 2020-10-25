package org.common.constant;

public enum AddressEnum {

    SPRING("spring demo", "http://127.0.0.1:7100"),
    REDIS("redis demo", "http://127.0.0.1:7110"),
    MYSQL("mysql demo", "http://127.0.0.1:7120"),
    RABBITMQ("rabbitmq demo", "http://127.0.0.1:7130"),
    KAFKA("kafka demo", "http://127.0.0.1:7140"),
    SHARDING_SEPHERE("sharding sephere", "http://127.0.0.1:7150"),
    SPRING2("spring2 demo", "http://127.0.0.1:7160"),
    DUBBO_PRODUCER("dubbo producer", "http://127.0.0.1:7170"),
    DUBBO_CONSUMER("dubbo consumer", "http://127.0.0.1:7180"),
    EUREKA_PRODUCER("eureka producer", "http://127.0.0.1:7190"),
    EUREKA_CONSUMER("eureka consumer", "http://127.0.0.1:7200"),
    MONGO("mongo", "http://127.0.0.1:7210"),
    MYBATIS("mybatis demo", "http://127.0.0.1:7220");

    private String module;

    private String address;

    AddressEnum(String module, String address) {
        this.module = module;
        this.address = address;
    }

    public String getModule() {
        return module;
    }

    public String getAddress() {
        return address;
    }
}

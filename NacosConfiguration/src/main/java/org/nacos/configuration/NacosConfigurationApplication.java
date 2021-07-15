package org.nacos.configuration;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "${nacos.server.addr}"))
@NacosPropertySource(dataId = "example", autoRefreshed = true)
@SpringBootApplication
public class NacosConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigurationApplication.class, args);
    }

}

package org.xxljob.demo.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author cartoon
 * @description
 * @date 2020/10/20 21:55
 */
@Configuration
public class XxlJobConfig {

    private static final Logger log = LoggerFactory.getLogger(XxlJobConfig.class);

    private String adminAddress;

    private String appName;

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info("xxl job init start");
        XxlJobSpringExecutor executor = new XxlJobSpringExecutor ();
        executor.setAdminAddresses(adminAddress);
        executor.setAppname(appName);
        return executor;
    }

    @PostConstruct
    private void init(){
        adminAddress = "http://cartoon-ali.com:6002/xxl-job-admin";
        appName = "executor-demo";
    }
}

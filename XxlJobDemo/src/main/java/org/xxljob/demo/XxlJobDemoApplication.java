package org.xxljob.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 * 此模块在多网卡环境有几率无法正常被调度，https://gitee.com/xuxueli0323/xxl-job/issues/I11PH4
 * 原因：xxl-job 对多网卡支持不足，识别到非当前网卡的虚拟网卡，导致调度失败
 * 暂时措施：电脑连接网线，或者调度中心与被调度项目在同一项目上
 * 长远措施：修改xxl-job源码，使 xxl-job 支持识别多网卡，或者等待官方
 */

@SpringBootApplication
public class XxlJobDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlJobDemoApplication.class, args);
    }

}

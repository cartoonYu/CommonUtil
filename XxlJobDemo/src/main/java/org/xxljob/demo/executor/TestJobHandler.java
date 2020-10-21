package org.xxljob.demo.executor;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author cartoon
 * @description
 * @date 2020/10/20 22:24
 */

@Component
public class TestJobHandler {

    private static final Logger log = LoggerFactory.getLogger(TestJobHandler.class);

    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJobHandler(String param) throws Exception {
        log.info("test handler");
        XxlJobLogger.log("XXL-JOB, Hello World.");

        for (int i = 0; i < 5; i++) {
            XxlJobLogger.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(1);
        }
        return ReturnT.SUCCESS;
    }

}

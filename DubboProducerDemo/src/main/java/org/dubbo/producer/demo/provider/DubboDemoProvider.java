package org.dubbo.producer.demo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.common.DubboDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cartoon.yu
 * @since 2026/09/11 08:22
 */
@DubboService
public class DubboDemoProvider implements DubboDemoService {

    private static Logger log = LoggerFactory.getLogger(DubboDemoProvider.class);

    @Override
    public String say() {
        log.info("execute");
        return "DubboDemoProvider";
    }

}

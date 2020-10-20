package org.dubbo.producer.service;

import org.common.DubboService;
import org.springframework.stereotype.Service;

/**
 * @author cartoon
 * @description
 * @date 2020/6/29 16:12
 */
@org.apache.dubbo.config.annotation.DubboService
@Service
public class DubboServiceImpl implements DubboService {

    @Override
    public String say() {
        return "dubbo producer";
    }

}

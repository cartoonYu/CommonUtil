package org.eureka.consumer.util;

import org.eureka.consumer.util.visit.VisitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EurekaProducerServiceImpl implements EurekaProducerService{

    private static final String EUREKA_PRODUCER_URL = "http://EUREKAPRODUCER";

    @Resource
    private VisitService visitService;

    @Override
    public String simulationCall() throws Exception {
        String interfaceName = "text";
        String version = "1.0";
        return visitService.visit(EUREKA_PRODUCER_URL, interfaceName, version, "", String.class);
    }
}

package org.eureka.consumer.util.visit;

import com.alibaba.fastjson.JSONObject;
import org.eureka.consumer.util.visit.model.VisitReq;
import org.eureka.consumer.util.visit.model.VisitResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class VisitServiceImpl implements VisitService{

    private static final Logger log = LoggerFactory.getLogger(VisitServiceImpl.class);

    @Resource
    private RestTemplate restTemplate;

    @Override
    public<T> T visit(String url, String interfaceName, String version, String data, Class<T> returnClass) throws Exception {
        VisitReq request = new VisitReq();
        request.setData(data);
        request.setName(interfaceName);
        request.setVersion(version);
        String res = restTemplate.postForObject(url, JSONObject.toJSONString(request), String.class);
        VisitResp<T> resp = JSONObject.parseObject(res, VisitResp.class);
        log.info("require remote server, url: {}, interface: {}, version: {}, request data: {}, result: {}",
                url, interfaceName, version, data, res);
        if(resp.getCode() != 0){
            throw new Exception("require remote server error");
        }
        return resp.getData();
    }
}

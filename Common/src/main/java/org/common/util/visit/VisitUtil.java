package org.common.util.visit;

import com.alibaba.fastjson.JSONObject;
import org.common.HttpService;
import org.common.constant.AddressEnum;
import org.common.util.visit.model.VisitReq;
import org.common.util.visit.model.VisitResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisitUtil {

    private static final Logger log = LoggerFactory.getLogger(VisitUtil.class);

    private HttpService httpService;

    public<T> T visit(AddressEnum address, String interfaceName, String version, String data) throws Throwable{
        return visit(address.getModule(), address.getAddress(), interfaceName, version, data);
    }

    public<T> T visit(String url, String interfaceName, String version, String data) throws Throwable {
        return visit("", url, interfaceName, version, data);
    }

    private <T> T visit(String serverName, String serverUrl, String interfaceName, String version, String requireData) throws Throwable {
        VisitReq request = new VisitReq();
        request.setData(requireData);
        request.setName(interfaceName);
        request.setVersion(version);
        String res = httpService.post(serverUrl, JSONObject.toJSONString(request));
        VisitResp<T> resp = JSONObject.parseObject(res, VisitResp.class);
        if(null == serverName || "".equals(serverName)){
            serverName = "remote server";
        }
        log.info("require {}, url: {}, interface: {}, version: {}, request data: {}, result: {}",
                serverName, serverUrl, interfaceName, version, requireData, res);
        if(resp.getCode() != 0){
            log.error("require {} error, url: {}, interface: {}, version: {}, require data, response code: {}",
                    serverName, serverUrl, interfaceName, version, requireData);
            throw new Exception("require remote server error");
        }
        return resp.getData();
    }

    public VisitUtil() {
        httpService = new HttpService();
    }
}

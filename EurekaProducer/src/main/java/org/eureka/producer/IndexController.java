package org.eureka.producer;

import com.gitee.easyopen.ApiConfig;
import com.gitee.easyopen.interceptor.ApiInterceptor;
import com.gitee.easyopen.support.ApiController;
import org.eureka.producer.util.LogInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * api doc: http://localhost:7120/doc
 * @author cartoon
 * @description
 */
@RestController
@RequestMapping
public class IndexController extends ApiController {

    @Override
    protected void initApiConfig(ApiConfig apiConfig) {
        apiConfig.getIsvModules().add("i18n/isv/error");
        apiConfig.setApiName("name");
        apiConfig.setDataName("data");
        apiConfig.setShowDoc(true);
        apiConfig.setDefaultVersion("1.0");
        apiConfig.setIgnoreValidate(true);
        apiConfig.setInterceptors(new ApiInterceptor[]{new LogInterceptor()});
    }
}

package org.common;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpService {

    private static final Logger log = LoggerFactory.getLogger(HttpService.class);

    public String post(String url, String data) throws Throwable {
        String res = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(180 * 1000).setConnectionRequestTimeout(180 * 1000)
                .setSocketTimeout(180 * 1000).setRedirectsEnabled(true).build();
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Content-Type", "application/json");
        try {
            httpPost.setEntity(new StringEntity(data, ContentType.create("application/json", "utf-8")));
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                res = EntityUtils.toString(response.getEntity());
            }
        } catch (Throwable e) {
            log.error("require remote server error, url: {}, data: {}, error: {}", url, data, e.getMessage());
            throw e;
        } finally {
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null == res){
                res = "";
            }
        }
        log.info("require server, url: {}, data: {}, res: {}", url, data, res);
        return res;
    }
}

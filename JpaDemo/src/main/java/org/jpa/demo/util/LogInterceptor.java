package org.jpa.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gitee.easyopen.ApiMeta;
import com.gitee.easyopen.interceptor.ApiInterceptorAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;

/**
 * @author cartoon
 * @description
 * @date 2020/1/28 4:43 PM
 */
public class LogInterceptor extends ApiInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    private Long startTime;

    private Long endTime;

    private JSONObject reqData;

    private JSONObject respData;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object serviceObj, Object argu) throws Exception {
        startTime = System.currentTimeMillis();
        reqData = new JSONObject();
        reqData.put("请求接口", serviceObj.getClass().getName());
        reqData.put("请求数据类名", argu == null ? "" : argu.getClass().getName());
        reqData.put("请求参数", getReqArg(argu));
        return true;
    }

    /**
     * 获取请求参数
     * @param argu
     * @return
     */
    private JSONObject getReqArg(Object argu) throws Exception{
        JSONObject res = new JSONObject();
        if(argu == null){
            return res;
        }
        Class c = Class.forName(argu.getClass().getName());
        Field[] fields = c.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            res.put(field.getName(), field.get(argu));
            field.setAccessible(false);
        }
        Class superClass = c.getSuperclass();
        Field[] superFields = superClass.getDeclaredFields();
        for(Field field : superFields){
            field.setAccessible(true);
            res.put(field.getName(), field.get(argu));
            field.setAccessible(false);
        }
        return res;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object serviceObj, Object argu, Object result, Exception e) throws Exception {
        endTime = System.currentTimeMillis();
        respData = new JSONObject();
        respData.put("接口名", serviceObj.getClass().getName());
        if(argu != null){
            respData.put("参数类", argu.getClass().getName());
        }
        respData.put("结果", JSON.toJSONString(result));
        respData.put("异常信息", e);
        log.info("请求数据：{}", reqData.toString());
        log.info("返回数据：{}", respData.toJSONString());
        log.info("请求耗时：{}ms", endTime - startTime);
    }

    @Override
    public boolean match(ApiMeta apiMeta) {
        return super.match(apiMeta);
    }
}

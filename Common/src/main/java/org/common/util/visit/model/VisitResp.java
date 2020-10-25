package org.common.util.visit.model;

import com.alibaba.fastjson.annotation.JSONField;

public class VisitResp<T> {

    @JSONField(name = "code")
    private Integer code;

    @JSONField(name = "data")
    T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

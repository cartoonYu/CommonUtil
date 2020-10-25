package org.common.util.visit.model;

import com.alibaba.fastjson.annotation.JSONField;

public class VisitReq {

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "version")
    private String version;

    @JSONField(name = "data")
    private String data;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

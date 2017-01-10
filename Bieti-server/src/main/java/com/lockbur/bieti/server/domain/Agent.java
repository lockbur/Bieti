package com.lockbur.bieti.server.domain;

import java.io.Serializable;

/**
 * Created by wangkun23 on 2017/1/10.
 */
public class Agent implements Serializable {

    private String id;
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

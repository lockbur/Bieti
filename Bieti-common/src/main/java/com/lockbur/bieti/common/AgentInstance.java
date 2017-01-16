package com.lockbur.bieti.common;

import java.io.Serializable;

/**
 * Created by wangkun23 on 2017/1/16.
 */
public class AgentInstance implements Serializable {
    private Integer id;
    private String name;
    private String path;//实例路径 /export/App/test.lockbur.com/server1
    private Integer port;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}

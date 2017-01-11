package com.lockbur.bieti.server.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 上线任务
 * Created by wangkun23 on 2017/1/11.
 */
public class DeployJob implements Serializable {

    private Integer id;
    private String name;
    private Integer appId;//应用的id
    private Date deployTime;//部署时间


    private Date createdTime;//创建时间
    private Date modifiedTime;//最后更新时间

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

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Date getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Date deployTime) {
        this.deployTime = deployTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}

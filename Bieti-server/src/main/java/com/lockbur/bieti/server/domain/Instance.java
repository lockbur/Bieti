package com.lockbur.bieti.server.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务器实例 一台服务器可能有多个实例存在
 * Created by wangkun23 on 2017/1/15.
 */
public class Instance implements Serializable {

    private Integer id;

    private Integer appServerId;//所属应用的ID

    private String address;//ip地址
    private String hostname;//主机名
    private String path;//实例路径 /export/App/server1

    private Date createdTime;//创建时间
    private Date modifiedTime;//最后更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppServerId() {
        return appServerId;
    }

    public void setAppServerId(Integer appServerId) {
        this.appServerId = appServerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

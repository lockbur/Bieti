package com.lockbur.bieti.server.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务器管理
 * Created by wangkun23 on 2017/1/11.
 */
public class AppServer implements Serializable {

    private Integer id;
    private String address;//ip地址
    private String hostname;//主机名
    private String osName;//操作系统

    private Date createdTime;//创建时间
    private Date modifiedTime;//最后更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
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

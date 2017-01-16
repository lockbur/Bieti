package com.lockbur.bieti.common;

import com.lockbur.bieti.common.enums.CommandType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 指令规则定义
 * Created by wangkun23 on 2017/1/9.
 */
public class CommandMessage implements Serializable {

    private Integer appId;//应用Id
    private String appName;//应用名称
    private String appPath;//应用的路径/export/App/test.lockbur.com 或者 /export/Domains/test.lockbur.com
    private String appVersion;//应用版本号
    private CommandType type;//指令类型

    private Integer jobId;//上线任务ID

    private List<AgentInstance> instances = new ArrayList<>();

    public CommandMessage() {

    }

    public CommandMessage(Integer appId, String appName, String appPath, String appVersion, CommandType type, Integer jobId) {
        this.appId = appId;
        this.appName = appName;
        this.appPath = appPath;
        this.appVersion = appVersion;
        this.type = type;
        this.jobId = jobId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public List<AgentInstance> getInstances() {
        return instances;
    }

    public void setInstances(List<AgentInstance> instances) {
        this.instances = instances;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public void addInstance(AgentInstance instance) {
        instances.add(instance);
    }
}

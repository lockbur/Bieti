package com.lockbur.bieti.server.domain;

import java.io.Serializable;

/**
 * 项目管理
 * Created by wangkun23 on 2017/1/6.
 */
public class Project implements Serializable {

    private Integer id;
    private String name;
    private String command;

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

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}

package com.lockbur.bieti.common;

import java.io.Serializable;

/**
 * Created by wangkun23 on 2017/1/9.
 */
public class CommandMessage implements Serializable {

    private Integer id;
    private String type;
    private String instance;//server1 or server2
    private String command;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}

package com.lockbur.bieti.common.jgroups;

import java.io.Serializable;

/**
 * Created by wangkun23 on 2017/1/9.
 */
public class CommandMessage implements Serializable {

    private String type;
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
}

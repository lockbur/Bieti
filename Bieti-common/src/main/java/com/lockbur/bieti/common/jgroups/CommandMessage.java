package com.lockbur.bieti.common.jgroups;

import java.io.Serializable;

/**
 * Created by wangkun23 on 2017/1/9.
 */
public class CommandMessage implements Serializable {

    private String command;


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}

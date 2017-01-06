package com.lockbur.bieti.agent.jgroups;

import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

/**
 * Created by wangkun23 on 2017/1/6.
 */
public class CommandReceiverAdapter extends ReceiverAdapter {

    public void viewAccepted(View view) {
        System.out.println("** view: " + view);
    }

    public void receive(Message msg) {
        System.out.println("received msg from " + msg.getSrc() + ": " + msg.getObject());
    }

}

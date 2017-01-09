package com.lockbur.bieti.agent.jgroups;

import com.lockbur.bieti.common.jgroups.CommandMessage;
import org.apache.commons.exec.*;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by wangkun23 on 2017/1/6.
 */
public class CommandReceiverAdapter extends ReceiverAdapter {

    private static final Logger logger = LoggerFactory.getLogger(CommandReceiverAdapter.class);

    public void viewAccepted(View view) {
        System.out.println("** view: " + view);
    }

    @Override
    public void receive(Message msg) {

        CommandMessage cmdMessage = (CommandMessage) msg.getObject();
        logger.info("received msg from {} : {}", msg.getSrc(), cmdMessage.getCommand());


        //解释执行shell脚本
        CommandLine cmdLine = new CommandLine("ipconfig");
        cmdLine.addArgument("/all");

        DefaultExecutor executor = new DefaultExecutor();

        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(new CollectingLogOutputStream());

        ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
        executor.setWatchdog(watchdog);


        executor.setStreamHandler(pumpStreamHandler);
        try {
//            executor.execute(cmdLine, resultHandler);
            executor.execute(cmdLine);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            resultHandler.waitFor();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

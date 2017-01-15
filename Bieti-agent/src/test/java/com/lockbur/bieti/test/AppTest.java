package com.lockbur.bieti.test;

import com.lockbur.bieti.agent.jgroups.CollectingLogOutputStream;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by wangkun23 on 2017/1/11.
 */
public class AppTest {

    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    public static void main(String[] args) {
        try {

            String command = "ping baidu.com";
            String command2 = "java -version";

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

            CommandLine commandline = CommandLine.parse(command);

            CommandLine commandline2 = CommandLine.parse(command2);

            DefaultExecutor exec = new DefaultExecutor();

            exec.setExitValues(null);
             PumpStreamHandler streamHandler = new PumpStreamHandler();
            //PumpStreamHandler streamHandler = new PumpStreamHandler(new CollectingLogOutputStream());

            exec.setStreamHandler(streamHandler);

            exec.execute(commandline);
            exec.execute(commandline2);
            String out = outputStream.toString("gbk");

            String error = errorStream.toString("gbk");

            logger.info("out{}.", out.toString());

            logger.info("error{}.", error);


        } catch (Exception e) {

            logger.error("ping task failed.", e);
        }
    }
}

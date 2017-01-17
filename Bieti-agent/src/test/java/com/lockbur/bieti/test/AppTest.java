package com.lockbur.bieti.test;

import com.lockbur.bieti.agent.jgroups.CollectingLogOutputStream;
import org.apache.commons.exec.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by wangkun23 on 2017/1/11.
 */
public class AppTest {

    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    public static void main(String[] args) {
        try {

            File dir = new File("/export/App/test.zhongfl.com/server1/bin");

            DefaultExecutor executor = new DefaultExecutor();
            executor.setWorkingDirectory(dir);
            ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
            executor.setWatchdog(watchdog);

            //设置执行命令成功的退出值为1
            executor.setExitValue(1);

            PumpStreamHandler streamHandler = new PumpStreamHandler(new CollectingLogOutputStream());
            executor.setStreamHandler(streamHandler);

            CommandLine commandline = null;

            //stop
            String command = "cmd.exe /C shutdown.bat";
            commandline = CommandLine.parse(command);

            DefaultExecuteResultHandler resultHandler1 = new DefaultExecuteResultHandler();

            executor.execute(commandline, resultHandler1);
            logger.info("commandline stop complete .");
            resultHandler1.waitFor();

            //start
            command = "cmd.exe /C startup.bat";
            commandline = CommandLine.parse(command);
            DefaultExecuteResultHandler resultHandler2= new DefaultExecuteResultHandler();
            executor.execute(commandline, resultHandler2);
            logger.info("commandline start complete .");
            resultHandler2.waitFor();

            //resultHandler.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("commandline execute failed {}.", e);
        }
    }
}

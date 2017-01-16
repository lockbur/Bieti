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

            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

                String command = "cmd.exe /C shutdown.bat ; cmd.exe /C startup.bat";
                CommandLine commandline = CommandLine.parse(command);

                PumpStreamHandler streamHandler = new PumpStreamHandler(new CollectingLogOutputStream());

                executor.setStreamHandler(streamHandler);
                executor.execute(commandline,resultHandler);
                logger.info("commandline execute success .");

            //resultHandler.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("commandline execute failed {}.", e);
        }
    }
}

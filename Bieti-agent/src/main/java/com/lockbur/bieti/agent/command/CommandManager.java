package com.lockbur.bieti.agent.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lockbur.bieti.agent.jgroups.CollectingLogOutputStream;
import com.lockbur.bieti.common.AgentInstance;
import com.lockbur.bieti.common.CommandMessage;
import org.apache.commons.exec.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.File;
import java.io.IOException;

/**
 * Created by wangkun23 on 2017/1/15.
 */
public class CommandManager {

    private final Logger logger = LoggerFactory.getLogger(CommandManager.class);

    public void processCommand(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CommandMessage message = mapper.readValue(webSocketMessage.getPayload().toString(), CommandMessage.class);
            for (AgentInstance instance : message.getInstances()) {
                logger.info("getInstances {}", instance);
                try {
                    File dir = new File(instance.getPath() + "/bin");
                    //http://blog.csdn.net/fd_mas/article/details/50147701
                    DefaultExecutor executor = new DefaultExecutor();
                    executor.setWorkingDirectory(dir);
                    ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
                    executor.setWatchdog(watchdog);

                    //设置执行命令成功的退出值为1
                    //executor.setExitValue(1);
                    PumpStreamHandler streamHandler = new PumpStreamHandler(new CollectingLogOutputStream());
                    executor.setStreamHandler(streamHandler);

                    switch (message.getType()) {
                        case DEPLOY:
                            deploy(executor);
                            break;
                        case START:
                            start(executor);
                            break;
                        case STOP:
                            stop(executor);
                            break;
                        case RESTART:
                            restart(executor);
                            break;
                        default:
                            logger.info("commandType not correct.");
                    }
                } catch (Exception e) {
                    logger.error("commandline execute failed {}.", e);
                }
            }//for
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("processCommand {}", e);
        }
        logger.info("{},command {}", webSocketSession.getId(), webSocketMessage.getPayload());
    }

    /**
     * 部署系统先执行抽包准备 然后停止脚本 在执行启动脚本
     *
     * @param executor
     * @throws IOException
     * @throws InterruptedException
     */
    private void deploy(DefaultExecutor executor) throws IOException, InterruptedException {
        //start
        String command = "cmd.exe /C deploy.bat";
        CommandLine commandline = CommandLine.parse(command);

        DefaultExecuteResultHandler resultDeployHandler = new DefaultExecuteResultHandler();
        executor.execute(commandline, resultDeployHandler);
        resultDeployHandler.waitFor();

        //stop
        DefaultExecuteResultHandler resultStopHandler = stop(executor);
        resultStopHandler.waitFor();

        //start
        DefaultExecuteResultHandler resultStartHandler = start(executor);
        resultStartHandler.waitFor();

        logger.info("commandline deploy complete .");
    }


    private DefaultExecuteResultHandler start(DefaultExecutor executor) throws IOException, InterruptedException {
        //start
        String command = "cmd.exe /C startup.bat";
        CommandLine commandline = CommandLine.parse(command);

        DefaultExecuteResultHandler resultStartHandler = new DefaultExecuteResultHandler();
        executor.execute(commandline, resultStartHandler);

        logger.info("commandline start complete .");
        return resultStartHandler;
    }

    private DefaultExecuteResultHandler stop(DefaultExecutor executor) throws IOException, InterruptedException {
        //stop
        String command = "cmd.exe /C shutdown.bat";
        CommandLine commandline = CommandLine.parse(command);

        DefaultExecuteResultHandler resultStopHandler = new DefaultExecuteResultHandler();
        executor.execute(commandline, resultStopHandler);
        logger.info("commandline stop complete .");

        return resultStopHandler;
    }

    private void restart(DefaultExecutor executor) throws IOException, InterruptedException {

        //stop
        DefaultExecuteResultHandler resultStopHandler = stop(executor);
        resultStopHandler.waitFor();

        //start
        DefaultExecuteResultHandler resultStartHandler = start(executor);
        //resultStartHandler.waitFor();

        logger.info("commandline restart complete .");
    }


}

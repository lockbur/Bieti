package com.lockbur.bieti.agent.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lockbur.bieti.agent.jgroups.CollectingLogOutputStream;
import com.lockbur.bieti.common.AgentInstance;
import com.lockbur.bieti.common.CommandMessage;
import com.lockbur.bieti.common.enums.CommandType;
import org.apache.commons.exec.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
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

                    switch (message.getType()) {
                        case DEPLOY:
                            logger.info("START execute success .");
                            break;
                        case START:
                            logger.info("START execute success .");
                            break;

                        case STOP:
                            logger.info("STOP execute success .");
                            break;
                        case RESTART:
                            logger.info("RESTART execute success .");
                            break;
                        default:
                            logger.info("commandType not correct.");
                    }
                    //http://blog.csdn.net/fd_mas/article/details/50147701
                    DefaultExecutor executor = new DefaultExecutor();
                    executor.setWorkingDirectory(dir);
                    ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
                    executor.setWatchdog(watchdog);

                    //设置执行命令成功的退出值为1
                    //executor.setExitValue(1);

                    DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

                    String command = "cmd.exe /C startup.bat";
                    CommandLine commandline = CommandLine.parse(command);

                    PumpStreamHandler streamHandler = new PumpStreamHandler(new CollectingLogOutputStream());

                    executor.setStreamHandler(streamHandler);
                    executor.execute(commandline, resultHandler);

                    logger.info("commandline execute success .");
                    resultHandler.waitFor();

                    logger.info("resultHandler waitFor {}", resultHandler.getException());

                } catch (Exception e) {
                    logger.error("commandline execute failed {}.", e);
                }
            }//for
        } catch (IOException e) {
            logger.error("processCommand {}", e);
        }
        logger.info("{},command {}", webSocketSession.getId(), webSocketMessage.getPayload());
    }
}

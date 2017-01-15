package com.lockbur.bieti.agent.websocket;

import com.lockbur.bieti.agent.command.CommandManager;
import com.lockbur.bieti.agent.jgroups.CollectingLogOutputStream;
import org.apache.commons.exec.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * 用户客户端的websocket数据处理
 * Created by wangkun23 on 2017/1/15.
 */
public class AgentWebSocketHandler implements WebSocketHandler {

    private final Logger logger = LoggerFactory.getLogger(AgentWebSocketHandler.class);

    @Autowired
    private CommandManager commandManager;

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.info("webSocketSession {}", webSocketSession.getId());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        logger.info("webSocketMessageClient {}", webSocketMessage.getPayload());
        commandManager.processCommand(webSocketSession, webSocketMessage);

        //http://blog.csdn.net/fd_mas/article/details/50147701
        try {
            File dir = new File("/export/App/server1/bin");

            DefaultExecutor executor = new DefaultExecutor();
            executor.setWorkingDirectory(dir);
            ExecuteWatchdog watchdog = new ExecuteWatchdog(60000);
            executor.setWatchdog(watchdog);

            //设置执行命令成功的退出值为1
            executor.setExitValue(1);

            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

            String command = "cmd.exe /C startup.bat";
            CommandLine commandline = CommandLine.parse(command);

            PumpStreamHandler streamHandler = new PumpStreamHandler(new CollectingLogOutputStream());

            executor.setStreamHandler(streamHandler);
            executor.execute(commandline, resultHandler);

            logger.info("commandline execute success .");
            //resultHandler.waitFor();
        } catch (Exception e) {
            logger.error("commandline execute failed {}.", e);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.info("afterConnectionClosed {}", webSocketSession.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}

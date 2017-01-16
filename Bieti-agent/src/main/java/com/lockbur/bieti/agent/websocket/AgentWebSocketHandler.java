package com.lockbur.bieti.agent.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lockbur.bieti.agent.command.CommandManager;
import com.lockbur.bieti.agent.jgroups.CollectingLogOutputStream;
import com.lockbur.bieti.common.AgentInstance;
import com.lockbur.bieti.common.CommandMessage;
import org.apache.commons.exec.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * 用户客户端的websocket数据处理
 * Created by wangkun23 on 2017/1/15.
 */
public class AgentWebSocketHandler implements WebSocketHandler {

    private final Logger logger = LoggerFactory.getLogger(AgentWebSocketHandler.class);


    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.info("webSocketSession {}", webSocketSession.getId());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        logger.info("webSocketMessageClient {}", webSocketMessage.getPayload());
        CommandManager commandManager = new CommandManager();
        commandManager.processCommand(webSocketSession, webSocketMessage);
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

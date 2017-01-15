package com.lockbur.bieti.server.websocket;

import com.lockbur.bieti.server.manager.AgentManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketHandler extends TextWebSocketHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AgentManager agentManager;



    //@Autowired
    //private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        agentManager.addAgent(session);



        logger.info("getHostString connect {}",session.getRemoteAddress().getHostString());
        logger.info("getRemoteAddress connect {}", session.getRemoteAddress());
        logger.info("websocket connect {}", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.info("websocket closed {}", session.getId());
        agentManager.removeAgent(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("websocket handleTextMessage {} message {}", session.getId(), message.getPayload());

        agentManager.broadcast(message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

        exception.printStackTrace();
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        logger.info("websocket handlePongMessage {} message {}", session.getId(), message.getPayload());
        super.handlePongMessage(session, message);
    }
}
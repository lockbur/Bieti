package com.lockbur.bieti.server.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.ConcurrentHashMap;

public class WebSocketHandler extends TextWebSocketHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    private ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    //@Autowired
    //private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.putIfAbsent(session.getId(),session);
        logger.info("websocket connect {}", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.info("websocket closed {}", session.getId());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("websocket closed {} message {}", session.getId(),message.getPayload());



        session.sendMessage(new TextMessage("我是服务器端的消息"));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

        exception.printStackTrace();
    }
}
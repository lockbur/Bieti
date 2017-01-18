package com.lockbur.bieti.agent.websocket;

import com.lockbur.bieti.agent.command.CommandManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 用户客户端的websocket数据处理
 * Created by wangkun23 on 2017/1/15.
 */
public class AgentWebSocketHandler implements WebSocketHandler {

    private final Logger logger = LoggerFactory.getLogger(AgentWebSocketHandler.class);

    private volatile boolean connected = false;

    @Value("${agent.sockjs.server}")
    private String serverUrl;

    private SockJsClient sockJsClient;

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        this.connected = true;
        logger.info("webSocketSession webSocketSession {}", webSocketSession.isOpen());
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
        this.connected = false;
        webSocketSession.close();
        logger.info("webSocketSession webSocketSession {}", webSocketSession.isOpen());
        logger.info("afterConnectionClosed {}", webSocketSession.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    @Scheduled(cron = "0/20 * * * * ?")
    public void doSomethingWith() {
        logger.debug("sockJsClient.connected {}", this.connected);
        if (!connected) {
            Transport webSocketTransport = new WebSocketTransport(new StandardWebSocketClient());
            List<Transport> transports = Collections.singletonList(webSocketTransport);
            SockJsClient sockJsClient = new SockJsClient(transports);
            sockJsClient.doHandshake(this, serverUrl);
        }
    }
}

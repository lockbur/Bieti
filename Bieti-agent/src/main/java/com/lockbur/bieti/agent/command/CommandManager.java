package com.lockbur.bieti.agent.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by wangkun23 on 2017/1/15.
 */
@Component
public class CommandManager {

    private final Logger logger = LoggerFactory.getLogger(CommandManager.class);

    public void processCommand(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) {
        logger.info("{},command {}", webSocketSession.getId(), webSocketMessage.getPayload());
    }
}

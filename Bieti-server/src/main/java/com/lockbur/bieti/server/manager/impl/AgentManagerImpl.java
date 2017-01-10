package com.lockbur.bieti.server.manager.impl;

import com.lockbur.bieti.server.manager.AgentManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.swing.*;
import java.util.Collection;
import java.util.Collections;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangkun23 on 2017/1/10.
 */
@Service
public class AgentManagerImpl implements AgentManager {

    private static final Logger logger = LoggerFactory.getLogger(AgentManagerImpl.class);


    private static final ConcurrentHashMap<String, WebSocketSession> agents = new ConcurrentHashMap<String, WebSocketSession>();

    @Override
    public synchronized void addAgent(WebSocketSession session) {
        agents.put(session.getId(), session);
    }

    @Override
    public Collection<WebSocketSession> getAgents() {
        return Collections.unmodifiableCollection(agents.values());
    }

    @Override
    public synchronized void removeAgent(WebSocketSession session) {
        agents.remove(session.getId());
    }

    @Override
    public void broadcast(String message) throws Exception {
        for (WebSocketSession session : getAgents()) {
            session.sendMessage(new TextMessage(message));
        }
    }

    @Override
    public void sendMessage(String sessionId, String message) throws Exception {
        if (agents.containsKey(sessionId)) {
            agents.get(sessionId).sendMessage(new TextMessage(message));
        } else {
            logger.warn("sessionId {} disconnect.", sessionId);
        }
    }

}

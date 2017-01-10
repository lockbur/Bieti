package com.lockbur.bieti.server.manager;

import org.springframework.web.socket.WebSocketSession;

import java.util.Collection;

/**
 * Created by wangkun23 on 2017/1/10.
 */
public interface AgentManager {

    public void addAgent(WebSocketSession session);

    public Collection<WebSocketSession> getAgents();

    public void removeAgent(WebSocketSession session);

    public void broadcast(String message) throws Exception;

    public void sendMessage(String sessionId, String message) throws Exception;

}

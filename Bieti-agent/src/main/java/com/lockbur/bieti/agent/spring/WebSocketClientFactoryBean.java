package com.lockbur.bieti.agent.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.util.Assert;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.Collections;
import java.util.List;

public class WebSocketClientFactoryBean extends AbstractFactoryBean<SockJsClient> {
    final Logger logger = LoggerFactory.getLogger(WebSocketClientFactoryBean.class);

    private String serverUrl;
    private WebSocketHandler webSocketHandler;

    @Override
    public SockJsClient createInstance() throws Exception {

        logger.info("sockjs server is: {}", serverUrl);

        Assert.hasText(serverUrl, "serverUrl is null or empty");

        Assert.notNull(webSocketHandler, "webSocketHandler is null or empty");

        Transport webSocketTransport = new WebSocketTransport(new StandardWebSocketClient());
        List<Transport> transports = Collections.singletonList(webSocketTransport);

        SockJsClient sockJsClient = new SockJsClient(transports);

        try {
            sockJsClient.doHandshake(webSocketHandler, serverUrl);
            sockJsClient.start();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            sockJsClient.stop();
        }
        return sockJsClient;

    }

    @Override
    public Class<?> getObjectType() {
        return SockJsClient.class;
    }

    @Override
    protected void destroyInstance(SockJsClient instance) throws Exception {
        instance.stop();
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public void setWebSocketHandler(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }
}
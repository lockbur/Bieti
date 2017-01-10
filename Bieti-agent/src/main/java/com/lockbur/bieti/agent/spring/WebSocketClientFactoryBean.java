package com.lockbur.bieti.agent.spring;

import com.lockbur.bieti.agent.websocket.CommandHandlerSocket;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.util.Assert;

import java.net.URI;

public class WebSocketClientFactoryBean extends AbstractFactoryBean<WebSocketClient> {

    private String serverUrl;

    private CommandHandlerSocket commandHandlerSocket;

    @Override
    public WebSocketClient createInstance() throws Exception {

        Assert.hasText(serverUrl, "serverUrl is null or empty");
        Assert.notNull(commandHandlerSocket, "commandHandlerSocket  is null or empty");

        WebSocketClient client = new WebSocketClient();

        try {
            client.start();

            URI echoUri = new URI(serverUrl);
            ClientUpgradeRequest request = new ClientUpgradeRequest();

            client.connect(commandHandlerSocket, echoUri, request);
            System.out.printf("Connecting to : %s%n", echoUri);

            // wait for closed socket connection.
            //socket.awaitClose(5, TimeUnit.SECONDS);
            System.out.println("Connection closed!");
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                //client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return client;

    }

    @Override
    public Class<?> getObjectType() {
        return WebSocketClient.class;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public void setCommandHandlerSocket(CommandHandlerSocket commandHandlerSocket) {
        this.commandHandlerSocket = commandHandlerSocket;
    }

    @Override
    protected void destroyInstance(WebSocketClient instance) throws Exception {
        //instance.c
    }

}
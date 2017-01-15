package com.lockbur.bieti.test;

import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/15.
 */
public class SockJsClientTest {
    public static void main(String[] args) throws InterruptedException {

        Transport webSocketTransport = new WebSocketTransport(new StandardWebSocketClient());
        List<Transport> transports = Collections.singletonList(webSocketTransport);

        SockJsClient sockJsClient = new SockJsClient(transports);

        //WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        sockJsClient.doHandshake(new MyWebSocketHandler(), "ws://localhost:8080/sockjs/echo");


        Thread.sleep(Integer.MAX_VALUE);
    }
}

package com.lockbur.bieti.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import java.io.IOException;
/**
 * 自动部署系统Agent端程序 启动
 * Created by wangkun23 on 2016/7/25.
 */
public class Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) throws InterruptedException, IOException {

        AbstractApplicationContext cxt = new FileSystemXmlApplicationContext("classpath:spring-config.xml");

        SockJsClient webSocketClient = (SockJsClient) cxt.getBean("sockJsClient");

        final Thread monitor = new StopMonitor(9527);
        monitor.start();
        monitor.join();
        //重要  在关闭jvm之前 需要关闭socket.io的服务器
        logger.info("monitor stopped.");
        cxt.registerShutdownHook();
    }

}

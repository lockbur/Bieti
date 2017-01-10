package com.lockbur.bieti.agent;

import com.lockbur.bieti.agent.jgroups.CommandReceiverAdapter;
import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.stack.IpAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.net.UnknownHostException;

/**
 * 聊天服务器端程序 启动
 * Created by wangkun23 on 2016/7/25.
 */
public class Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) throws InterruptedException, UnknownHostException {


        AbstractApplicationContext cxt = new FileSystemXmlApplicationContext("classpath:spring-config.xml");


        JChannel channel = (JChannel) cxt.getBean("channel");

        Address serverAddress = new IpAddress("127.0.0.1", 10008);

        String serverName = channel.getName(serverAddress);

        logger.info("serverName {}.", serverName);


        channel.setReceiver(new CommandReceiverAdapter());


        final Thread monitor = new StopMonitor(9527);
        monitor.start();
        monitor.join();
        //重要  在关闭jvm之前 需要关闭socket.io的服务器
        logger.info("monitor stopped.");
        cxt.registerShutdownHook();
    }

}

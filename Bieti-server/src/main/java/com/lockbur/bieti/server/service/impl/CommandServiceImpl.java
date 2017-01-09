package com.lockbur.bieti.server.service.impl;

import com.lockbur.bieti.server.service.CommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.jgroups.JChannel;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/1/9.
 */
@Service
public class CommandServiceImpl implements CommandService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private JChannel channel;


    public void deploy() {
        logger.info("app deploy");
    }

    public void start() {

    }

    public void restart() {

    }

    public void stop() {

    }

    public void unDeploy() {

    }

}

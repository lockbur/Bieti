package com.lockbur.bieti.server.service.impl;

import com.lockbur.bieti.common.jgroups.CommandMessage;
import com.lockbur.bieti.server.domain.Application;
import com.lockbur.bieti.server.domain.Project;
import com.lockbur.bieti.server.manager.AgentManager;
import com.lockbur.bieti.server.service.ApplicationService;
import com.lockbur.bieti.server.service.CommandService;
import com.lockbur.bieti.server.service.ProjectService;
import com.lockbur.bieti.server.websocket.WebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.jgroups.JChannel;

import javax.annotation.Resource;

/**
 * Created by wangkun23 on 2017/1/9.
 */
@Service
public class CommandServiceImpl implements CommandService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //@Resource
    //private JChannel channel;
    //@Autowired
    //private WebSocketHandler webSocketHandler;
    @Autowired
    private AgentManager agentManager;

    @Resource
    private ProjectService projectService;

    @Resource
    private ApplicationService applicationService;

    public void deploy(Integer deployJobId) throws Exception {
        logger.info("app deploy");

        Application app = applicationService.findById(1);
        if (app != null) {

            CommandMessage message = new CommandMessage();
            message.setCommand("bin/startup.sh");
            //channel.send(null, message);
            //webSocketHandler.sendMessage("dd","测试消息");
            agentManager.broadcast(app.getCommand());
        } else {
            logger.error("Application not exist id {}", deployJobId);
        }
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

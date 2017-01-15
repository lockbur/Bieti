package com.lockbur.bieti.server.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lockbur.bieti.common.CommandMessage;
import com.lockbur.bieti.server.domain.Application;
import com.lockbur.bieti.server.domain.Instance;
import com.lockbur.bieti.server.manager.AgentManager;
import com.lockbur.bieti.server.service.ApplicationService;
import com.lockbur.bieti.server.service.CommandService;
import com.lockbur.bieti.server.service.InstanceService;
import com.lockbur.bieti.server.service.ProjectService;
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
    private InstanceService instanceService;

    @Resource
    private ApplicationService applicationService;

    public void deploy(Integer instanceId) throws Exception {
        logger.info("app deploy");

        Instance instance = instanceService.findById(instanceId);

        if (instance != null) {

            //channel.send(null, message);
            //webSocketHandler.sendMessage("dd","测试消息");
            CommandMessage command = new CommandMessage();
            command.setId(instanceId);
            command.setType("APPWORKER");
            command.setInstance(instance.getName());
            command.setCommand("start.bat");

            ObjectMapper mapper = new ObjectMapper();
            String message = mapper.writeValueAsString(command);

            agentManager.broadcast(message);
        } else {
            logger.error("Application not exist id {}", instanceId);
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

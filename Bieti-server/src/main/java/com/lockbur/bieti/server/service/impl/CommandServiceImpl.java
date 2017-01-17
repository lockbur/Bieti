package com.lockbur.bieti.server.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lockbur.bieti.common.AgentInstance;
import com.lockbur.bieti.common.CommandMessage;
import com.lockbur.bieti.common.enums.CommandType;
import com.lockbur.bieti.server.domain.App;
import com.lockbur.bieti.server.domain.Instance;
import com.lockbur.bieti.server.manager.AgentManager;
import com.lockbur.bieti.server.service.AppService;
import com.lockbur.bieti.server.service.CommandService;
import com.lockbur.bieti.server.service.InstanceService;
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

    @Autowired
    private AgentManager agentManager;

    @Resource
    private InstanceService instanceService;

    @Resource
    private AppService applicationService;

    public void deploy(Integer instanceId) throws Exception {
        logger.info("app deploy");
        process(instanceId, CommandType.DEPLOY);
    }

    public void start(Integer instanceId) throws Exception {
        process(instanceId, CommandType.START);
    }

    public void restart(Integer instanceId) throws Exception {
        process(instanceId, CommandType.RESTART);
    }

    public void stop(Integer instanceId) throws Exception {
        process(instanceId, CommandType.STOP);
    }

    public void unDeploy(Integer instanceId) {

    }

    /**
     * 抽象出理函数
     *
     * @param instanceId
     * @param type
     * @throws Exception
     */
    private void process(Integer instanceId, CommandType type) throws Exception {
        Instance instance = instanceService.findById(instanceId);

        App app = applicationService.findById(instance.getAppId());

        if (instance != null) {
            CommandMessage command = new CommandMessage();
            command.setAppId(app.getId());
            command.setAppName(app.getName());
            command.setAppPath(app.getPath());
            command.setAppVersion("0");
            command.setJobId(1);

            command.setType(type);

            AgentInstance agentInstance = new AgentInstance();

            agentInstance.setId(instance.getId());
            agentInstance.setName(instance.getName());
            agentInstance.setPath(instance.getPath());
            agentInstance.setPort(0);

            command.addInstance(agentInstance);

            ObjectMapper mapper = new ObjectMapper();
            String message = mapper.writeValueAsString(command);

            agentManager.broadcast(message);
        } else {
            logger.error("App not exist id {}", instanceId);
        }

    }

}

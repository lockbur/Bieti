package com.lockbur.bieti.server.service.impl;

import com.lockbur.bieti.common.jgroups.CommandMessage;
import com.lockbur.bieti.server.domain.Project;
import com.lockbur.bieti.server.service.CommandService;
import com.lockbur.bieti.server.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Resource
    private ProjectService projectService;

    public void deploy(Integer projectId) throws Exception {
        logger.info("app deploy");
        Project project = projectService.findById(projectId);
        if (project != null) {

            CommandMessage message = new CommandMessage();
            message.setCommand("bin/startup.sh");
            //channel.send(null, message);

        } else {
            logger.error("project not exist id {}", projectId);
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

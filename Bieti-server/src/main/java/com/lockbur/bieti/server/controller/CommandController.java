package com.lockbur.bieti.server.controller;

import com.lockbur.bieti.server.domain.Project;
import com.lockbur.bieti.server.rest.ResponseData;
import com.lockbur.bieti.server.service.CommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/9.
 */
@Controller
@RequestMapping("/command")
public class CommandController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CommandService commandService;

    @PostMapping("/deploy")
    @ResponseBody
    public ResponseData deploy(Integer id, Model model) throws Exception {
        logger.info("id is {}", id);
        commandService.deploy(id);
        return ResponseData.success();
    }

    @PostMapping("/start")
    @ResponseBody
    public ResponseData start(Integer id, Model model) throws Exception {
        logger.info("id is {}", id);
        commandService.start(id);
        return ResponseData.success();
    }


    @PostMapping("/restart")
    @ResponseBody
    public ResponseData restart(Integer id, Model model) throws Exception {
        logger.info("id is {}", id);
        commandService.restart(id);
        return ResponseData.success();
    }


    @PostMapping("/stop")
    @ResponseBody
    public ResponseData stop(Integer id, Model model) throws Exception {
        logger.info("id is {}", id);
        commandService.stop(id);
        return ResponseData.success();
    }


}

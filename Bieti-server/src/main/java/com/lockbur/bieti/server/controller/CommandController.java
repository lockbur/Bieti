package com.lockbur.bieti.server.controller;

import com.lockbur.bieti.server.domain.Project;
import com.lockbur.bieti.server.rest.ResponseData;
import com.lockbur.bieti.server.service.CommandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @Resource
    private CommandService commandService;

    @RequestMapping("/deploy")
    @ResponseBody
    public ResponseData list(Model model) {

        commandService.deploy();

        return ResponseData.success();
    }
}

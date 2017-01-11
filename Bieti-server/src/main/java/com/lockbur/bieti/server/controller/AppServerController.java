package com.lockbur.bieti.server.controller;

import com.lockbur.bieti.server.domain.AppServer;
import com.lockbur.bieti.server.service.AppServerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
@Controller
@RequestMapping("/appServer")
public class AppServerController {

    @Resource
    private AppServerService appServerService;


    @RequestMapping("/list")
    public String list(Model model) {

        List<AppServer> list = appServerService.findAll();
        model.addAttribute("list", list);
        return "appServer/list";

    }
}

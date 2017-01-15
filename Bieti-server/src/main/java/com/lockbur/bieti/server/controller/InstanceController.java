package com.lockbur.bieti.server.controller;

import com.lockbur.bieti.server.domain.AppServer;
import com.lockbur.bieti.server.domain.Instance;
import com.lockbur.bieti.server.service.InstanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
@Controller
@RequestMapping("/instance")
public class InstanceController {

    @Resource
    private InstanceService instanceService;


    @RequestMapping("/list/{appServerId}")
    public String list(@PathVariable("appServerId") Integer appServerId, Model model) {

        List<Instance> list = instanceService.findByAppServerId(appServerId);
        model.addAttribute("list", list);

        return "instance/list";

    }
}

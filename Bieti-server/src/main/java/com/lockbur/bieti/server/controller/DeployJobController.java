package com.lockbur.bieti.server.controller;

import com.lockbur.bieti.server.domain.DeployJob;
import com.lockbur.bieti.server.service.DeployJobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/9.
 */
@Controller
@RequestMapping("/deployJob")
public class DeployJobController {

    @Resource
    private DeployJobService deployJobService;


    @RequestMapping("/list")
    public String list(Model model) {

        List<DeployJob> list = deployJobService.findAll();
        model.addAttribute("list", list);
        return "deployJob/list";

    }
}

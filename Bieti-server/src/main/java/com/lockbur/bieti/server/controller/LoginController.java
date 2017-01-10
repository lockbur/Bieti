package com.lockbur.bieti.server.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.lockbur.bieti.server.domain.Project;
import com.lockbur.bieti.server.mapper.ProjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/demo")
public class LoginController {




    @Resource
    private ProjectMapper projectMapper;


    @RequestMapping("/login")
    public String displayLogin(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping("/send")
    public String send(HttpServletRequest request) throws Exception {
        Project project =new Project();
        project.setName("测试");
        project.setCommand("ipconfig");

        projectMapper.insert(project);


        return "login";
    }
}

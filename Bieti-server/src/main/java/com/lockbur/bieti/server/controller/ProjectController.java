package com.lockbur.bieti.server.controller;


import com.lockbur.bieti.server.domain.Project;
import com.lockbur.bieti.server.mapper.ProjectMapper;
import org.jgroups.JChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectMapper projectMapper;


    @RequestMapping("/list")
    public String list() {

        return "project/list";
    }


    @RequestMapping("/edit/{id}")
    public String displayEdit(@PathVariable("id") Integer id) {

        return "project/edit";
    }

    @RequestMapping("/update")
    public String update(Project project) {

        return "/project/edit";
    }
}

package com.lockbur.bieti.server.controller;


import com.lockbur.bieti.server.domain.Project;
import com.lockbur.bieti.server.service.ProjectService;
import org.jgroups.JChannel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;


    @RequestMapping("/list")
    public String list(Model model) {
        List<Project> list = projectService.findAll();
        model.addAttribute("list", list);
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

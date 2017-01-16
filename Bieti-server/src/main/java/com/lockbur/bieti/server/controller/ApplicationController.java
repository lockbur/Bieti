package com.lockbur.bieti.server.controller;

import com.lockbur.bieti.server.domain.App;
import com.lockbur.bieti.server.service.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/9.
 */
@Controller
@RequestMapping("/app")
public class ApplicationController {

    @Resource
    private AppService applicationService;


    @RequestMapping("/list")
    public String list(Model model) {

        List<App> list = applicationService.findAll();
        model.addAttribute("list", list);
        return "app/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        App app = applicationService.findById(id);
        model.addAttribute("app", app);
        return "app/edit";
    }


    @RequestMapping("/update")
    public String update(App app) {
        applicationService.update(app);
        return "redirect:/app/list";
    }

}

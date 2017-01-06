package com.lockbur.bieti.server.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jgroups.JChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/demo")
public class LoginController {

    @Resource
    private JChannel channel;

    @RequestMapping("/login")
    public String displayLogin(HttpServletRequest request) {

        return "login";
    }

    @RequestMapping("/send")
    public String send(HttpServletRequest request) throws Exception {

        channel.send(null, "send12312312312312");

        return "login";
    }
}

package com.lockbur.bieti.server.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    public String displayLogin(HttpServletRequest request) {

        return "login";
    }


}

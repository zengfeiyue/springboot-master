package com.spring.boot.controller;


import com.spring.boot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
    @Autowired
    SysUserService userService;

    /*@RequestMapping(value = "/login")
    @ResponseBody
    public Object login(@AuthenticationPrincipal User loginedUser, @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            return null;
        }
        if (loginedUser != null) {
            return userService.getById(loginedUser.getId());
        }
        return null;
    }*/
    @RequestMapping(value = "/login")
    public String login() {

        return "login";
    }
    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }
}

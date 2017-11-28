package com.spring.boot.controller;


import com.spring.boot.moduls.security.SysUser;
import com.spring.boot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zengfeiyue
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {

        return "login";
    }
    @RequestMapping(value = "/home")
    public String home() {
        System.err.println("123");
        return "home";
    }

}

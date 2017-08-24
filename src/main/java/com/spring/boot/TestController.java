package com.spring.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zfy on 2017/8/24.
 */
@RestController
public class TestController {
    @RequestMapping("/home")
    public String test(){
        return "hello world";
    }
}

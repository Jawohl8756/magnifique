package com.wunderbar.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rommel
 * @date 2021/1/25 21:29
 * @description 控制器接收前端请求
 */
@RestController
public class IntroController {

    @GetMapping("/heil")
    public String sayHello(){
        return "Hello ,Spring Boot!";
    }
}

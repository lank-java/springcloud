package com.lank.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lank
 * @since 2020/11/17 22:19
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/sayHi")
    public String sayHi(){
        return "这是"+port+"提供的服务!!!";
    }

    @PostMapping("/sayHi")
    public Demo sayHi(@RequestBody Demo demo){
        demo.setPort(port);
        return demo;
    }
}

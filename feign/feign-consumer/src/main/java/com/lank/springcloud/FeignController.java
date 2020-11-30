package com.lank.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lank
 * @since 2020/11/29 16:46
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private IService service;

    @GetMapping("/hello")
    public String hello(){
        return service.sayHi();
    }
}

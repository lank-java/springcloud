package com.lank.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lank
 * @since 2020/11/30 22:07
 */

@RestController
public class HelloController {

    @Autowired
    private IService iService;

    @GetMapping("/hello")
    public String hello(){
        return iService.sayHi();
    }

    @GetMapping("/retry")
    public String retry(Integer timeout){
        return iService.retry(timeout);
    }
}

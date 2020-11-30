package com.lank.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lank
 * @since 2020/11/27 11:45
 */

@RestController
@RequestMapping("/ribbon")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
       return restTemplate.getForObject("http://eureka-client/sayHi",String.class);
    }
}

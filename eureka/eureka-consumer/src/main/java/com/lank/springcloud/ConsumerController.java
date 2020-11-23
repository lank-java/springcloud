package com.lank.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lank
 * @since 2020/11/23 21:13
 */

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    /**
     * 负载均衡，后续可以用Ribbon代替
     */
    @Autowired
    private LoadBalancerClient balancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        ServiceInstance instance = balancerClient.choose("eureka-client");
        if (instance==null){
            return "没有找到服务！！！";
        }
        String url = String.format("http://%s:%s/sayHi",instance.getHost(),instance.getPort());
        log.info("url is :"+url);
        return restTemplate.getForObject(url, String.class);
    }

    @PostMapping("/hello")
    public Demo helloPost(){
        ServiceInstance instance = balancerClient.choose("eureka-client");
        if (instance==null){
            return null;
        }
        String url = String.format("http://%s:%s/sayHi",instance.getHost(),instance.getPort());
        log.info("url is :"+url);
        Demo demo = new Demo();
        demo.setName("eureka consumer");
        return restTemplate.postForObject(url,demo,Demo.class);
    }
}

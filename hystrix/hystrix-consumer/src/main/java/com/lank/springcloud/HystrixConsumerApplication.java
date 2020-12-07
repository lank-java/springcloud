package com.lank.springcloud;

import feign.Feign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lank
 * @since 2020/12/6 16:38
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lank.springcloud")
@EnableCircuitBreaker
public class HystrixConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumerApplication.class,args);
//        try {
//            System.out.println(Feign.configKey(MyService.class, MyService.class.getMethod("retry", Integer.class)));
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }
}

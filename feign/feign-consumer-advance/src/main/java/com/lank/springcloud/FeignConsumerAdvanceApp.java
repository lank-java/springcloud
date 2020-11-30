package com.lank.springcloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author lank
 * @since 2020/11/30 22:08
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignConsumerAdvanceApp {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerAdvanceApp.class,args);
    }
}

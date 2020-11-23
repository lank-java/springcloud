package com.lank.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lank
 * @since 2020/11/17 21:47
 * 注册中心启动类
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {

        SpringApplication.run(EurekaServerApplication.class);
    }
}

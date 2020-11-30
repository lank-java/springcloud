package com.lank.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lank
 * @since 2020/11/30 22:00
 */

@Slf4j
@RestController
public class HelloController implements IService{

    @Value("${server.port}")
    private String port;

    public String sayHi() {
        return "这是"+port+"提供的服务!!!";
    }

    public Demo sayHi(Demo demo) {
        demo.setPort(port);
        return demo;
    }

    public String retry(Integer timeout) {
        log.info("这是"+port);
        while (timeout-->0){
            try {
                Thread.sleep(timeout*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return port;
    }
}

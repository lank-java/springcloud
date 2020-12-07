package com.lank.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lank
 * @since 2020/12/6 17:57
 */
@Slf4j
@Component
public class RequestCacheService {

    @Autowired
    private MyService service;

    @CacheResult
    @HystrixCommand(commandKey = "cacheKey") //方法级降级参数
    public Demo requestCache(@CacheKey String name){
        log.info("开始请求requestCache,name={}",name);
        Demo demo = new Demo();
        demo.setName(name);

        demo = service.sayHi(demo);
        log.info("结束请求requestCache,name={}",name);
        return demo;
    }
}

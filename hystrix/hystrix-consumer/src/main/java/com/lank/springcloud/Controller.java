package com.lank.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lank
 * @since 2020/12/6 16:47
 */
@RestController
public class Controller {

    @Resource
    private MyService myService;

    @Autowired
    private RequestCacheService requestCacheService;

    /**
     * hystrix服务降级
     */
    @GetMapping("/fallback")
    public String error(){
        return myService.error();
    }

    @GetMapping("/hello")
    public String hello(){
        return myService.sayHi();
    }

    /**
     * hystrix超时
     */
    @GetMapping("/timeout")
    public String timeout(Integer timeout){
        return myService.retry(timeout);
    }


    /**
     * hystrix超时
     */
    @GetMapping("/timeout2")
    @HystrixCommand(
            fallbackMethod = "timeoutFallback",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String timeout2(Integer timeout){
        return myService.retry(timeout);
    }

    public String timeoutFallback(Integer timeout){
        return "success";
    }

    /**
     * hystrix RequestCache使用
     */
    @GetMapping("/cache")
    public Demo cache(String name){
        //同一个上下文中只调用一次
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try{
            //请求两次测试requestCache功能
            Demo demo = requestCacheService.requestCache(name);
            demo = requestCacheService.requestCache(name);
            return demo;
        }finally {
            // 关闭上下文
            context.close();
        }
    }
}

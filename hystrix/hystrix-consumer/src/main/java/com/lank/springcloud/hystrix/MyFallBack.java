package com.lank.springcloud.hystrix;

import com.lank.springcloud.Demo;
import com.lank.springcloud.MyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author lank
 * @since 2020/12/6 16:40
 * 降级逻辑方法
 */
@Slf4j
@Component
public class MyFallBack implements MyService {

    @HystrixCommand(fallbackMethod = "error2")
    public String error() {
        log.info("hystrix 进行降级流程！");
        //return "已经调用降级流程";
        throw new RuntimeException("第一次降级！");
    }

    @HystrixCommand(fallbackMethod = "error3")
    public String error2(){
        log.info("hystrix 进行降级流程！222");
        throw new RuntimeException("第二次降级！");
    }

    public String error3(){
        return "成功!";
    }

    public String sayHi() {
        return null;
    }

    public Demo sayHi(Demo demo) {
        return null;
    }

    public String retry(Integer timeout) {
        return "你已经超时了！！！";
    }


}

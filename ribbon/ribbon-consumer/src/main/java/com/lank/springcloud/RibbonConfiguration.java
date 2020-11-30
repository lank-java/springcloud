package com.lank.springcloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lank
 * @since 2020/11/29 14:23
 * 负载均衡配置类
 */

@Configuration
@RibbonClient(value = "eureka-client",configuration = RandomRule.class)
public class RibbonConfiguration {

    /**
     * 声明全局负载均衡策略
     */
//    @Bean
//    public IRule defaultLbRule(){
//        return new RandomRule();
//    }
}

package com.lank.springcloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lank
 * @since 2020/11/29 16:45
 */
@FeignClient(name = "eureka-client")
public interface IService {

    @GetMapping("/sayHi")
    String sayHi();
}

package com.lank.springcloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lank
 * @since 2020/11/30 21:55
 */
@FeignClient("feign-client")
public interface IService {

    @GetMapping("/sayHi")
     String sayHi();

    @PostMapping("/sayHi")
     Demo sayHi(@RequestBody Demo demo);

    @GetMapping("/retry")
    String retry(@RequestParam("timeout") Integer timeout);

}

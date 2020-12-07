package com.lank.springcloud;

import com.lank.springcloud.hystrix.MyFallBack;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author lank
 * @since 2020/12/6 16:44
 */
@FeignClient(name = "feign-client",fallback = MyFallBack.class)
public interface MyService extends IService{
}

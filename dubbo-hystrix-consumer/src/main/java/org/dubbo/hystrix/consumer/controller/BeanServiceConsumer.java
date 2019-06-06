package org.dubbo.hystrix.consumer.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.hystrix.api.BeanService;
public class BeanServiceConsumer {
	  @Reference(timeout = 30000,version = "1.0.1",check = false)
      BeanService  beanService;
	  public  String exec(String name) {
		  return beanService.exec(name);
	  }
}

package org.dubbo.hystrix.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.netflix.hystrix.HystrixCommandGroupKey;
@RestController
public class DubboHstyixController {
	  @Autowired
      BeanServiceConsumer   beanServiceConsumer;
      @RequestMapping("/test")
      @SentinelResource(value = "exec",fallback ="failSentinel",blockHandlerClass = BizException.class,blockHandler = "bizExceptionHandler")
	/* @HystrixCommand(fallbackMethod ="failBackMethod" ) */
      public String exec(String name) {
		/* CommandExec exec=new CommandExec(name); */
    	  return beanServiceConsumer.exec(name);
      }
      public  String failBackMethod(String name) {
    	  return "request send ~~~"+name;
      }
      public   String   failSentinel(String name) {
    	  return "request sentinel "+name;
      }
	class CommandExec extends com.netflix.hystrix.HystrixCommand<String> {
		private final String name;

		protected CommandExec(String name) {
			super(HystrixCommandGroupKey.Factory.asKey(name), 50);
			this.name = name;
		}

		@Override
		protected String run() {
			throw new RuntimeException("this is hystrix  command");
		}

		@Override
		protected String getFallback() {
			return "hello  fail " + this.name;
		}

	}
}

package org.dubbo.hystrix.consumer;


import org.dubbo.hystrix.consumer.controller.BeanServiceConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo
/*
 * @EnableCircuitBreaker
 * 
 * @EnableHystrixDashboard
 */
public class DubboHystrixConsumerApplication {
	@Bean
	public BeanServiceConsumer annotationDemoServiceConsumer() {
		return new BeanServiceConsumer();
	}

	public static void main(String[] args) {
		SpringApplication.run(DubboHystrixConsumerApplication.class, args);
	}
}

package org.dubbo.hystrix.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class BizException extends  Exception {
	private static  final Logger log=LoggerFactory.getLogger(BizException.class);
	private static final long serialVersionUID = -8975807648755695658L;
	private String code;
	private String msg;
	public static String bizExceptionHandler(String code,BlockException exception) {
		log.error("服务降级了{},{}",exception.getMessage(),exception.getRuleLimitApp());
		return "sentinel服务降级了"+exception.getMessage();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
   
}

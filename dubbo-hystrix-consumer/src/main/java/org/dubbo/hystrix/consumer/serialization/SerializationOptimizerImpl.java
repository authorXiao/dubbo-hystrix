package org.dubbo.hystrix.consumer.serialization;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.dubbo.hystrix.consumer.response.Response;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;

public class SerializationOptimizerImpl implements SerializationOptimizer{

	@SuppressWarnings("rawtypes")
	public Collection<Class> getSerializableClasses() {
		List<Class> classes=new LinkedList<Class>();
		classes.add(Response.class);
		return classes;
	}

}

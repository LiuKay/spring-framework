package com.xwzj.spring.po;

import org.springframework.beans.factory.BeanFactory;

public class TestObject {

	private String name;

	private BeanFactory beanFactory;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
}

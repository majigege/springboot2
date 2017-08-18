package com.ucai.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 通过配置文件将属性值注入到类的属性里
 * 默认会加载application.propertiess
 * 这个配置难道只能配置一个吗？ 在Application中需要定义
 * @author my
 *
 */
@ConfigurationProperties(prefix="com.dudu")
public class Person2 {



	private String name;
	
	private String sb;
	
	private String test;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSb() {
		return sb;
	}

	public void setSb(String sb) {
		this.sb = sb;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	
	
	
	

}

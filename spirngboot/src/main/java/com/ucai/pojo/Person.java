package com.ucai.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * 
 * 使用自定义的配置文件 ,详见test.properties
 * @author my
 *
 */

@Configuration
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix="com.test")

public class Person {

	private String name;
	
	private String sb;

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
	
	
	
}

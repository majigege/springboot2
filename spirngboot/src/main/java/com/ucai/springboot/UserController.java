package com.ucai.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucai.pojo.Person;
import com.ucai.pojo.Person2;


/**
 * 如果配置 @RestController 表示返回的是JSON格式的数据
 *等价于 @Controller+@ResponseBody的结合，使用这个注解的类里面的方法都以json格式输出。
 * @author my
 *
 */
@RestController
//@EnableAutoConfiguration
public class UserController  
{
	/**
	 * 通过配置文件来获取值
	 */
//	@Value("${com.dudu.name}")
//	private String name;
//	
//	@Value("${com.dudu.sb}")
//	private String str;
	
	@Autowired
	private Person person;
	
	@Autowired
	private Person2 person2;
	

	@RequestMapping("/usercon")
	public String home()
	{
//		return  name + "  " + str;
		return person.getName()  + "  " +  person.getSb();
//		return person2.getName()  + "  " +  person2.getSb();
	}
}

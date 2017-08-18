package com.ucai.springboot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucai.pojo.UserTest;


@Controller
//@EnableAutoConfiguration
public class FirstController  
{
	private Logger log = LoggerFactory.getLogger(FirstController.class);

	@RequestMapping("/first")
	public String home()
	{
		return "first";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest req)
	{
		log.info("登录---------");
		UserTest ut = new UserTest();
		ut.setAge(1);
		System.out.println("HttpServletRequest =" + req);
		HttpSession session =  req.getSession();
		session.setAttribute("user", ut);
		
		System.out.println("---------------");
		return "pages/index";
	}
	
	@RequestMapping("/mainPage")
	public String test()
	{
		System.out.println("---------------");
		return "pages/test1";
	}
}

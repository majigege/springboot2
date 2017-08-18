package com.ucai.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ucai.mapper.EmpMapper;
import com.ucai.pojo.Emp;
import com.ucai.pojo.UserTest;
import com.ucai.service.EmpService;

/**
 * 使用Thymeleaf模板的列子
 * @author my
 *
 */
@Controller
//@EnableAutoConfiguration
public class HelloController  
{
	
	@Autowired
	private EmpService empService;
	

//	@RequestMapping("/hello")
//	public String home()
//	{
//		return "hi";
//	}
	
	/**
	 * 使用thymeleaf模板引擎
	 */
	@RequestMapping("/thymeleafDemo")
	public String thymeleafDemo(Model model,Map<String, Object> map)
	{
		System.out.println(model  +"----- ");
		List<UserTest> lists = new ArrayList<UserTest>();
		lists.add(new UserTest("lee1",20,"男"));
		lists.add(new UserTest("lee2",21,"女"));
		lists.add(new UserTest("lee3",22,"男"));
		UserTest  us = new UserTest("lee1",20,"男");
//		model.addAttribute("ut", lists);
		map.put("hello", "hell lee");
		
		List<Emp> emps = empService.getAllEmp();
		model.addAttribute("es", emps);
		System.out.println("emps : " + emps);
		
		return "/hello";
	}
	
	@RequestMapping("/insertEmp")
	public String inertEmp(Model model)
	{
		Emp emp = new Emp();
//		emp.setEmpno(456789);
		emp.setEname("lee04");
		emp.setJob("java dev");
		emp.setSal(2000.15);
		empService.insertEmp(emp);
		
		List<Emp> emps = empService.getAllEmp();
		model.addAttribute("es", emps);
		System.out.println("emps : " + emps);
		return "/hello";
	}
	
	


}

package com.ucai.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.ucai.pojo.Emp;

/**
 * 采用注解的方式进行操作
 * @author Administrator
 *
 */
@Component
@Mapper
public interface EmpMapper 
{

	@Select("select empno,job,sal,ename from emp")
	 List<Emp>  findAllEmp();

	@Insert("insert into emp (job,sal,ename) values (#{emp.job},#{emp.sal},#{emp.ename})")
	void insertEmp(@Param("emp")Emp emp);
}

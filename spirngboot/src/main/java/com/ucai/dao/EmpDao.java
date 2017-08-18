package com.ucai.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucai.mapper.EmpMapper;
import com.ucai.pojo.Emp;


/**
 * 采用配置文件的方式
 * @author Administrator
 *
 */
@Repository("empDao")
public class EmpDao 
{

	@Autowired
	private EmpMapper empMapper;
	
	
	/**
	 * 查询所有EMP信息
	 * @return
	 * @throws IOException
	 */
	public List<Emp> getAllEmp()
	{
		System.out.println("empMapper = " + empMapper );
		List<Emp> emps = empMapper.findAllEmp();
		return emps;
	}
	
	public void insertEmp(Emp emp) {
		// TODO Auto-generated method stub
		empMapper.insertEmp(emp);
	}
	
//	
//	/**
//	 * 根据EMPNO查询EMP
//	 * @return
//	 * @throws IOException
//	 */
//	public Emp getEmpByEmpno(Object empno) throws IOException
//	{
//		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
//		
//		Emp emp = (Emp) session.selectOne("emp.findEmpByEmpno",empno);
//		return emp;
//	}
//	
//	/**
//	 * 插入数据  返回收影响的条数
//	 * @param emp
//	 * @throws IOException
//	 */
//	public void insertEmp(Emp emp) throws IOException
//	{
//		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
//		int index  = session.insert("emp.insert", emp);
//		
//	}
//	
//	
//	/**
//	 * 删除数据  返回收影响的条数
//	 * @param emp
//	 * @throws IOException
//	 */
//	public void delete(Object empno) throws IOException
//	{
//		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
//		int index  = session.delete("emp.deleteByEmpno",empno);
//		
//	}
}

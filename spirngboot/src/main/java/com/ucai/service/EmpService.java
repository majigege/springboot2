package com.ucai.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ucai.dao.EmpDao;
import com.ucai.pojo.Emp;

@Service("empService")
@Transactional
public class EmpService  implements IEmpService
{

	@Autowired
	private EmpDao empDao;
	
	/**
	 * 查询所有EMP信息
	 * @return
	 * @throws IOException
	 */
	public List<Emp> getAllEmp()
	{

		List<Emp> emps = empDao.getAllEmp();
		
		return emps;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public void insertEmp(Emp emp) {
		empDao.insertEmp(emp);
		
	}
}

package com.ucai.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ucai.pojo.Emp;

/**
 * 接口
 * @author my
 *
 */
public interface IEmpService {

	/**
	 * 插入
	 * @param emp
	 */
	
	void insertEmp(Emp emp);
	
	List<Emp> getAllEmp();

}

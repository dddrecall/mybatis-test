package com.recall.mybatis.dao;

import java.util.List;

import com.recall.mybatis.entites.Emp;

public interface EmpMapper {

	public List<Emp> getEmpsByDeptId(Integer deptId);

	public Emp getEmpById(Integer id);
	
}

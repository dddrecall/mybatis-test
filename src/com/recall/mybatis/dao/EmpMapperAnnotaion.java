package com.recall.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.recall.mybatis.entites.Emp;

public interface EmpMapperAnnotaion {

	@Select("SELECT * FROM tbl_emp WHERE deptId = #{id}")
	@Results({
			@Result(id = true, property = "id", column = "id"),
			@Result(property = "name", column = "name"),
			@Result(property = "dept", column = "deptId", one = @One(select = "com.recall.mybatis.dao.DeptMapper.getDeptById")) })
	public List<Emp> getEmpsByDeptId(Integer deptId);

	
	@Select("SELECT * FROM tbl_emp WHERE id = #{id}")
	@Results({
		@Result(id = true, property = "id", column = "id"),
		@Result(property = "name", column = "name"),
		@Result(property = "dept", column = "deptId", one = @One(select = "com.recall.mybatis.dao.DeptMapper.getDeptById")) })
	public Emp getEmpById(Integer id);

}

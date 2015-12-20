package com.recall.mybatis.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.recall.mybatis.entites.Dept;

public interface DeptMapperAnnotaion {

	@Select("SELECT * FROM tbl_dept WHERE id = #{id}")
	@Results({
			@Result(id = true, property = "id", column = "id"),
			@Result(property = "name", column = "true"),
			@Result(property = "emps", column = "id", 
				many = @Many(select = "com.recall.mybatis.dao.EmpMapperAnnotaion.getEmpsByDeptId")) })
	public Dept getDeptById(Integer id);

}

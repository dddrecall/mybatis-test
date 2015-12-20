package com.recall.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.recall.mybatis.entites.Student;

public interface StudentMapper {

	/**
	 * 如果单个参数 需要同@Param修饰
	 * 或者用_parameter 取值
	 * 
	 * @param age
	 * @return
	 */
	public List<Student> getByAge(@Param("age") Integer age);
	
	
	public List<Student> getStudent_Where(Map<String,Object> map);
	
	public List<Student> getStudent_choosewhenotherwise(Map<String,Object> map);
	
	public List<Student> getStudent_Foreach(Map<String,Object> map);
	
	public List<Student> getStudentByTrim(Map<String,Object> map);
	
	
	public void insertByTrim(Student student);
	
	public void updateBySet(Student student);
	
	
}

package com.recall.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.recall.mybatis.entites.Person;

public interface PersonMapperAnnotation {

	@Insert("INSERT INTO tbl_person(name,age,birth,registerTime,salary) "
			+ "values(#{name},#{age},#{birth},#{registerTime},#{salary})")
	public void add(Person person);

	@Delete("DELETE FROM tbl_person where id = #{id}")
	public void delete(Integer id);

	@Update("UPDATE tbl_person set name=#{name},age=#{age},birth=#{birth},"
			+ "registerTime=#{registerTime},salary=#{salary}"
			+ "where id = #{id}")
	public void update(Person person);

	@Select("SELECT * FROM tbl_person where id=#{id}")
	public Person getById(Integer id);

	@Select("SELECT * FROM tbl_person")
	public List<Person> getAllPersons();

}

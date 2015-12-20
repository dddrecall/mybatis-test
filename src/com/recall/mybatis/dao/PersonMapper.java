package com.recall.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.recall.mybatis.entites.Person;

public interface PersonMapper {

	public void add(Person person);

	public void delete(Integer id);

	public void update(Person person);

	public Person getById(Integer id);

	public List<Person> getAllPersons();

	public List<Map<String, Object>> getAllPersonsMap();
}

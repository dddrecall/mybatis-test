package com.recall.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.recall.mybatis.dao.PersonMapper;
import com.recall.mybatis.entites.Person;

public class TestMain {
	
	private SqlSessionFactory sessionFactory = null;
	private SqlSession sqlSession = null;
	private PersonMapper personMapper = null;
	
	@Before
	public void init() throws IOException{
		InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(stream);
		//stream.close();
		sqlSession = sessionFactory.openSession();
		personMapper = sqlSession.getMapper(PersonMapper.class);
	}
	
	@After
	public void destory(){
		
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}
		
	}
	
	
	@Test
	public void testAdd() throws IOException{
		
		Person p1 = new Person();
		p1.setName("recall111");
		p1.setAge(18);
		p1.setBirth(new Date());
		p1.setRegisterTime(new Date());
		p1.setSalary(2500d);
		
		personMapper.add(p1);
		System.out.println(p1.getId());
		
		
	}
	
	@Test
	public void testDelete(){
		personMapper.delete(2);
	}
	
	@Test
	public void testUpdate(){
		Person p1 = new Person();
		
		p1.setId(1);
		p1.setName("R1");
		p1.setBirth(new Date());
		p1.setAge(20);
		p1.setSalary(100000d);
		p1.setRegisterTime(new Date());
		
		personMapper.update(p1);
	}
	
	@Test
	public void testGetById(){
		Person person = personMapper.getById(1);
		System.out.println(person);
	}
	
	@Test
	public void testGetAll(){
		List<Person> list = personMapper.getAllPersons();
		for (Person person : list) {
			System.out.println(person);
		}
		
	}
	
	
	@Test
	public void testGetAllMap(){
		List<Map<String,Object>> list = personMapper.getAllPersonsMap();
		for (Map<String, Object> map : list) {
			Set<Entry<String,Object>> entrySet = map.entrySet();
			for (Entry<String, Object> entry : entrySet) {
				System.out.println(entry.getKey() + "\t" + entry.getValue());
			}
			System.out.println("------------------------");
		}
	}
	
}

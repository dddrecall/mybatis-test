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

public class TestOneLevelCache {

	private SqlSessionFactory sessionFactory = null;
	private SqlSession sqlSession = null;
	private PersonMapper personMapper = null;

	@Before
	public void init() throws IOException {
		InputStream stream = Resources
				.getResourceAsStream("mybatis-config.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(stream);
		// stream.close();
		sqlSession = sessionFactory.openSession();
		personMapper = sqlSession.getMapper(PersonMapper.class);
	}

	@After
	public void destory() {

		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}

	}

	/**
	 * 一级缓存失效
	 * 
	 * @throws IOException
	 */
	@Test
	public void OneLevelCache() throws IOException {

		/**
		 * 查询条件不一致
		 * 
		 * 
		 * Person person = personMapper.getById(1); System.out.println(person);
		 * 
		 * Person person2 = personMapper.getById(2);
		 * System.out.println(person2);
		 */
		
		/**
		 * 不同Session
		 * 	Person person = personMapper.getById(1);
			System.out.println(person);
			//sqlSession.commit();
			sqlSession.close();
	
			sqlSession = sessionFactory.openSession();
			personMapper = sqlSession.getMapper(PersonMapper.class);
			Person person2 = personMapper.getById(1);
			System.out.println(person2);
		 */
		
		
		/**
		 * 调用了clearCache方法
		 * 	Person person = personMapper.getById(1);
			System.out.println(person);
			sqlSession.clearCache();
			Person person2 = personMapper.getById(1);
			System.out.println(person2);
	
		 */
		
		/**
		 * 调用了session的commit方法
		 * 
		 */
		Person person = personMapper.getById(1);
		System.out.println(person);
		sqlSession.commit();
		Person person2 = personMapper.getById(1);
		System.out.println(person2);
	
	
	}
}

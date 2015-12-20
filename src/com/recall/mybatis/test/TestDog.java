package com.recall.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.recall.mybatis.dao.CatMapper;
import com.recall.mybatis.dao.DogMapper;
import com.recall.mybatis.entites.Cat;
import com.recall.mybatis.entites.Dog;

public class TestDog {

	@Test
	public void testAS() {
		
		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;
		
		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			DogMapper mapper = sqlSession.getMapper(DogMapper.class);
			Dog dog = mapper.getByIdAs(1);
			System.out.println(dog);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.commit();
				sqlSession.close();
			}
		}

	}
	
	
	@Test
	public void testResultMap() {
		
		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;
		
		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			DogMapper mapper = sqlSession.getMapper(DogMapper.class);
			Dog dog = mapper.getByIdResultMap(1);
			System.out.println(dog);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.commit();
				sqlSession.close();
			}
		}

	}
}

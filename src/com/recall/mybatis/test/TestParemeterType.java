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
import com.recall.mybatis.entites.Cat;

public class TestParemeterType {

	@Test
	public void test() {
		
		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;
		
		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
			
			Cat cat = new Cat();
			cat.setId(1);
			cat.setName("c1");
			
			List<Cat> list = catMapper.getByNameAndId(cat);
			for (Cat ele : list) {
				System.out.println(ele);
			}
			
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
	public void testMap() {
		
		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;
		
		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
			
			Map<String,Object> map = new HashMap<>();
			
			map.put("id", 1);
			map.put("name", "c1");
			
			List<Cat> list = catMapper.getByNameAndIdMap(map);
			for (Cat ele : list) {
				System.out.println(ele);
			}
			
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
	public void testLikeMap() {
		
		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;
		
		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
			
			Map<String,Object> map = new HashMap<>();
			
			map.put("id", 1);
			
			/**
			 * %开始会使索引失效 
			 * 
			 */
			map.put("name", "%c%");
			
			List<Cat> list = catMapper.getByName(map);
			for (Cat ele : list) {
				System.out.println(ele);
			}
			
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

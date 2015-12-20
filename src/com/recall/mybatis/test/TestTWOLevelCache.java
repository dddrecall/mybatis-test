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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.recall.mybatis.dao.CatMapper;
import com.recall.mybatis.entites.Cat;

public class TestTWOLevelCache {

	private SqlSessionFactory sessionFactory = null;
	private SqlSession sqlSession = null;
	

	@Before
	public void init() throws IOException {
		InputStream stream = Resources
				.getResourceAsStream("mybatis-config.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(stream);
		// stream.close();
		sqlSession = sessionFactory.openSession();
	
	}

	@After
	public void destory() {

		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}

	}

	/**
	 * 二级缓存
	 * 作用域就是namespace
	 * @throws IOException
	 */
	@Test
	public void OneLevelCache() throws IOException {
		CatMapper catMapper = sqlSession.getMapper(CatMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("name", "c1");
		List<Cat> lists = catMapper.getByName(map);
	
		for (Cat cat : lists) {
			System.out.println(cat);
		}
		sqlSession.close();
		sqlSession = sessionFactory.openSession();
		catMapper = sqlSession.getMapper(CatMapper.class);
		lists = catMapper.getByName(map);
		
		for (Cat cat : lists) {
			System.out.println(cat);
		}
	}
}

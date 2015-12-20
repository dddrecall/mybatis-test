package com.recall.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.recall.mybatis.dao.LockMapper;
import com.recall.mybatis.entites.Lock;

public class TestOne2On2 {

	private SqlSessionFactory sessionFactory = null;
	private SqlSession sqlSession = null;

	@Before
	public void init() throws IOException {
		InputStream stream = Resources
				.getResourceAsStream("mybatis-config.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(stream);

		sqlSession = sessionFactory.openSession();

	}

	@After
	public void destory() {

		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
		}

	}

	@Test
	public void One2One() throws IOException {
		LockMapper lockMapper = sqlSession.getMapper(LockMapper.class);
		Lock lock = lockMapper.geLockById(1);
		System.out.println(lock.getLockName());

	}
}

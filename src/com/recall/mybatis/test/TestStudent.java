package com.recall.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.recall.mybatis.dao.StudentMapper;
import com.recall.mybatis.entites.Student;

public class TestStudent {

	@Test
	public void testIf() {

		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;

		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			List<Student> list = studentMapper.getByAge(-22);
			for (Student student : list) {
				System.out.println(student);
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
	public void testWHERE() {

		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;

		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			Map<String, Object> map = new HashMap<>();

			map.put("id", 1);
			map.put("name", "li4");
			map.put("age", 22);

			List<Student> list = studentMapper.getStudent_Where(map);

			for (Student student : list) {
				System.out.println(student);
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
	public void testchoosewhenotherwise() {

		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;

		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			Map<String, Object> map = new HashMap<>();

			// map.put("id", 1);
			// map.put("name", "li4");
			// map.put("age", 22);

			List<Student> list = studentMapper
					.getStudent_choosewhenotherwise(map);

			for (Student student : list) {
				System.out.println(student);
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
	public void testForeach() {

		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;

		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			Map<String, Object> map = new HashMap<>();

			// map.put("ages", Arrays.asList(22,23,24));

			// map.put("names", Arrays.asList("li4","li5","li6"));

			List<Student> list = studentMapper.getStudent_Foreach(map);

			for (Student student : list) {
				System.out.println(student);
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
	public void testTrim01() {

		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;

		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			Map<String, Object> map = new HashMap<>();

			map.put("id", 1);
			map.put("name", "li4");
			map.put("age", 22);

			List<Student> list = studentMapper.getStudentByTrim(map);

			for (Student student : list) {
				System.out.println(student);
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
	public void testTrim02() {

		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;

		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			
			Student student = new Student();
			student.setName("recall");
			student.setAge(18);
			student.setBirth(new Date());
			student.setScore(100);
			
			studentMapper.insertByTrim(student);

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
	public void testSet() {

		SqlSessionFactory sessionFactory = null;
		SqlSession sqlSession = null;

		try {

			InputStream stream = Resources
					.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
			stream.close();
			sqlSession = sessionFactory.openSession();

			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);
			
			Student student = new Student();
			student.setName("recall");
			student.setAge(18);
			student.setBirth(new Date());
			student.setScore(100);
			student.setId(1);
			studentMapper.updateBySet(student);
			

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

package com.recall.mybatis.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.recall.mybatis.entites.Lock;

public interface LockMapperAnnoation {
	
	@Select("SELECT * FROM tbl_lock WHERE id = #{id}")
	@Results({
		@Result(id = true,property = "id",column = "id"),
		@Result(property = "lockName",column = "lockName"),
		@Result(property = "key",column="key_id",one=@One(select="com.recall.mybatis.dao.KeyMapper.getKeyById"))
	})
	public Lock geLockById(Integer id);
	
}

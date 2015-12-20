package com.recall.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.recall.mybatis.entites.Key;

public interface KeyMapperAnnoation {
	
	
	@Select("SELECT * FROM tbl_key where id = #{id}")
	public Key getKeyById(Integer id);
	
}

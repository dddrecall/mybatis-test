package com.recall.mybatis.dao;

import com.recall.mybatis.entites.Dog;

public interface DogMapper {

	public Dog getByIdAs(Integer id);
	
	public Dog getByIdResultMap(Integer id);
}

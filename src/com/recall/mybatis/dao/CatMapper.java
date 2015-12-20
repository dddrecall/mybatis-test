package com.recall.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.recall.mybatis.entites.Cat;

public interface CatMapper {

		public List<Cat> getByNameAndId(Cat cat);

		public List<Cat> getByNameAndIdMap(Map<String,Object> map);
		
		public List<Cat> getByName(Map<String,Object> map);
		
}

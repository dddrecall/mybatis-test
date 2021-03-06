package com.recall.mybatis.entites;

public class Key {
	private Integer id;
	private String keyName;

	public Key() {
		super();
	}

	public Key(Integer id, String keyName) {
		super();
		this.id = id;
		this.keyName = keyName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	@Override
	public String toString() {
		return "Key [id=" + id + ", keyName=" + keyName + "]";
	}

}

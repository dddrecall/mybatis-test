package com.recall.mybatis.entites;

public class Lock {
	private Integer id;
	private String lockName;
	private Key key;

	public Lock() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLockName() {
		return lockName;
	}

	public void setLockName(String lockName) {
		this.lockName = lockName;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Lock [id=" + id + ", lockName=" + lockName + ", key=" + key
				+ "]";
	}

}

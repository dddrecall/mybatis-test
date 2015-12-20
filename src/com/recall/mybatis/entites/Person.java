package com.recall.mybatis.entites;

import java.util.Date;

public class Person {
	private Integer id;
	private String name;
	private int age;
	private Date birth;
	private Date registerTime;
	private Double salary;

	public Person() {
	}

	public Person(Integer id, String name, int age, Date birth,
			Date registerTime, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.registerTime = registerTime;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", birth=" + birth + ", registerTime=" + registerTime
				+ ", salary=" + salary + "]";
	}

}

package com.zya.cloud.two.entity;

import java.io.Serializable;

public class TestEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9169865500004667631L;
	private String name;
	private String age;
	// transient注解，在对象序列化的时候忽略此注解标注的字段
	private transient String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

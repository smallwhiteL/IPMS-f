package com.ipms.pojo;

import java.util.Date;

public class User {
	private String user_id;
	private String username;
	private String password;
	private String name;
	private String sex;
	private Date birthday;
	private String Individuality_signature;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIndividuality_signature() {
		return Individuality_signature;
	}
	public void setIndividuality_signature(String individuality_signature) {
		Individuality_signature = individuality_signature;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User() {
		super();
	}
	
	public User(String user_id, String username, String password, String name, String sex, Date birthday) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", sex=" + sex + ", birthday=" + birthday + ", Individuality_signature=" + Individuality_signature
				+ "]";
	}

	
	
}
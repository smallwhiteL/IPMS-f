package com.ipms.pojo;

import java.util.Date;
/**
 * 用户模型
 * @author ASUS
 *
 */
public class User {
	private String user_id;
	private String username;
	private String password;
	private String name;
	private String sex;
	private Date birthday;
	private String individuality_signature;
	private String portrait;
	private String formatBirthday;
	
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
		return individuality_signature;
	}
	public void setIndividuality_signature(String individuality_signature) {
		this.individuality_signature = individuality_signature;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getFormatBirthday() {
		return formatBirthday;
	}
	public void setFormatBirthday(String formatBirthday) {
		this.formatBirthday = formatBirthday;
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
				+ ", sex=" + sex + ", birthday=" + birthday + ", individuality_signature=" + individuality_signature
				+ ", portrait=" + portrait + ", formatBirthday=" + formatBirthday + "]";
	}

	
	
}
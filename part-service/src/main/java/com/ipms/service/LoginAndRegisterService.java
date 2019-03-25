package com.ipms.service;

import java.sql.SQLException;

import com.ipms.pojo.User;

public interface LoginAndRegisterService {
	
	User loginService(User user) throws SQLException;
	
	void registerService(User user);
	
	User checkRepeatService(String username);

}

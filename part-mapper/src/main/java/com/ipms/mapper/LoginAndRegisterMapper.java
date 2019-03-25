package com.ipms.mapper;

import com.ipms.pojo.User;

public interface LoginAndRegisterMapper {
	
	User userLogin(User user);
	
	void userRegister(User user);
	
	User checkRepeat(String username);

}

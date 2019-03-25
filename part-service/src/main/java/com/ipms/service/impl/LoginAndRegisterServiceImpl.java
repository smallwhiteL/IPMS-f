package com.ipms.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipms.mapper.LoginAndRegisterMapper;
import com.ipms.pojo.User;
import com.ipms.service.LoginAndRegisterService;

@Service
public class LoginAndRegisterServiceImpl implements LoginAndRegisterService {
	
	@Autowired
	private LoginAndRegisterMapper loginAndRegisterMapper;

	@Override
	public User loginService(User user) throws SQLException {
		User userTemp = loginAndRegisterMapper.userLogin(user);
		if (null == userTemp) {
			throw new RuntimeException("账号或密码不正确!");
		}
		else {
			return userTemp;
		}
	}

	@Override
	public void registerService(User user) {
		loginAndRegisterMapper.userRegister(user);
	}

	@Override
	public User checkRepeatService(String username) {
		User checkUsername = loginAndRegisterMapper.checkRepeat(username);
		return checkUsername;
	}

}

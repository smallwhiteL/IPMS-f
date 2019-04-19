package com.ipms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipms.pojo.User;
import com.ipms.service.LoginAndRegisterService;

@Controller
@RequestMapping("/loginAndRegister")
public class LoginAndRegisterController {
	
	@Autowired
	private LoginAndRegisterService loginAndRegisterService;
	
	// 注册和登录页面显示
	@RequestMapping("/form")
	public String mainForm(HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath("/");
		System.out.println(realPath);
		return "index";
	}

	// 登录处理
	@RequestMapping("/login")
	public String login (HttpServletRequest request) {
		// 从Jsp获得的账号密码暂存于此User对象中
		User userFromJsp = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		userFromJsp.setUsername(username);
		userFromJsp.setPassword(password);
		
		// 经过数据库查询后将完全数据放于此User对象中
		User userWithAllDatas = null;
		try {
			// 账号密码为空的情况
			if (username == "" || password == "" || username == null || password == null) {
				throw new RuntimeException("账号和密码不能为空");
			}
			else {
				// 登录成功
				userWithAllDatas = loginAndRegisterService.loginService(userFromJsp);
				// 将登录用户放入Session中,以确认之后的页面都存在登录的用户的信息
				request.getSession().setAttribute("loginUser", userWithAllDatas);
				// 成功后重定向至登录后主页
				return "redirect:/home/homePage";
			}
			
		} catch (Exception e) {
			// 登录失败
			String exceptionMessage = e.getMessage();
			
			// 向request放入失败的信息
			request.getSession().setAttribute("fallMessage", exceptionMessage);
			// 回到主页
			return "redirect:/";
			
		}
	}

	// 注册处理
	@RequestMapping("/register")
	public void register (HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 获取注册项
		String register_user_id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		String register_username = request.getParameter("register_username");
		String register_password = request.getParameter("register_password");
		String register_name = request.getParameter("register_name");
		String register_sex = request.getParameter("register_sex");
		// 日期转换
		String register_birthday = request.getParameter("register_birthday");
		String birthday_format = "yyyy-MM-dd";
		
		if (register_birthday == "" || register_birthday == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/common/transitionPage.jsp").forward(request, response);
		}
		else {
			Date birthday = new SimpleDateFormat(birthday_format).parse(register_birthday);
			User new_register_user = new User(register_user_id, register_username, 
					register_password, register_name, register_sex, birthday);
			loginAndRegisterService.registerService(new_register_user);
		}
	}
	
	// 查询账号是否已存在
	@RequestMapping("/checkRepeat")
	public void checkRepeat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String check_username = request.getParameter("check_username");
		User checkUser = loginAndRegisterService.checkRepeatService(check_username);
		if (checkUser == null) {
			response.getWriter().print("ok");
		}
		else {
			response.getWriter().print("exist");
		}
	}
	
}

package com.ipms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
	
	// 登陆后的主页显示
	@RequestMapping("/homePage")
	public String showHomePage(Model model) {
		return "homePage";
	}
	
	// 注销
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// 清除设置的session
		request.getSession().invalidate();
		// 回到登录页面
		return "redirect:/";
	}

}

package com.ipms.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipms.pojo.Plan;
import com.ipms.pojo.User;
import com.ipms.service.HomeService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	// 登陆后的主页显示
	@RequestMapping("/homePage")
	public String showHomePage(Model model, HttpServletRequest request) {
		
		// 从session获取登录的用户
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		
		// 获得相应任务(toDo,done,doing,failed)
		List<Plan> toDo_plan = homeService.listToDo(user_id);
		List<Plan> doing_plan = homeService.listDoing(user_id);
		List<Plan> done_plan = homeService.listDone(user_id);
		List<Plan> failed_plan = homeService.listFailed(user_id);
		
		// 获得toDO, done, doing, failed的数量
		Integer toDo_count = homeService.findToDoService(user_id);
		Integer doing_count = homeService.findDoingService(user_id);
		Integer done_count = homeService.findDoneService(user_id);
		Integer failed_count = homeService.findFailedService(user_id);
		
		model.addAttribute("toDo_count", toDo_count);
		model.addAttribute("doing_count", doing_count);
		model.addAttribute("done_count", done_count);
		model.addAttribute("failed_count", failed_count);
		
		model.addAttribute("toDo_plan", toDo_plan);
		model.addAttribute("doing_plan", doing_plan);
		model.addAttribute("done_plan", done_plan);
		model.addAttribute("failed_plan", failed_plan);
		
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
	
	// 获得今年年份
	@RequestMapping("/getYear")
	public void getYear(HttpServletResponse response) throws IOException {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		response.getWriter().print(year);
	}
	
}

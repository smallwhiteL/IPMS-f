package com.ipms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ipms.pojo.FormatPlanToJson;
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
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		
		// 获得相应计划(toDo,done,doing,failed)
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
	
	// 添加计划
	@RequestMapping("/addPlan")
	public void addPlan(HttpServletRequest request) throws ParseException {
		
		// 从session获取登录的用户
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		
		// 获取要添加的计划的信息
		String plan_title = request.getParameter("plan-title");
		String plan_describe = request.getParameter("plan-describe");
		String plan_start = request.getParameter("plan-start-date");
		String plan_end = request.getParameter("plan-end-date");
		String plan_status = request.getParameter("plan-status");
		
		Integer plan_status_num = Integer.parseInt(plan_status);
		
		// 日期转换
		String date_format = "yyyy-MM-dd";
		Date plan_starting_date = new SimpleDateFormat(date_format).parse(plan_start);
		Date plan_ending_date = new SimpleDateFormat(date_format).parse(plan_end);
		
		Plan plan = new Plan(plan_title, plan_starting_date, plan_ending_date, plan_describe, plan_status_num, user_id);
		homeService.addPlan(plan);
	}
	
	// 删除计划
	@RequestMapping("/deletePlan")
	public void deletePlan(Integer plan_id) {
		homeService.deletePlan(plan_id);
	}
	
	// 通过Id获取要查看的计划详情
	@RequestMapping("/getPlanById")
	public @ResponseBody
	FormatPlanToJson getPlanById(Integer plan_id) {
		
		Plan plan = homeService.getPlanById(plan_id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String start_time = sdf.format(plan.getPlan_starting_time());
		String ending_time = sdf.format(plan.getPlan_ending_time());
		String status = "" + plan.getPlan_status();
		FormatPlanToJson formatPlan = new FormatPlanToJson(plan.getPlan_title(),
				start_time, ending_time, plan.getPlan_describe(), status);
		return formatPlan;
	}
	
	// 先获取Id在根据Id获取计划并更新
	@RequestMapping("/updatePlan")
	public void updatePlan(FormatPlanToJson formatPlan, HttpServletRequest request) throws ParseException {
		
		Integer plan_id = Integer.parseInt(formatPlan.getPlan_id());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date plan_starting_date = sdf.parse(formatPlan.getPlan_starting_time());
		Date plan_ending_date = sdf.parse(formatPlan.getPlan_ending_time());
		Integer plan_status = Integer.parseInt(formatPlan.getPlan_status());
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		
		Plan plan = new Plan(plan_id, formatPlan.getPlan_title(), plan_starting_date, plan_ending_date,
				formatPlan.getPlan_describe(), plan_status, user_id);
		
		homeService.updatePlan(plan);
	}
	
	// 去到查看某个状态的所有计划的页面
	@RequestMapping("/toOneStatusPlan") // 此处使用RedirectAttributes可以隐藏重定向到其他controller时所带的参数
	public String toOneStatusPlan(Integer status, HttpServletRequest request) {
		request.getSession().setAttribute("status", status);
		request.getSession().setAttribute("otherPages", "otherPages");
		return "redirect:../fromHome/withStatus";
	}
}

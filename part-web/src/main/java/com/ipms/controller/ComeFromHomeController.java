package com.ipms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipms.pojo.FormatPlanToJson;
import com.ipms.pojo.Plan;
import com.ipms.pojo.User;
import com.ipms.service.ComeFromHomeService;
import com.ipms.utils.Page;
import com.ipms.utils.QueryUtils;

@Controller
@RequestMapping("/fromHome")
public class ComeFromHomeController {
	
	@Autowired
	private ComeFromHomeService comeFromHomeService;
	
	@RequestMapping("/withStatus")
	public String withStatusPage(@ModelAttribute("status") String status, HttpServletRequest request, Model model) {
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		Integer plan_status = Integer.parseInt(status);
		// 将状态, 用户ID, 
		QueryUtils queryUtils = new QueryUtils(plan_status, user_id, 0);
		// 通过查询工具类查询分页信息
		Page<Plan> page = comeFromHomeService.findPage(queryUtils);
		// 未转为Json格式的Plan
		List<Plan> firstPagePlans = comeFromHomeService.findFirstPagePlans(queryUtils);
		// 转为Json格式的Plan
		List<FormatPlanToJson> formatPlanToJsons = new ArrayList<>();
		// 遍历查询到的Plan
		for (Plan plan : firstPagePlans) {
			// Date - String
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String plan_starting_time = sdf.format(plan.getPlan_starting_time());
			String plan_ending_time = sdf.format(plan.getPlan_ending_time());
			// 判断状态并改为中文
			String formatStatus = "";
			if (plan.getPlan_status() == 1) {
				formatStatus = "待开始";
			} else if (plan.getPlan_status() == 2) {
				formatStatus = "进行中";
			} else if (plan.getPlan_status() == 3) {
				formatStatus = "已结束";
			} else if (plan.getPlan_status() == 4) {
				formatStatus = "已逾期";
			}
			// 将每一项Plan格式化为Json以输出到前端
			FormatPlanToJson formatPlanToJson = new FormatPlanToJson(plan.getPlan_id()+"", plan.getPlan_title(),
					plan_starting_time, plan_ending_time, plan.getPlan_describe(), formatStatus);
			// 将格式化后的Plan添加到List中
			formatPlanToJsons.add(formatPlanToJson);
		}
		
		model.addAttribute("firstPageList", formatPlanToJsons);
		model.addAttribute("page", page);
		return "listOneStatusPlan";
	}
	
}

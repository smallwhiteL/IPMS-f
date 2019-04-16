package com.ipms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ipms.pojo.User;
import com.ipms.service.ComeFromHomeService;
import com.ipms.utils.Page;
import com.ipms.utils.QueryUtils;

@Controller
@RequestMapping("/fromHome")
public class ComeFromHomeController {
	
	@Autowired
	private ComeFromHomeService comeFromHomeService;
	
	/**
	 * 带状态的第一页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/withStatusFirst")
	public String withStatusPage(HttpServletRequest request, Model model) {
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		Integer plan_status = (Integer) request.getSession().getAttribute("status");
		// 将状态, 用户ID, 页号, 页起始行
		QueryUtils queryUtils = new QueryUtils(plan_status, user_id, 1, 0);
		// 通过查询工具类查询分页信息
		Page page = comeFromHomeService.findPage(queryUtils);
		model.addAttribute("page", page);
		return "listOneStatusPlan";
	}
	
	@RequestMapping("/withStatusOthers")
	public String withStatusOthers(HttpServletRequest request, Model model) {
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		Integer plan_status = (Integer) request.getSession().getAttribute("status");
		Integer pageNum = Integer.parseInt(request.getParameter("otherPageNum"));
		// 将状态, 用户ID, 页号, 页起始行
		QueryUtils queryUtils = new QueryUtils(plan_status, user_id, pageNum, (pageNum - 1) * 10);
		// 通过查询工具类查询分页信息
		Page page = comeFromHomeService.findPage(queryUtils);
		model.addAttribute("page", page);
		return "listOneStatusPlan";
	}
	
	
}

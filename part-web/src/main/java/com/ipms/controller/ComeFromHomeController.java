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
		return "listPlanWithStatus";
	}
	
	@RequestMapping("/withStatusOthers")
	public String withStatusOthers(HttpServletRequest request, Model model) {
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		Integer plan_status = (Integer) request.getSession().getAttribute("status");
		// 页号
		Integer pageNum = Integer.parseInt(request.getParameter("otherPageNum"));
		// 将状态, 用户ID, 页号, 页起始行
		QueryUtils queryUtils = new QueryUtils(plan_status, user_id, pageNum, (pageNum - 1) * 10);
		// 通过查询工具类查询分页信息
		Page page = comeFromHomeService.findPage(queryUtils);
		model.addAttribute("page", page);
		return "listPlanWithStatus";
	}
	
	@RequestMapping("/findLikeFirst")
	public String findLikeFirst(HttpServletRequest request, Model model) {
		
		// 设置非主业标志
		request.getSession().setAttribute("otherPages", "otherPages");
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		Object status = request.getSession().getAttribute("status");
		// 将查询字符串放入session
		String queryStr = request.getParameter("queryStr");
		request.getSession().setAttribute("queryStr", queryStr);
		
		QueryUtils queryUtils = new QueryUtils();
		// 判断状态是否存在
		if (status != null) {
			Integer plan_status = (Integer) status;
			queryUtils.setStatus(plan_status);
		}
		queryUtils.setPlan_userId(user_id);
		queryUtils.setPage_index(1);
		queryUtils.setStart_row(0);
		queryUtils.setQueryStr(queryStr);
		Page page = comeFromHomeService.findLikePage(queryUtils);
		model.addAttribute("page", page);
		return "listLikePlan";
	}
	
	@RequestMapping("/findLikeOthers")
	public String findLikeOthers(HttpServletRequest request, Model model) {
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		Object status = request.getSession().getAttribute("status");
		// 页号
		Integer pageNum = Integer.parseInt(request.getParameter("otherPageNum"));
		// 查询字符串从session中获取
		String queryStr = (String) request.getSession().getAttribute("queryStr");
		
		QueryUtils queryUtils = new QueryUtils();
		// 判断状态是否存在
		if (status != null) {
			Integer plan_status = (Integer) status;
			queryUtils.setStatus(plan_status);
		}
		queryUtils.setPlan_userId(user_id);
		queryUtils.setPage_index(pageNum);
		queryUtils.setStart_row((pageNum - 1) * 10);
		queryUtils.setQueryStr(queryStr);
		Page page = comeFromHomeService.findLikePage(queryUtils);
		model.addAttribute("page", page);
		
		return "listLikePlan";
	}
	
}

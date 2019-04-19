package com.ipms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// 获取要查询的字符串并放入session中
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
		model.addAttribute("queryStr", queryStr);
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
	
	@RequestMapping("/toMonthPage")
	public String toMonthPage(Model model, HttpServletRequest request) {
		
		request.getSession().setAttribute("otherPages", "otherPages");
		String yearAndMonth = request.getParameter("yearAndMonth");
		model.addAttribute("yearAndMonth", yearAndMonth);
		return "month";
	}
	
	@RequestMapping("/ifChangeColor")
	public void ifChangeColor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		
		// 分割获取的参数来得到年月日
		int year = Integer.parseInt(request.getParameter("date").split("-")[0]);
		int month = Integer.parseInt(request.getParameter("date").split("-")[1]);
		int day = Integer.parseInt(request.getParameter("date").split("-")[2]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdfStr = sdf.format(calendar.getTime());
		
		QueryUtils queryUtils = new QueryUtils(user_id, sdfStr);
		int count = comeFromHomeService.findByEndTimeAndUserId(queryUtils);
		if (count != 0) {
			response.getWriter().print("yes");
		} else {
			response.getWriter().print("no");
		}
	}
	
	@RequestMapping("/toEndTimeFirstPage")
	public String toEndTimeFirstPage(HttpServletRequest request, Model model) {
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		
		// 获取日期
		int year = Integer.parseInt(request.getParameter("date").split("-")[0]);
		int month = Integer.parseInt(request.getParameter("date").split("-")[1]);
		int day = Integer.parseInt(request.getParameter("date").split("-")[2]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdfStr = sdf.format(calendar.getTime());
		QueryUtils queryUtils = new QueryUtils(user_id, sdfStr);
		queryUtils.setPage_index(1);
		queryUtils.setStart_row(0);
		Page page = comeFromHomeService.findEndTimePage(queryUtils);
		model.addAttribute("date", sdfStr);
		model.addAttribute("page", page);
		return "listPanWithEndTime";
	}
	
	@RequestMapping("/toEndTimeOtherPage")
	public String toEndTimeOtherPage(HttpServletRequest request, Model model) {
		
		// 从session获取登录的用户的id
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		String user_id = loginUser.getUser_id();
		
		// 获取日期
		int year = Integer.parseInt(request.getParameter("date").split("-")[0]);
		int month = Integer.parseInt(request.getParameter("date").split("-")[1]);
		int day = Integer.parseInt(request.getParameter("date").split("-")[2]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdfStr = sdf.format(calendar.getTime());
		
		// 页号
		Integer pageNum = Integer.parseInt(request.getParameter("otherPageNum"));
		
		QueryUtils queryUtils = new QueryUtils(user_id, sdfStr);
		queryUtils.setPage_index(pageNum);
		queryUtils.setStart_row((pageNum - 1) * 10);
		Page page = comeFromHomeService.findEndTimePage(queryUtils);
		model.addAttribute("date", sdfStr);
		model.addAttribute("page", page);
		
		return "listPanWithEndTime";
	}
	
}

package com.ipms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ipms.pojo.User;

public class LoginInterceptor implements HandlerInterceptor {
	

	// Controller执行前调用此方法
	// 返回true表示继续执行，返回false中止执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 验证是否登录
		HttpSession session = request.getSession();
		User userForCheckIntercept = (User)session.getAttribute("loginUser");
		if (userForCheckIntercept == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/common/transitionPage.jsp").forward(request, response);
			return false;
		}
		return true;
	}

}

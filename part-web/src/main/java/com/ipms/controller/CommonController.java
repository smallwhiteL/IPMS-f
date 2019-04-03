package com.ipms.controller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	// 获取ip地址
		@RequestMapping("/getIpAddress")
		public void showHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
			InetAddress ipAddress = InetAddress.getLocalHost();
			String ip = ipAddress.getHostAddress();
			response.getWriter().print(ip);
		}
}

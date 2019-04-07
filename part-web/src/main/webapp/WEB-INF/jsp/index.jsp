<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<title>IPMS-f</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<!-- Own CSS -->
<link href="${pageContext.request.contextPath}/css/index-style.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<!-- Title Icon -->
<link href="${pageContext.request.contextPath}/images/plan.jpg" rel="shortcut icon">
<!-- JQuery (Before Bootstrap) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<!-- Load Bootstrap Javascript Plugin -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- Own Javascript register -->
<script src="${pageContext.request.contextPath}/js/registerJS.js"></script>

</head>
<body style="height: 100%; margin: auto; background: yellowgreen;">
	
	<%
		// 判断session
		if (session.getAttribute("loginUser") != null) {
			session.invalidate();
		}
	%>

	<!-- Header -->
	<%@ include file="/WEB-INF/jsp/common/pageHeader.jsp" %>

	<!-- Main Content Form -->
	<div class="container">
		<div class="row" style="height: 100%">
			<div class="col-md-2"></div>
			
			<div class="col-xs-12 col-md-8" style="height: 100%; background-color: white">
				<!-- Main Form -->
				<form action="${pageContext.request.contextPath}/loginAndRegister/login" method="POST" style="margin-top: 20%">
					
					<!-- Username -->
					<div class="form-group">
						<label for="username">
							<h1>账号</h1>
						</label>
						<input type="text" class="form-control" id="username" name="username"
						 style="height: 70px; font-size: 30px"
						 placeholder="请输入你的账号">
					</div>
					
					<!-- Password -->
					<div class="form-group">
						<label for="password">
							<h1>密码</h1>
						</label>
						<input type="password" class="form-control" id="password" name="password"
						 style="height: 70px; font-size: 30px"
						 placeholder="请输入你的密码">
					</div>
					
					<!-- Fall to login and print the wrong message -->
					<div><span class="fallMessage">${fallMessage}</span></div>
					
					<!-- Submit and Register -->
					<div class="row" style="margin-top: 8%;">
						<div class="col-xs-4 col-xs-offset-3">
							<button type="submit" class="btn btn-default" 
							style="font-size: 35px; font-weight: bold">登录</button>
						</div>
						<div class="col-xs-4 ">
							<a href="#" class="btn btn-default" role="button" data-toggle="modal" data-target="#myModal"
							style="font-size: 35px; font-weight: bold">注册</a>
							<!-- 通过bootstrap和jsp编译指令将注册页面引入 -->
							<%@ include file="/WEB-INF/jsp/register.jsp" %>
						</div>
					</div>
				</form>
			</div>
			
			<div class="col-md-2"></div>
		</div>
	</div>

</body>
</html>
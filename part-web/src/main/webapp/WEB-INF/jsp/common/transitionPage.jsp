<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>IPMS-f</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		time = 2;
		$(function(){
			setInterval("refresh()", 1000);
			setTimeout("window.location.href='${pageContext.request.contextPath}'", 3000);
		});
	
		function refresh() {
			$("span")[0].innerHTML = time;
			if (time > 1) {
				time = time - 1;
			}
		}
	</script>
</head>
<body>
	<div style="font-size: 35px; margin-left: 30%; margin-top: 20%">不能直接进入该页面, 谢谢!</div>
	<div style="font-size: 35px; margin-left: 30%;">
		还有<span style="font-size: 50px; color: red">3</span>秒跳转至登录页面<br>
	</div>
</body>
</html>
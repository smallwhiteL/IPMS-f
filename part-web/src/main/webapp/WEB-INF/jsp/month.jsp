<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IPMS-f</title>
<!-- Own CSS -->
<link href="${pageContext.request.contextPath}/css/month-style.css" rel="stylesheet">
<!-- Title Icon -->
<link href="${pageContext.request.contextPath}/images/plan.jpg" rel="shortcut icon">
<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<!-- JQuery (Before Bootstrap) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<!-- Load Bootstrap Javascript Plugin -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- Own Javascript -->
<script src="${pageContext.request.contextPath}/js/month.js"></script>
</head>
<body>

	<!-- Header -->
	<%@ include file="/WEB-INF/jsp/common/pageHeader.jsp" %>
	
	<input type="month" class="center-block form-control" id="month-choice" value="${yearAndMonth}">
	<table class="table table-bordered" id="days-table">
		<tr>
			<th>周一</th> <th>周二</th> <th>周三</th> <th>周四</th> <th>周五</th> <th>周六</th> <th>周日</th>
		</tr>
	</table>
	
	<!-- floating window to add plan -->
    <ul id="add-plan-ul">
        <li style="display:none;"><button id="back-to-top" style="border:none"></button></li>
        <li>
            <a id="add-plan-li" data-toggle="modal" data-target="#addPlanModal">
                <img src="${pageContext.request.contextPath}/images/add-plan.svg" style="height: 45px; width: 100%" />
            </a>
        </li>
    </ul>
    
    <form name="redictToEndTimePage" id="redictToEndTimePage" action="toEndTimeFirstPage.action" method="post">
  		<input type="hidden" name="date" id="toEndTimePage">
 	</form>
    
    <!-- 添加任务框 -->
	<%@ include file="/WEB-INF/jsp/addPlan.jsp" %>

</body>
</html>

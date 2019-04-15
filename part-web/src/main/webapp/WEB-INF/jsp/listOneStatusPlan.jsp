<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IPMS-f</title>
<!-- Own CSS -->
<link href="${pageContext.request.contextPath}/css/list-style.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<!-- JQuery (Before Bootstrap) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<!-- Load Bootstrap Javascript Plugin -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- Own Javascript -->
<script src="${pageContext.request.contextPath}/js/list-plan01.js"></script>
</head>
<body>
	<!-- Header -->
	<%@ include file="/WEB-INF/jsp/common/pageHeader.jsp" %>
	
	<div class="list-all">
         <!-- plan find -->
         <div id="go-to-concrete">
             <div class="form-group">
                 <input type="text" class="form-control" id="find-plan" placeholder="输入计划标题">
                 <button id="go">查找</button>
             </div>
         </div>
         <table class="table table-bordered table-striped">
             <tr>
                 <th style="text-align: center">计划ID</th> <th style="text-align: center">计划标题</th> 
                 <th style="text-align: center">开始时间</th> <th style="text-align: center">截止时间</th> 
                 <th style="text-align: center">计划描述</th> <th style="text-align: center">状态</th> 
                 <th style="text-align: center">操作</th>
             </tr>
             <c:forEach items="${firstPageList}" var="plan" end="9" varStatus="status">
             	<tr>
             		<td class="plan_id">${plan.plan_id}</td>
             		<td class="plan_title">${plan.plan_title}</td>
             		<td class="plan_starting_time">${plan.plan_starting_time}</td>
             		<td class="plan_ending_time">${plan.plan_ending_time}</td>
             		<td class="plan_describe">${plan.plan_describe}<span class="more"></span></td>
             		<td class="plan_status">${plan.plan_status}</td>
             		<td>
             			<button type="button" class="btn btn-primary" onclick="updatePlan(5)">修改</button>&nbsp;
                     	<button type="button" class="btn btn-danger" onclick="deletePlan(5)">删除</button>
                 	</td>
             	</tr>
             </c:forEach>
         </table>
         <nav>
             <ul class="pager">
                 <li><a href="javascript:;">首页</a></li>
                 <li><a href="javascript:;">&larr;上一页</a></li>
                 <input type="text" class="form-control" id="find-page" value="1">
                 <button id="go">Go</button>
                 <li><a href="javascript:;">下一页&rarr;</a></li>
                 <li><a href="javascript:;">尾页</a></li>
             </ul>
         </nav>
     </div>

     <!-- floating window to add plan -->
     <ul id="add-plan-ul">
         <li style="display:none;"><button id="back-to-top" style="border:none"></button></li>
         <li>
             <a id="add-plan-li" data-toggle="modal" data-target="#addPlanModal">
                 <img src="${pageContext.request.contextPath}/images/add-plan.svg" style="height: 45px; width: 100%" />
             </a>
         </li>
     </ul>
</body>
</html>

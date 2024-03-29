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
         <div id="go-to-likePage">
             <div class="form-group">
             	 <form name="redictToLikePage" id="redictForm01" action="findLikeFirst.action"
             	  method="post" style="display: inline">
                 	<input type="text" class="form-control" id="find-plan" name="queryStr" placeholder="输入计划标题">
               	 </form>
                 <button id="go-like" class="go">查找</button>
             </div>
         </div>
         <table class="table table-bordered table-striped">
             <tr>
                 <th style="text-align: center">计划ID</th> <th style="text-align: center">计划标题</th> 
                 <th style="text-align: center">开始时间</th> <th style="text-align: center">截止时间</th> 
                 <th style="text-align: center">计划描述</th> <th style="text-align: center">状态</th> 
                 <th style="text-align: center">操作</th>
             </tr>
             <c:forEach items="${page.formatPlanToJsons}" var="plan" end="9" varStatus="status">
             	<tr>
             		<td class="plan_id_${status.index}">${plan.plan_id}</td>
             		<td class="plan_title_${status.index}">${plan.plan_title}</td>
             		<td class="plan_starting_time_${status.index}">${plan.plan_starting_time}</td>
             		<td class="plan_ending_time_${status.index}">${plan.plan_ending_time}</td>
             		<td class="plan_describe_${status.index}">${plan.plan_describe}</td>
             		<td class="plan_status_${status.index}">${plan.plan_status}</td>
             		<td>
             			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#plan-detail"
             			 onclick="updatePlan(${plan.plan_id})">修改</button>
             			<span class="format"></span>
                     	<button type="button" class="btn btn-danger" onclick="deletePlan(${plan.plan_id})">删除</button>
                 	</td>
             	</tr>
             </c:forEach>
         </table>
         <nav>
             <ul class="pager">
           		 <form name="redictForm" id="redictForm" action="withStatusOthers.action" method="post">
            		<input type="hidden" name="otherPageNum" id="otherPageNum" value="${page.page_index}">
            		<input type="hidden" name="pageTotal" id="pageTotal" value="${page.pageNumber}">
            	 </form>
            	 <c:if test="${page.page_index == 1}">
            	 	<li><a href="javascript:;">首页</a></li>
                 	<li><a href="javascript:;">&larr;上一页</a></li>
            	 </c:if>
            	 <c:if test="${page.page_index != 1}">
                 <li><a href="javascript:;" onclick="redict(1)">首页</a></li>
                 <li><a href="javascript:;" onclick="redict(${page.page_index - 1})">&larr;上一页</a></li>
                 </c:if>
                 <input type="text" class="form-control" id="find-page" value="${page.page_index}">
                 <button id="go-page" class="go">Go</button>
                 <c:if test="${page.page_index == page.pageNumber}">
                 	<li><a href="javascript:;">下一页&rarr;</a></li>
                	<li><a href="javascript:;">尾页</a></li>
                 </c:if>
                 <c:if test="${page.page_index != page.pageNumber}">
	                 <li><a href="javascript:;" onclick="redict(${page.page_index + 1})">下一页&rarr;</a></li>
	                 <li><a href="javascript:;" onclick="redict(${page.pageNumber})">尾页</a></li>
                 </c:if>
             </ul>
         </nav>
     </div>

	 <!-- 任务详情及修改框 -->
	 <%@ include file="/WEB-INF/jsp/plan-detailAndEdit.jsp" %>

     <!-- floating window to add plan -->
     <ul id="add-plan-ul">
         <li style="display:none;"><button id="back-to-top" style="border:none"></button></li>
         <li>
             <a id="add-plan-li" data-toggle="modal" data-target="#addPlanModal">
                 <img src="${pageContext.request.contextPath}/images/add-plan.svg" style="height: 45px; width: 100%" />
             </a>
         </li>
     </ul>
     
     <!-- 添加任务框 -->
   	 <%@ include file="/WEB-INF/jsp/addPlan.jsp" %>
</body>
</html>

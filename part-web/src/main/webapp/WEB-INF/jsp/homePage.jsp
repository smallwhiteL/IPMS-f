<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IPMS-f</title>
<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<!-- Own CSS -->
<link href="${pageContext.request.contextPath}/css/home-style.css" rel="stylesheet">
<!-- Title Icon -->
<link href="${pageContext.request.contextPath}/images/plan.jpg" rel="shortcut icon">
<!-- JQuery (Before Bootstrap) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<!-- Load Bootstrap Javascript Plugin -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- Own Javascript -->
<script src="${pageContext.request.contextPath}/js/homePage.js"></script>
<script src="${pageContext.request.contextPath}/js/homePage2.js"></script>
</head>
<body>
	<%
		// 移除从其他页面的session信息
		if (session.getAttribute("otherPages") != null) {
			session.removeAttribute("status");
			session.removeAttribute("queryStr");
			session.removeAttribute("otherPages");
		}
	%>
	
	<!-- Header -->
	<%@ include file="/WEB-INF/jsp/common/pageHeader.jsp" %>
	
	<!-- Main Content -->
    <div class="plan-preview">
        <!-- Preview head -->
        <div class="preview-head">直至今天,您今年的计划情况如下:</div>
        <!-- toDo -->
        <div id="include-show">
            <label class="toDo">
                待开始<label class="item-count" id="toDo_plan">${toDo_count}项</label>
            </label>
            <label id="show">
                <a class="btn btn-default" id="show-button"
                data-toggle="collapse" href="#collapseListGroup1">查看</a>
            </label>
        </div>
        <div id="collapseListGroup1" class="panel-collapse collapse">
            <ul class="list-group">
                <c:if test="${toDo_count <= 5}">
            		<c:forEach items="${toDo_plan}" var="toDo_item">
            			<li class="list-group-item">
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail"
            				onclick="getPlanById(${toDo_item.plan_id})">${toDo_item.plan_title}</a>
            				<br><a class="btn btn-danger" data-dismiss="modal" style="font-size: 15px"
            				onclick="deletePlan(${toDo_item.plan_id})">删除</a>
           				</li>
            		</c:forEach>
            	</c:if>
                <c:if test="${toDo_count > 5}">
            		<c:forEach items="${toDo_plan}" end="4" var="toDo_item">
            			<li class="list-group-item">
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail"
            				onclick="getPlanById(${toDo_item.plan_id})">${toDo_item.plan_title}</a>
            				<br><a class="btn btn-danger" data-dismiss="modal" style="font-size: 15px"
            				onclick="deletePlan(${toDo_item.plan_id})">删除</a>
           				</li>
            		</c:forEach>
            	</c:if>
            </ul>
            <c:if test="${toDo_count > 5}">
	            <div class="panel-footer">
	            	<form name="redictForm1" action="toOneStatusPlan.action" method="post">
	            		<input type="hidden" name="status" value="1">
	            		<!-- 其他页的分页第一页 -->
        				<input type="hidden" name="otherPageNum" value="1">
	            	</form>
	                <a href="javascript:;" onclick="redict1()">查看所有>></a>
	            </div>
            </c:if>
        </div>
        <!-- doing -->
        <div id="include-show">
            <label class="doing">
                进行中<label class="item-count" id="doing_plan">${doing_count}项</label>
            </label>
            <label id="show">
                <a class="btn btn-default" id="show-button"
                data-toggle="collapse" href="#collapseListGroup2">查看</a>
            </label>
        </div>
        <div id="collapseListGroup2" class="panel-collapse collapse">
            <ul class="list-group">
            	<c:if test="${doing_count <= 5}">
            		<c:forEach items="${doing_plan}" var="doing_item">
            			<li class="list-group-item">
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail"
            				onclick="getPlanById(${doing_item.plan_id})">${doing_item.plan_title}</a>
            				<br><a class="btn btn-danger" data-dismiss="modal" style="font-size: 15px"
            				onclick="deletePlan(${doing_item.plan_id})">删除</a>
           				</li>
            		</c:forEach>
            	</c:if>
                <c:if test="${doing_count > 5}">
            		<c:forEach items="${doing_plan}" end="4" var="doing_item">
            			<li class="list-group-item">
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail"
            				onclick="getPlanById(${doing_item.plan_id})">${doing_item.plan_title}</a>
            				<br><a class="btn btn-danger" data-dismiss="modal" style="font-size: 15px"
            				onclick="deletePlan(${doing_item.plan_id})">删除</a>
           				</li>
            		</c:forEach>
            	</c:if>
            </ul>
            <c:if test="${doing_count > 5}">
	            <div class="panel-footer">
	            	<form name="redictForm2" action="toOneStatusPlan.action" method="post">
	            		<input type="hidden" name="status" value="2">
	            		<!-- 其他页的分页第一页 -->
        				<input type="hidden" name="otherPageNum" value="1">
	            	</form>
	                <a href="javascript:;" onclick="redict2()">查看所有>></a>
	            </div>
            </c:if>
        </div>
        <!-- done -->
        <div id="include-show">
            <label class="done">
                已结束<label class="item-count" id="done_plan">${done_count}项</label>
            </label>
            <label id="show">
                <a class="btn btn-default" id="show-button"
                data-toggle="collapse" href="#collapseListGroup3">查看</a>
            </label>
        </div>
        <div id="collapseListGroup3" class="panel-collapse collapse">
            <ul class="list-group">
            	<c:if test="${done_count <= 5}">
            		<c:forEach items="${done_plan}" var="done_item">
            			<li class="list-group-item">
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail"
            				onclick="getPlanById(${done_item.plan_id})">${done_item.plan_title}</a>
            				<br><a class="btn btn-danger" data-dismiss="modal" style="font-size: 15px"
            				onclick="deletePlan(${done_item.plan_id})">删除</a>
           				</li>
            		</c:forEach>
            	</c:if>
            	<c:if test="${done_count > 5}">
            		<c:forEach items="${done_plan}" end="4" var="done_item">
            			<li class="list-group-item">
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail"
            				onclick="getPlanById(${done_item.plan_id})">${done_item.plan_title}</a>
            				<br><a class="btn btn-danger" data-dismiss="modal" style="font-size: 15px"
            				onclick="deletePlan(${done_item.plan_id})">删除</a>
           				</li>
            		</c:forEach>
            	</c:if>
            </ul>
            <c:if test="${done_count > 5}">
	            <div class="panel-footer">
	            	<form name="redictForm3" action="toOneStatusPlan.action" method="post">
	            		<input type="hidden" name="status" value="3">
	            		<!-- 其他页的分页第一页 -->
        				<input type="hidden" name="otherPageNum" value="1">
	            	</form>
	                <a href="javascript:;" onclick="redict3()">查看所有>></a>
	            </div>
            </c:if>
        </div>
        <!-- failed -->
        <div id="include-show">
           <label class="failed">
                已逾期<label class="item-count" id="failed_plan">${failed_count}项</label>
            </label>
            <label id="show">
                <a class="btn btn-default" id="show-button"
                data-toggle="collapse" href="#collapseListGroup4">查看</a>
            </label>
        </div>
        <div id="collapseListGroup4" class="panel-collapse collapse">
            <ul class="list-group">
            	<c:if test="${failed_count <= 5}"> 
	            	<c:forEach items="${failed_plan}" var="failed_item">
	            		<li class="list-group-item">
	            			<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail"
	            			onclick="getPlanById(${failed_item.plan_id})">${failed_item.plan_title}</a>
	            			<br><a class="btn btn-danger" data-dismiss="modal" style="font-size: 15px"
	            			onclick="deletePlan(${failed_item.plan_id})">删除</a>
            		 	</li>
	            	</c:forEach>
            	</c:if>
            	<c:if test="${failed_count > 5}">
		            <c:forEach items="${failed_plan}" end="4" var="failed_item">
	            		<li class="list-group-item">
	            			<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail"
	            			onclick="getPlanById(${failed_item.plan_id})">${failed_item.plan_title}</a>
	            			<br><a class="btn btn-danger" data-dismiss="modal" style="font-size: 15px"
	            			onclick="deletePlan(${failed_item.plan_id})">删除</a>
            		 	</li>
	            	</c:forEach>
           		</c:if>
            </ul>
            <c:if test="${failed_count > 5}">
	            <div class="panel-footer">
	            	<form name="redictForm4" action="toOneStatusPlan.action" method="post">
	            		<input type="hidden" name="status" value="4">
	            		<!-- 其他页的分页第一页 -->
        				<input type="hidden" name="otherPageNum" value="1">
	            	</form>
	                <a href="javascript:;" onclick="redict4()">查看所有>></a>
	            </div>
            </c:if>
        </div>
    </div>

    <!-- floating button to implement toggle -->
    <div id="toggle">
        <a style="cursor:pointer;" id="change-toggle">
            <img id="toggle-pic">
        </a>
    </div>
    
   	<!-- 任务详情及修改框 -->
   	<%@ include file="/WEB-INF/jsp/plan-detailAndEdit.jsp" %>

    <!-- plan find -->
    <div id="go-to-likePage">
        <div class="form-group">
        	<form name="redictToLikePage" action="../fromHome/findLikeFirst.action"
        	 method="post" style="display: inline">
	            <input type="text" class="form-control" style="width: 40%; display: inline-block; font-size: 25px;"
	            id="find-plan" name="queryStr" placeholder="输入计划标题">
           	</form>
            <button id="go">查找</button>
        </div>
    </div>
    
    <div id="year">
        <div style="text-align:center">
            <select class="form-control dropup" id="select-list">
            </select>
            <img id="animal-year">
        </div>
        <div class="month" id="first" style="margin-left:0"><a href="javascript:;" id="January" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/January.svg">
        </a></div>
        <div class="month" id="second"><a href="javascript:;" id="February" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/February.svg">
       	</a></div>
        <div class="month" id="third"><a href="javascript:;" id="March" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/March.svg">
        </a></div>
        <div class="month" id="fourth" style="margin-left:0"><a href="javascript:;" id="April" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/April.svg">
        </a></div>
        <div class="month" id="fifth"><a href="javascript:;" id="May" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/May.svg">
        </a></div>
        <div class="month" id="sixth"><a href="javascript:;" id="June" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/June.svg">
        </a></div>
        <div class="month" id="seventh" style="margin-left:0"><a href="javascript:;" id="July" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/July.svg">
        </a></div>
        <div class="month" id="eighth"><a href="javascript:;" id="August" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/August.svg">
        </a></div>
        <div class="month" id="ninth"><a href="javascript:;" id="September" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/September.svg">
        </a></div>
        <div class="month" id="tenth" style="margin-left:0"><a href="javascript:;" id="October" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/October.svg">
        </a></div>
        <div class="month" id="eleventh"><a href="javascript:;" id="November" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/November.svg">
        </a></div>
        <div class="month" id="twelfth"><a href="javascript:;" id="December" class="toMonth">
        	<img src="${pageContext.request.contextPath}/images/month/December.svg">
        </a></div>
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
    
    <!-- 添加任务框 -->
    <%@ include file="/WEB-INF/jsp/addPlan.jsp" %>
    
    <form name="redictToMonthPage" action="../fromHome/toMonthPage.action"
   	 method="post" style="display: inline">
         <input type="hidden" class="form-control" id="find-month" name="yearAndMonth">
   	</form>
    
</body>
</html>

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
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail">${toDo_item.plan_title}</a>
           				</li>
            		</c:forEach>
            	</c:if>
                <c:if test="${toDo_count > 5}">
            		<c:forEach items="${toDo_plan}" end="4" var="toDo_item">
            			<li class="list-group-item">
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail">${toDo_item.plan_title}</a>
           				</li>
            		</c:forEach>
            	</c:if>
            </ul>
            <c:if test="${toDo_count > 5}">
	            <div class="panel-footer">
	                <a href="javascript:;">查看所有>></a>
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
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail">${doing_item.plan_title}</a>
           				</li>
            		</c:forEach>
            	</c:if>
                <c:if test="${doing_count > 5}">
            		<c:forEach items="${doing_plan}" end="4" var="doing_item">
            			<li class="list-group-item">
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail">${doing_item.plan_title}</a>
           				</li>
            		</c:forEach>
            	</c:if>
            </ul>
            <c:if test="${doing_count > 5}">
	            <div class="panel-footer">
	                <a href="javascript:;">查看所有>></a>
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
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail">${done_item.plan_title}</a>
           				</li>
            		</c:forEach>
            	</c:if>
            	<c:if test="${done_count > 5}">
            		<c:forEach items="${done_plan}" end="4" var="done_item">
            			<li class="list-group-item">
            				<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail">${done_item.plan_title}</a>
           				</li>
            		</c:forEach>
            	</c:if>
            </ul>
            <c:if test="${done_count > 5}">
	            <div class="panel-footer">
	                <a href="javascript:;">查看所有>></a>
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
	            			<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail">${failed_item.plan_title}</a>
            		 	</li>
	            	</c:forEach>
            	</c:if>
            	<c:if test="${failed_count > 5}">
		            <c:forEach items="${failed_plan}" end="4" var="failed_item">
	            		<li class="list-group-item">
	            			<a style="cursor:pointer" data-toggle="modal" data-target="#plan-detail">${failed_item.plan_title}</a>
            		 	</li>
	            	</c:forEach>
           		</c:if>
            </ul>
            <c:if test="${failed_count > 5}">
	            <div class="panel-footer">
	                <a href="javascript:;">查看所有>></a>
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

    <!-- plan date list -->
    <div id="go-to-concrete">
        <div class="form-group">
            <input type="text" class="form-control" style="width: 40%; display: inline-block; font-size: 25px; 
            " placeholder="输入计划标题">
            <button id="go">查找</button>
        </div>
    </div>
    
    <div id="year">
        <div style="text-align:center">
            <select class="form-control dropup" id="select-list">
            </select>
            <img id="animal-year">
        </div>
        <div class="month" id="first" style="margin-left:0"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/January.svg"></a></div>
        <div class="month" id="second"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/February.svg"></a></div>
        <div class="month" id="third"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/March.svg"></a></div>
        <div class="month" id="fourth" style="margin-left:0"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/April.svg"></a></div>
        <div class="month" id="fifth"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/May.svg"></a></div>
        <div class="month" id="sixth"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/June.svg"></a></div>
        <div class="month" id="seventh" style="margin-left:0"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/July.svg"></a></div>
        <div class="month" id="eighth"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/August.svg"></a></div>
        <div class="month" id="ninth"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/September.svg"></a></div>
        <div class="month" id="tenth" style="margin-left:0"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/October.svg"></a></div>
        <div class="month" id="eleventh"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/November.svg"></a></div>
        <div class="month" id="twelfth"><a href="javascript:;"><img src="${pageContext.request.contextPath}/images/month/December.svg"></a></div>
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
    
</body>
</html>

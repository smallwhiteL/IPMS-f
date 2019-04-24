<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IPMS-f</title>
<!-- Own CSS -->
<link href="${pageContext.request.contextPath}/css/individualInfo-style.css" rel="stylesheet">
<!-- Title Icon -->
<link href="${pageContext.request.contextPath}/images/plan.jpg" rel="shortcut icon">
<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<!-- JQuery (Before Bootstrap) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<!-- Load Bootstrap Javascript Plugin -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- Own Javascript -->
<script src="${pageContext.request.contextPath}/js/individualInfo.js"></script>
</head>
<body>

	<!-- Header -->
	<%@ include file="/WEB-INF/jsp/common/pageHeader.jsp" %>
	
	<form class="form-horizontal" id="info-form" enctype="multipart/form-data" method="POST" 
	action="../home/updateInfo.action" style="font-weight: bold; font-size: 20px;">
        <!-- 头像 -->
        <div id="portrait">
            <div class="row">
                <div style="height:200px; width: 200px; background-color:black;">
                	<c:if test="${user.portrait == null || user.portrait == ''}">
                		<c:if test="${user.sex == '女'}">
                    		<img src="${pageContext.request.contextPath}/images/curlGirl.svg" id="portrait-pic" style="height: 100%; width: 100%">
                		</c:if>
                		<c:if test="${user.sex == '男'}">
                			<img src="${pageContext.request.contextPath}/images/onePunch.svg" id="portrait-pic" style="height: 100%; width: 100%">
                		</c:if>
                	</c:if>
                	<c:if test="${user.portrait != null && user.portrait != ''}">
                		<img src="${pageContext.request.contextPath}/pic/${user.portrait}" id="portrait-pic" style="height: 100%; width: 100%">
                	</c:if>
                </div>
            </div>
            <div class="row">
                <input type="file" style="font-weight: bold; font-size: 20px;" name="file"
                accept="image/*">
            </div>
        </div>
        <br>
        <div class="form-group">
          <!-- 名字 -->
          <label for="inputName" class="col-sm-2 control-label">姓名</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="inputName" name="inputName"
             style="width:30%; height: 40px; font-weight: bold; font-size: 20px;" value="${user.name}">
          </div>
        </div>

        <!-- 性别 -->
        <div class="form-group">
          <label class="col-sm-2 control-label">性别</label>
          <div class="col-sm-10">
          	<c:if test="${user.sex == '男'}">
	            <label class="radio-inline" style="height: 37px;">
	                <input type="radio" value="男" name="sex" id="man" checked="checked"
	                style="height: 20px; width: 20px; margin-top: 8px" class="form-control">
	                	男
	            </label>
	            <label class="radio-inline" style="height: 37px;">
	                <input type="radio" value="女" name="sex" id="woMan"
	                style="height: 20px; width: 20px; margin-top: 8px" class="form-control">
	                	女
	            </label>
            </c:if>
            <c:if test="${user.sex == '女'}">
	            <label class="radio-inline" style="height: 37px;">
	                <input type="radio" value="男" name="sex" id="man"
	                style="height: 20px; width: 20px; margin-top: 8px" class="form-control">
	                	男
	            </label>
	            <label class="radio-inline" style="height: 37px;">
	                <input type="radio" value="女" name="sex" id="woMan" checked="checked"
	                style="height: 20px; width: 20px; margin-top: 8px" class="form-control">
	                	女
	            </label>
            </c:if>
          </div>
        </div>

        <!-- 生日 -->
        <div class="form-group">
            <label for="inputBirthday" class="col-sm-2 control-label">生日</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" id="inputBirthday" name="inputBirthday" style="font-weight: bold; 
                font-size: 20px; width:30%; height: 40px;" value="${user.formatBirthday}">
            </div>
        </div>

        <!-- 个人签名 -->
        <div class="form-group">
            <label for="inputSignature" class="col-sm-2 control-label">个人签名</label>
            <div class="col-sm-10">
            	<c:if test="${user.individuality_signature != null && user.individuality_signature != ''}">
	                <textarea class="form-control" id="inputSignature" name="inputSignature"
	                style="font-size:1.2em;height: 250px; width: 50%">${user.individuality_signature}</textarea>
            	</c:if>
            	<c:if test="${user.individuality_signature == null || user.individuality_signature == ''}">
	                <textarea class="form-control" id="inputSignature" name="inputSignature" placeholder="个人签名"
	                style="font-size:1.2em;height: 250px; width: 50%"></textarea>
            	</c:if>
            </div>
        </div>


        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-default" id="update" style="font-weight: bold; 
            font-size: 20px; color: white; background-color: black">保存</button>
            <span id="warn" style="color:red"></span>
          </div>
        </div>
    </form>
	
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>页头</title>
<!-- Own CSS -->
<link href="${pageContext.request.contextPath}/css/pageHeader-style.css" rel="stylesheet">
</head>
<body>
	<!-- Header -->
    <div style="background-color:#E5E5E5" class="headerHeightAjustment">
        <!-- welcome and portrait -->
        <div class="col-xs-5 col-lg-4">
            <div class="col-xs-7 col-lg-8 left-part-welcome">
		        <c:if test="${not empty loginUser}">
		        	<c:if test="${empty otherPages}">
		               	欢迎您!<br>
		               	<a href="toIndividualInfoPage.action">${loginUser.name}</a>
	               	</c:if>
	               	<c:if test="${not empty otherPages}">
		               	欢迎您!<br>
		               	<a href="../home/toIndividualInfoPage.action">${loginUser.name}</a>
	               	</c:if>
		        </c:if>
            </div>
            <div class="col-xs-5 col-lg-4 left-part-portrait">
                <c:if test="${not empty loginUser}">
                	<c:if test="${loginUser.portrait == '' || loginUser.portrait == null}">
                		<c:if test="${loginUser.sex == '女'}">
                			<img src="${pageContext.request.contextPath}/images/curlGirl.svg" id="portrait-head" class="img-circle">
                		</c:if>
                		<c:if test="${loginUser.sex == '男'}">
                			<img src="${pageContext.request.contextPath}/images/onePunch.svg" id="portrait-head" class="img-circle">
                		</c:if>
                	</c:if>
                	<c:if test="${loginUser.portrait != '' && loginUser.portrait != null}">
                		<img src="${pageContext.request.contextPath}/pic/${loginUser.portrait}" id="portrait-head" class="img-circle">
                	</c:if>
                </c:if>
            </div>
        </div>
        <!-- logo -->
        <div class="col-xs-3 col-lg-4 logo-part">
            IPMS<br>
           	个人计划管理系统
        </div>
        <!-- back-to-home and logout -->
        <div class="col-xs-4">
           <div class="col-xs-8 right-part-back-to-home">
	        	<c:if test="${not empty otherPages}">
	                <a href="javascript:;" id="toHomePage">回到首页</a>
	            </c:if>
           </div>
           <div class="col-xs-4 right-part-logout">
		        <c:if test="${not empty loginUser}">
                	<a id="logout" href="javascript:;">注销</a>
	            </c:if>
           </div>
        </div>
    </div>
</body>
</html>

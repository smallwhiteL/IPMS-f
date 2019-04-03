<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IPMS-f</title>
<!-- Bootstrap CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<!-- Own CSS -->
<link href="${pageContext.request.contextPath}/css/home-style.css" rel="stylesheet">
<!-- JQuery (Before Bootstrap) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<!-- Load Bootstrap Javascript Plugin -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- Own Javascript -->
<script src="${pageContext.request.contextPath}/js/homePage.js"></script>
<!-- Get iPAddress script from sohu browser -->
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
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
                未开始<label class="item-count">1001项</label>
            </label>
            <label id="show">
                <a class="btn btn-default" id="show-button"
                data-toggle="collapse" href="#collapseListGroup1">查看</a>
            </label>
        </div>
        <div id="collapseListGroup1" class="panel-collapse collapse">
            <ul class="list-group">
                <li class="list-group-item">Anim pariatur cliche reprehenderit, enim eiusmod high life</li>
                <li class="list-group-item">non cupidatat skateboard dolor brunch. Food truck quinoa</li>
                <li class="list-group-item">sunt aliqua put a bird on it squid single-origin coffee</li>
                <li class="list-group-item">craft beer labore wes anderson cred nesciunt sapiente ea</li>
                <li class="list-group-item">raw denim aesthetic synth nesciunt you probably haven't</li>
            </ul>
            <div class="panel-footer">
                <a href="javascript:;">查看所有>></a>
            </div>
        </div>
        <!-- doing -->
        <div id="include-show">
            <label class="doing">
                进行中<label class="item-count">9项</label>
            </label>
            <label id="show">
                <a class="btn btn-default" id="show-button"
                data-toggle="collapse" href="#collapseListGroup2">查看</a>
            </label>
        </div>
        <div id="collapseListGroup2" class="panel-collapse collapse">
            <ul class="list-group">
                <li class="list-group-item">Anim pariatur cliche reprehenderit, enim eiusmod high life</li>
                <li class="list-group-item">non cupidatat skateboard dolor brunch. Food truck quinoa</li>
                <li class="list-group-item">sunt aliqua put a bird on it squid single-origin coffee</li>
                <li class="list-group-item">craft beer labore wes anderson cred nesciunt sapiente ea</li>
                <li class="list-group-item">raw denim aesthetic synth nesciunt you probably haven't</li>
            </ul>
            <div class="panel-footer">
                <a href="javascript:;">查看所有>></a>
            </div>
        </div>
        <!-- done -->
        <div id="include-show">
            <label class="done">
                已结束<label class="item-count">1314项</label>
            </label>
            <label id="show">
                <a class="btn btn-default" id="show-button"
                data-toggle="collapse" href="#collapseListGroup3">查看</a>
            </label>
        </div>
        <div id="collapseListGroup3" class="panel-collapse collapse">
            <ul class="list-group">
                <li class="list-group-item">Anim pariatur cliche reprehenderit, enim eiusmod high life</li>
                <li class="list-group-item">non cupidatat skateboard dolor brunch. Food truck quinoa</li>
                <li class="list-group-item">sunt aliqua put a bird on it squid single-origin coffee</li>
                <li class="list-group-item">craft beer labore wes anderson cred nesciunt sapiente ea</li>
                <li class="list-group-item">raw denim aesthetic synth nesciunt you probably haven't</li>
            </ul>
            <div class="panel-footer">
                <a href="javascript:;">查看所有>></a>
            </div>
        </div>
        <!-- failed -->
        <div id="include-show">
           <label class="failed">
                已逾期<label class="item-count">lol项</label>
            </label>
            <label id="show">
                <a class="btn btn-default" id="show-button"
                data-toggle="collapse" href="#collapseListGroup4">查看</a>
            </label>
        </div>
        <div id="collapseListGroup4" class="panel-collapse collapse">
            <ul class="list-group">
                <li class="list-group-item">Anim pariatur cliche reprehenderit, enim eiusmod high life</li>
                <li class="list-group-item">non cupidatat skateboard dolor brunch. Food truck quinoa</li>
                <li class="list-group-item">sunt aliqua put a bird on it squid single-origin coffee</li>
                <li class="list-group-item">craft beer labore wes anderson cred nesciunt sapiente ea</li>
                <li class="list-group-item">raw denim aesthetic synth nesciunt you probably haven't</li>
            </ul>
            <div class="panel-footer">
                <a href="javascript:;">查看所有>></a>
            </div>
        </div>
    </div>

    <!-- floating button to implement toggle -->
    <div id="toggle">
        <a style="cursor:pointer;" id="change-toggle">
            <img id="toggle-pic">
        </a>
    </div>

    <!-- plan date list -->
    <div id="go-to-concrete">
        <div class="form-group">
            查看此日内容:<input type="date" class="form-control" id="concrete-day">
            <button id="go">Go</button>
        </div>
    </div>
    
    <div id="year">
        <div style="text-align:center">
            <select class="form-control dropup" id="select-list">
                <option selected="selected">2019</option>
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
            <a id="add-plan-li" href="javascript:;">
                <img src="${pageContext.request.contextPath}/images/add-plan.svg" style="height: 45px; width: 100%" />
            </a>
        </li>
    </ul>
</body>
</html>

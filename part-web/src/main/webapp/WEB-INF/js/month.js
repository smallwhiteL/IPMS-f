$(function(){
	
	// 回到首页
	$("#toHomePage").click(function() {
		location.href="../home/homePage";
	});
	
	// 注销
	$("#logout").click(function() {
		var ifLogout = confirm("确认注销？");
		if (ifLogout) {
			location.href="../home/logout";
		}
	});
	
    /**
     * 页面初始加载
     */
    var year = parseInt($("#month-choice").val().split("-")[0]);
    var month = parseInt($("#month-choice").val().split("-")[1])-1;
    var week; // 代表周几-1, 表格设有35个单元格, 用来将每月一号之前的日子和每月最后一天之后的日子添加空白日期
    var days = new Date(year, month+1, 0).getDate(); // 代表一个月有几天
    var dayOfWeek = new Date(year, month, 1).getDay(); // 每月第一天是星期几, 这里与上面不同是因为getDay的周几从0开始,月份也从0开始
    if( dayOfWeek == 0 ) week = 6;
    else if ( dayOfWeek == 1 ) week = 0;
    else if ( dayOfWeek == 2 ) week = 1;
    else if ( dayOfWeek == 3 ) week = 2;
    else if ( dayOfWeek == 4 ) week = 3;
    else if ( dayOfWeek == 5 ) week = 4;
    else if ( dayOfWeek == 6 ) week = 5;
    // alert("days:" + days + "  dayOfWeek:" + dayOfWeek + "  month:" + month + "  year:" + year);
    for (var i = 0, day = 1; i < 6; i++) { // day代表每月一号之前填空白的日期数量
        $("#days-table").append("<tr></tr>");
        for (var j = 0; j < 7; j++) {
            if (day <= week ) { // 每月一号之前的处理-添加空白日期
                $("#days-table tr:eq(" + (i+1) + ")").append("<td></td>");
                day++; // 1月时等于1
            }
            else if( ((i*7)+(j+1)+1) <= (days+day) ) { // ((i*7)+(j+1)+1) 中(i*7代表每行的起始)
                $("#days-table tr:eq(" + (i+1) + ")").append("<td>" + ((i*7)+(j+1)-day+1) + "</td>");
            } else { // 每月最后一天之后的处理-添加空白日期
                $("#days-table tr:eq(" + (i+1) + ")").append("<td></td>");
            }
        }
    }
    /**
     * 给其中某一天上色。。
     */
    $("#days-table tr td").each(function(){
    	var thisTd = $(this);
        var text = $(this).text();
        if (text != "") {
        	$.ajax({
        		type: "post",
        		url: "ifChangeColor.action",
        		data: {
        			"date" : $("#month-choice").val() + "-" + $(this).text()
        		},
        		success:function(data) {
        			if (data == "yes") {
        				thisTd.html("<a href='javascript:;' style='color: red' class='dayOfMonth' onclick='redirect(this)'>" 
        						+ text +"</a>");
        			}
        		}
        	});
        }
    });

    /**
     * 监听月份变化
     */
    $("#month-choice").on("input propertychange", function () {

        $("#days-table tr").remove(); // 先清除之前的元素

        year = parseInt($("#month-choice").val().split("-")[0]);
        month = parseInt($("#month-choice").val().split("-")[1])-1;
        days = new Date(year, month+1, 0).getDate();
        dayOfWeek = new Date(year, month, 1).getDay();
        if( dayOfWeek == 0 ) week = 6;
        else if ( dayOfWeek == 1 ) week = 0;
        else if ( dayOfWeek == 2 ) week = 1;
        else if ( dayOfWeek == 3 ) week = 2;
        else if ( dayOfWeek == 4 ) week = 3;
        else if ( dayOfWeek == 5 ) week = 4;
        else if ( dayOfWeek == 6 ) week = 5;
        for (var i = 0, day = 1; i < 7; i++) {
            $("#days-table").append("<tr></tr>");
            if ( i == 0) { // 添加表头
                $("#days-table tr:eq(0)")
                .append("<th>周一</th><th>周二</th><th>周三</th><th>周四</th><th>周五</th><th>周六</th><th>周日</th>");
            } else {
                for (var j = 0; j < 7; j++) {
                    if (day <= week ) { // 每月一号之前的处理-添加空白日期
                        $("#days-table tr:eq(" + i + ")").append("<td></td>");
                        day++; // 1月时等于1
                    }
                    else if( (((i-1)*7)+(j+1)+1) <= (days+day) ) {
                        $("#days-table tr:eq(" + (i) + ")").append("<td>" + (((i-1)*7)+(j+1)-day+1) + "</td>");
                    } else { // 每月最后一天之后的处理-添加空白日期
                        $("#days-table tr:eq(" + (i) + ")").append("<td></td>");
                    }
                }
            }
        }

        /**
         * 改变输入日期后,给其中某一天上色。。
         */
        $("#days-table tr td").each(function(){
        	var thisTd = $(this);
            var text = $(this).text();
            if (text != "") {
            	$.ajax({
            		type: "post",
            		url: "ifChangeColor.action",
            		data: {
            			"date" : $("#month-choice").val() + "-" + text
            		},
            		success:function(data) {
            			if (data == "yes") {
            				thisTd.html("<a href='javascript:;' style='color: red' class='dayOfMonth' onclick='redirect(this)'>" 
            						+ text +"</a>");
            			}
            		}
            	});
            }
        });
    });
    
    var plan_start_detail = $("#plan-start-detail");
	var plan_end_detail = $("#plan-end-detail");
	var plan_start = $("#plan-start");
	var plan_end = $("#plan-end");
    
    // 添加任务
	$("#add").click(function(){
        
        var add_start_time = new Date(Date.parse(plan_start.val()));
        var add_end_time = new Date(Date.parse(plan_end.val()));
        var today = new Date();
        var plan_status;

        if ( $("#plan-title").val() == "" || plan_start.val() == "" || plan_end.val() == "" ) {
            $("#add-tips").html("标题及起始时间不能为空!");
        } else {
            if ( add_start_time <= add_end_time ) {
                // 根据今天判断状态,若小于开始时间默认为-未开始,若在开始时间和截止时间之间默认为-进行中,若大于截止时间根据以下情况判断状态
                if ( today > add_end_time ) { // 4.10 15:54 > 4.10 8:00
                    if ( $("#add-done-status").prop("checked") || $("#add-failed-status").prop("checked") ) {
                    	plan_status = $("#add-done-status").prop("checked")?"3":"4";
                    	$.ajax({
                    		type: "post",
                    		url: "../home/addPlan.action",
                    		data: {
                    			"plan-title" : $("#plan-title").val(),
                    			"plan-describe" : $("#plan-describe").val(),
                    			"plan-start-date" : plan_start.val(),
                    			"plan-end-date" : plan_end.val(),
                    			"plan-status" : plan_status
                    		}
                    	});
                        alert("添加成功!");
                        location.reload(true); // 由于窗口重新加载所以清空模态框的消息不用手动敲出来
    
                    }else {
                        if ( today.getDate() > add_end_time.getDate() ) { // 这个判断出现的原因是Date.parse()转换过来的日期默认为 8:00 am
                            $("#add-tips").html("今天在截止时间之后,请选择状态!");
                        } else { // 4.10 = 4.10
                        	plan_status = "2";
                        	$.ajax({
                        		type: "post",
                        		url: "../home/addPlan.action",
                        		data: {
                        			"plan-title" : $("#plan-title").val(),
                        			"plan-describe" : $("#plan-describe").val(),
                        			"plan-start-date" : plan_start.val(),
                        			"plan-end-date" : plan_end.val(),
                        			"plan-status" : plan_status
                        		}
                        	});
                            alert("添加成功!");
                            location.reload(true);
                        }
                        
                    }
                }else {
            		plan_status = today < add_start_time ? "1":"2";
                	$.ajax({
                		type: "post",
                		url: "../home/addPlan.action",
                		data: {
                			"plan-title" : $("#plan-title").val(),
                			"plan-describe" : $("#plan-describe").val(),
                			"plan-start-date" : plan_start.val(),
                			"plan-end-date" : plan_end.val(),
                			"plan-status" : plan_status
                		}
                	});
                    alert("添加成功!");
                    location.reload(true);
                }

            }
            else {
                $("#add-tips").html("开始时间不能大于截止时间!");
            }
        }
    });
	
	$(".cancel-add").click(function(){
        $(".add-status").prop("checked", false);
        $("#add-tips").html("");
        $("#plan-title").val("");
        $("#plan-describe").val("");
        plan_start.val("");
        plan_end.val("");
        $(".status-list").css({"display": "none"});
    });
	
	// 判断今天和截止日期的大小,确定是否显示状态按钮,而修改则不需要,因为修改操作一定存在状态
	$("#plan-end").on("input propertychange", function () {
        var add_end_time = new Date(Date.parse(plan_end.val()));
        var today = new Date();

        if (today > add_end_time) {
            if ( today.getDate() > add_end_time.getDate() ) { // 这个判断出现的原因是Date.parse()转换过来的日期默认为 8:00 am
                $(".status-list").css({"display": "block"});
            } else {
                $(".status-list").css({"display": "none"});
            }
        } else {
            $(".status-list").css({"display": "none"});
        }
	});
	
	// 限定textarea输入字符
	$("#plan-describe").on("input propertychange", function () {
		var $this = $(this),
		  _val = $this.val(); //文本框内容
		  if (_val.length > 255) {  //当文本框内容长度超过255，只取0到255的内容
			 $this.val(_val.substring(0, 255));
		  }
	});
    
});

/**
 * 点击含有任务的截止日期
 */
function redirect(obj) {
	$("#toEndTimePage").val($("#month-choice").val() + "-" + obj.text);
	document.redictToEndTimePage.submit();
}
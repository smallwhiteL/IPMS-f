$(function() {
	// 回到顶部
    $(window).scroll(function() {
		if ($(window).scrollTop() > 70) {
			$('#add-plan-ul li:eq(0)').fadeIn(500);
		} else {
			$('#add-plan-ul li:eq(0)').fadeOut(500);
		}
	});

    $("#back-to-top").click(function() {
		$('body,html').animate({
			scrollTop: 0
		},
        500);
	});
	
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
    
	// 更新
	$("#update").click(function() {
		if ($("#inputName").val() == "" || $("#inputBirthday").val() == "") {
			alert("姓名和出生日期不能为空!");
		} else {
			$("#info-form").submit();
			alert("更新成功!");
		}
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
                	if (today.getYear() == add_end_time.getYear()) { // 判断年份
                		if(today.getMonth() == add_end_time.getMonth()) { // 判断月份
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
                		} else {
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
                                $("#add-tips").html("今天在截止时间之后,请选择状态!");
    	                    }
                		}
                	}
                	else {
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
                            $("#add-tips").html("今天在截止时间之后,请选择状态!");
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
        	if (today.getYear() == add_end_time.getYear()) { // 判断年份
        		if(today.getMonth() == add_end_time.getMonth()) { // 判断月份
        			if ( today.getDate() > add_end_time.getDate() ) { // 这个判断出现的原因是Date.parse()转换过来的日期默认为 8:00 am
        				$(".status-list").css({"display": "block"});
        			} else {
        				$(".status-list").css({"display": "none"});
        			}
        		}else {
            		$(".status-list").css({"display": "block"});
            	}
        	}
        	else {
        		$(".status-list").css({"display": "block"});
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
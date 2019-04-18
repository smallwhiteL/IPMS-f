var plan_id;

$(function(){
	var plan_start_detail = $("#plan-start-detail");
	var plan_end_detail = $("#plan-end-detail");
	var plan_start = $("#plan-start");
	var plan_end = $("#plan-end");


    // 点击修改,激活所有修改项
    $("#update").click(function(){

        var detail_start_time = new Date(Date.parse(plan_start_detail.val()));
        var detail_end_time = new Date(Date.parse(plan_end_detail.val()));

        if ($(this).html() == "修改") {
            $("#plan-title-detail").removeAttr("readonly");
            $("#plan-describe-detail").removeAttr("readonly");
            plan_start_detail.removeAttr("disabled");
            plan_end_detail.removeAttr("disabled");
            $("#toDo-status").removeAttr("disabled");
            $("#doing-status").removeAttr("disabled");
            $("#done-status").removeAttr("disabled");
            $("#failed-status").removeAttr("disabled");
            $(this).html("完成");
        }
        else if ($(this).html() == "完成") {
            if ( $("#plan-title-detail").val() == "" || plan_start_detail.val() == "" || plan_end_detail.val() == "" ) {
                $("#edit-tips").html("标题及起始时间不能为空!"); // 由于这里是从后台获取信息,单选按钮必有值,可以不检查状态是否为空
            } else {
                if ( detail_start_time <= detail_end_time ) {
                	var status;
                	if ( $("#toDo-status").prop("checked") ) {
                		status = "1";
                	} else if ( $("#doing-status").prop("checked") ) {
                		status = "2";
                	} else if ( $("#done-status").prop("checked") ) {
                		status = "3";
                	} else if ( $("#failed-status").prop("checked") ) {
                		status = "4";
                	}
                	$.ajax({
            			type: "post",
            			url: "updatePlan.action",
            			data: {
            				"plan_id" : plan_id + "",
            				"plan_title" : $("#plan-title-detail").val(),
            				"plan_starting_time" : $("#plan-start-detail").val(),
            				"plan_ending_time" : $("#plan-end-detail").val(),
            				"plan_describe" : $("#plan-describe-detail").val(),
            				"plan_status" : status
        				}
            		});
                	alert("修改成功!");
                	location.reload(true);

                }
                else {
                    $("#edit-tips").html("开始时间不能大于截止时间!");
                }
            }
        }
    });

    $(".cancel-update").click(function(){
        if ($("#update").html() == "完成") {
            $("#plan-title-detail").attr("readonly", "readonly");
            $("#plan-describe-detail").attr("readonly", "readonly");
            plan_start_detail.attr("disabled", "disabled");
            plan_end_detail.attr("disabled", "disabled");
            $("#toDo-status").attr("disabled", "disabled");
            $("#doing-status").attr("disabled", "disabled");
            $("#done-status").attr("disabled", "disabled");
            $("#failed-status").attr("disabled", "disabled");
            $("#edit-tips").html("");
            $("#plan-detail").modal('hide');
            $("#update").html("修改");
        }
    });
    
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
                    		url: "addPlan.action",
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
                        		url: "addPlan.action",
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
                		url: "addPlan.action",
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
	$("#plan-describe-detail").on("input propertychange", function () {
		var $this = $(this),
		  _val = $this.val(); //文本框内容
		  if (_val.length > 255) {  //当文本框内容长度超过255，只取0到255的内容
			 $this.val(_val.substring(0, 255));
		  }
	});
	
	// 去到模糊查询页
	$("#go").click(function() {
		if($("#find-plan").val() != ""){
			document.redictToLikePage.submit();
		}
	});
	
	// 去到某月页面
	$(".toMonth").click(function() {
		if ($(this).attr('id') == "January") {
			$("#find-month").val($("#select-list").val() + "-01");
		} else if ($(this).attr('id') == "February") {
			$("#find-month").val($("#select-list").val() + "-02");
		} else if ($(this).attr('id') == "March") {
			$("#find-month").val($("#select-list").val() + "-03");
		} else if ($(this).attr('id') == "April") {
			$("#find-month").val($("#select-list").val() + "-04");
		} else if ($(this).attr('id') == "May") {
			$("#find-month").val($("#select-list").val() + "-05");
		} else if ($(this).attr('id') == "June") {
			$("#find-month").val($("#select-list").val() + "-06");
		} else if ($(this).attr('id') == "July") {
			$("#find-month").val($("#select-list").val() + "-07");
		} else if ($(this).attr('id') == "August") {
			$("#find-month").val($("#select-list").val() + "-08");
		} else if ($(this).attr('id') == "September") {
			$("#find-month").val($("#select-list").val() + "-09");
		} else if ($(this).attr('id') == "October") {
			$("#find-month").val($("#select-list").val() + "-10");
		} else if ($(this).attr('id') == "November") {
			$("#find-month").val($("#select-list").val() + "-11");
		} else if ($(this).attr('id') == "December") {
			$("#find-month").val($("#select-list").val() + "-12");
		}
		document.redictToMonthPage.submit();
	});
	
});

function deletePlan(plan_id) {
	if ( confirm("确认删除该计划?") ) {
		$.ajax({
			type: "post",
			url: "deletePlan.action",
			data: {"plan_id" : plan_id}
		});
		location.reload(true);
	}
}

function getPlanById(plan_id) {
	this.plan_id = plan_id;
	$.ajax({
		type: "get",
		url: "getPlanById.action",
		data: {"plan_id" : plan_id},
		success:function(data) { // data是 Plan对象的JSON字符串,必须使用jackson依赖包于common-part中
			$("#plan-title-detail").val(data.plan_title);
			$("#plan-describe-detail").val(data.plan_describe);
			$("#plan-start-detail").val(data.plan_starting_time);
			$("#plan-end-detail").val(data.plan_ending_time);
			if (data.plan_status == 1) {
				$("#toDo-status").prop("checked",true);
			} else if (data.plan_status == 2) {
				$("#doing-status").prop("checked",true);
			} else if (data.plan_status == 3) {
				$("#done-status").prop("checked",true);
			} else if (data.plan_status == 4) {
				$("#failed-status").prop("checked",true);
			}
			
		}
	});
}

function redict1(){
	document.redictForm1.submit();
}
function redict2(){
	document.redictForm2.submit();
}
function redict3(){
	document.redictForm3.submit();
}
function redict4(){
	document.redictForm4.submit();
}
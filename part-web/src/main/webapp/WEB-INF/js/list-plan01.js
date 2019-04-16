function deletePlan(plan_id) {
    if ( confirm("确认删除该计划?") ) {
    	alert("删除成功!");
    }
}

$(function(){
	var i;
	
	// 注销
	$("#logout").click(function() {
		var ifLogout = confirm("确认注销？");
		if (ifLogout) {
			location.href="../home/logout";
		}
	});
	
	// 回到首页
	$("#toHomePage").click(function() {
		location.href="../home/homePage";
	});
	
	// 遍历计划描述
	for (i = 0; i < 10; i++) {
		_val = $(".plan_describe_" + i).text(); // 描述内容
		if(_val.length > 12) { // 若超过12截取前9个字符,后三个用...代替
			$(".plan_describe_" + i).html(_val.substring(0, 9) + "<span style='color:red'>...</span>");
		}
	}
	
	if ($(window).width() >= 1200) {
        $(".format").html("&nbsp;");
    }
	
	// 去到某页
	$("#go-page").click(function() {
		var find_page = parseInt($("#find-page").val());
		var page_total = parseInt($("#pageTotal").val());
		if(find_page <= page_total && find_page > 0){
			$("#otherPageNum").val($("#find-page").val());
			document.redictForm.submit();
		}
	});
	
});

// 上页下页首页尾页
function redict(pageNum){
	$("#otherPageNum").val(pageNum);
	document.redictForm.submit();
}
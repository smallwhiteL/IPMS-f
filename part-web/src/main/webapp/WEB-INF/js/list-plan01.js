function deletePlan(plan_id) {
    if ( confirm("确认删除该计划?") ) {
    }
}

$(function(){
	$("#logout").click(function() {
		var ifLogout = confirm("确认注销？");
		if (ifLogout) {
			location.href="../home/logout";
		}
	});
	
	$("#toHomePage").click(function() {
		location.href="../home/homePage";
	});
	
//	$(".plan_describe").each(function(){
//		_val = $(this).val(); // 详情内容
//		if(_val.length > 11) {
//			$(this).val(_val.substring(0, 8)); // 若超过12截取前9个字符
//		}
//	});
//	
//	$(".more").each(function(){
//		_val = $(".plan_describe").val(); // 详情内容
//		if(_val.length > 11) {
//			$(this).val("..."); // 若超过12第10,11,12位用...代替
//		}
//	});
	
});
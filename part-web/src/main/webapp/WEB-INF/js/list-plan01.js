function deletePlan(plan_id) {
    if ( confirm("确认删除该计划?") ) {
    	alert("删除成功!");
    }
}

$(function(){
	var i = 0;
	
	$("#logout").click(function() {
		var ifLogout = confirm("确认注销？");
		if (ifLogout) {
			location.href="../home/logout";
		}
	});
	
	$("#toHomePage").click(function() {
		location.href="../home/homePage";
	});
	
	$(".plan_describe").each(function(){
		_val = $(this).text(); // 详情内容
		if(_val.length > 12) {
			$(this).html(_val.substring(0, 9) + "<span style='color:red'>...</span>"); // 若超过12截取前9个字符,后三个用...代替
		}
	});
	
	if ($(window).width() >= 1200) {
        $(".format").html("&nbsp;");
    }
	
});
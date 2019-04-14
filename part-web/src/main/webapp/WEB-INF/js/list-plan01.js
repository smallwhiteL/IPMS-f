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
});
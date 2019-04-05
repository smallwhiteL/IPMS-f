$(function(){
	
	// 获取this-year
	$.ajax({
		type: "post",
		url: "getYear.action",
		success:function(data) {
			$("#select-list").append("<option selected='selected'>" + data + "</option>");
		}
	});
	
	// 后台获取本机IP地址
	var ipAddress;
	$.ajax({
		type: "post",
		url: "../common/getIpAddress.action",
		success:function(data) {
			ipAddress = data;
			var imagesPath = "http://" + ipAddress + ":8080/ipms/images/";
			
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
			
			var year = $("#select-list").val();
			for (var i = 1; i <= 10; i++) {
				var pastYear = parseInt($("#select-list").val()) - i;
				var futureYear = parseInt($("#select-list").val()) + i;
				$("#select-list").prepend("<option>" + pastYear + "</option>");
				$("#select-list").append("<option>" + futureYear + "</option>");
			}
			
			// 加载时判断生肖
			if (parseInt($("#select-list").val()) % 12 == 0) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/monkey.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 1) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/chicken.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 2) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/dog.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 3) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/pig.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 4) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/mouse.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 5) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/cattle.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 6) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/tiger.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 7) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/rabbit.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 8) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/dragon.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 9) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/snake.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 10) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/horse.svg");
			} else if (parseInt($("#select-list").val()) % 12 == 11) {
				$("#animal-year").attr("src", imagesPath + "symbolic-animals/sheep.svg");
			}
			
			// 改变下来菜单的生肖判断
			$("#select-list").bind("change", function() {
				if (parseInt($("#select-list").val()) % 12 == 0) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/monkey.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 1) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/chicken.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 2) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/dog.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 3) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/pig.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 4) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/mouse.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 5) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/cattle.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 6) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/tiger.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 7) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/rabbit.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 8) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/dragon.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 9) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/snake.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 10) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/horse.svg");
				} else if (parseInt($("#select-list").val()) % 12 == 11) {
					$("#animal-year").attr("src", imagesPath + "symbolic-animals/sheep.svg");
				}
			});
			
			$("#logout").click(function() {
				var ifLogout = confirm("确认注销？");
				if (ifLogout) {
					location.href="logout";
				}
			});
			
			$("#change-toggle").click(function() {
				if ($(window).width() >= 1200)
				{
					$('.plan-preview').animate({width:'toggle'},300);
					if ($('#toggle-pic').css("background-image") == 'url("' + imagesPath +'right-to-left.svg")') {
						$('#toggle-pic').css({"background-image" : "url(" + imagesPath + "left-to-right.svg)"});
						$('#toggle').animate({left:'0px'},300);
						// plan date list
						$('#year').animate({width:"98.1%"},300);
						$('#select-list').animate({width:"9%"},300);
						$('.month').animate({width:"20%"},300);
						$('#fourth').animate({"margin-left":"5%"},300);
						$('#seventh').animate({"margin-left":"5%"},300);
						$('#tenth').animate({"margin-left":"5%"},300);
						$('#first').animate({"margin-left":"3.5%"},300);
						$('#fifth').animate({"margin-left":"3.5%"},300);
						$('#ninth').animate({"margin-left":"3.5%"},300);
					}
					else if ($('#toggle-pic').css("background-image") == 'url("' + imagesPath + 'left-to-right.svg")') {
						$('#toggle-pic').css({"background-image" : "url(" + imagesPath + "right-to-left.svg)"});
						$("#toggle").animate({left:'30%'},300);
						// plan date list
						$('#year').animate({width:"67%"},300);
						$('#select-list').animate({width:"13%"},300);
						$('.month').animate({width:"30%"},300);
						$('#fourth').animate({"margin-left":"0"},300);
						$('#seventh').animate({"margin-left":"0"},300);
						$('#tenth').animate({"margin-left":"0"},300);
						$('#first').animate({"margin-left":"0%"},300);
						$('#fifth').animate({"margin-left":"5%"},300);
						$('#ninth').animate({"margin-left":"5%"},300);
					}
				}
				else {
					$('.plan-preview').animate({height: 'toggle'},500);
					if ($('#toggle-pic').css("background-image") == 'url("' + imagesPath + 'bottom-to-top.svg")') {
						$('#toggle-pic').css({"background-image" : "url(" + imagesPath + "top-to-bottom.svg)"});
					}
					else if ($('#toggle-pic').css("background-image") == 'url("' + imagesPath + 'top-to-bottom.svg")') {
						$('#toggle-pic').css({"background-image" : "url(" + imagesPath + "bottom-to-top.svg)"});
					}
				}
			});
		}
	});
	
});
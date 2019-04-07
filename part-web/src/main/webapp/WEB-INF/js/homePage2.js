$(function(){ 

    // 点击修改,激活所有修改项
    $("#update").click(function(){
        if ($(this).html() == "修改") {
            $("#plan-title-detail").removeAttr("readonly");
            $("#plan-describe-detail").removeAttr("readonly");
            $("#plan-start-detail").removeAttr("disabled");
            $("#plan-end-detail").removeAttr("disabled");
            $("#toDo-status").removeAttr("disabled");
            $("#doing-status").removeAttr("disabled");
            $("#done-status").removeAttr("disabled");
            $("#failed-status").removeAttr("disabled");
            $(this).html("完成");
        }
        else if ($(this).html() == "完成") {
            $("#plan-title-detail").attr("readonly", "readonly");
            $("#plan-describe-detail").attr("readonly", "readonly");
            $("#plan-start-detail").attr("disabled", "disabled");
            $("#plan-end-detail").attr("disabled", "disabled");
            $("#toDo-status").attr("disabled", "disabled");
            $("#doing-status").attr("disabled", "disabled");
            $("#done-status").attr("disabled", "disabled");
            $("#failed-status").attr("disabled", "disabled");
            $("#plan-detail").modal('hide');
            $(this).html("修改");
            alert("修改成功!")
        }
    });

    $("#cancel-update").click(function(){
        if ($("#update").html() == "完成") {
            $("#plan-title-detail").attr("readonly", "readonly");
            $("#plan-describe-detail").attr("readonly", "readonly");
            $("#plan-start-detail").attr("disabled", "disabled");
            $("#plan-end-detail").attr("disabled", "disabled");
            $("#toDo-status").attr("disabled", "disabled");
            $("#doing-status").attr("disabled", "disabled");
            $("#done-status").attr("disabled", "disabled");
            $("#failed-status").attr("disabled", "disabled");
            $("#plan-detail").modal('hide');
            $("#update").html("修改");
        }
    });

    $(".cancel-add").click(function(){
        $("#plan-title").val("");
        $("#plan-describe").val("");
        $("#plan-start").val("");
        $("#plan-end").val("");
    });
});
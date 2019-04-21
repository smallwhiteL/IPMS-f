// ===============================
// 定义全局变量

// 账号相关元素
var usernameInput;
var usernameSpan;
var usernameRepeatButton;

// 密码相关元素
var passwordInput;
var passwordSpan;
var passwordConfirmInput;
var passwordConfirmSpan

// 名字相关元素
var nameInput;
var nameSpan;

// 性别单选按钮中的checked属性
var sexRadioMen;
var sexRadioWoMen;

// 出生日期元素
var birthdayInput;

// 关闭按钮相关元素
var closeButton;

// 注册按钮
var registerButton;
// 注册提示
var registerSpan;

// 判断表单填写是否完整且符合格式的标志
var usernameFlag;
var passwordFlag;
var passwordConfirmFlag;
var nameFlag;
var sexFlag;
var birthdayFlag;

// ===============================
// 页面加载时所做的处理
$(function(){
    // 绑定账号输入框
    usernameInput = $("#register-username");
    // 绑定账号提示span
    usernameSpan = $("#check_username");
    // 绑定查看是否可用的按钮
    usernameRepeatButton = $("#check_repeat");
    
    // 密码及确认密码的相关元素的绑定
    passwordInput = $("#register-password");
    passwordSpan = $("#check_password");
    passwordConfirmInput = $("#register-password-confirm");
    passwordConfirmSpan = $("#check_password_confirm");

    // 名字相关元素的绑定
    nameInput = $("#name");
    nameSpan = $("#check_name");

    // 性别单选按钮的绑定
    sexRadioMen = $("#men");
    sexRadioWoMen = $("#women");

    // 出生日期元素的绑定
    birthdayInput = $("#birthday");

    // 关闭按钮的绑定
    closeButton = $(".closeAndClear")

    // 注册按钮的绑定
    registerButton = $("#register");

    // 注册提示元素绑定
    registerSpan = $("#checkAll");
    
    // 页面加载时调整几个input项的格式
    usernameInput.css({"font-size": "25px", "height": "37px"});
    passwordInput.css({"font-size": "25px", "height": "37px"});
    passwordConfirmInput.css({"font-size": "25px", "height": "37px"});
    nameInput.css({"font-size": "25px", "height": "37px"});
    birthdayInput.css({"font-size": "25px", "height": "37px"});
    
    // 绑定所有input相关事件
    check_username();
    check_password();
    check_name();

    // 关闭按钮清除数据触发的函数
    closeAndClear();

    // 注册验证
    registerCheck();
});

// ===============================
// 账号输入相关处理
function check_username() {
    
    usernameFlag = false;
    // 账号输入框失去焦点的处理
    usernameInput.on("blur", function() {
        if (usernameInput.val() == "") {
            usernameSpan.html("账号不能为空!");
            usernameSpan.css({"color":"red"});
            usernameRepeatButton.css({"display": "none"});
            usernameFlag = false;
        }
        else if ( !usernameRegExpCheck(usernameInput.val()) ) {
            usernameFlag = false;
        }
        else {
        	$.ajax({
        		type: "post",
        		url: "loginAndRegister/checkRepeat.action",
        		data: {
        			"check_username" : usernameInput.val(),
        		},
        		success:function(data) {
        			if (data == "exist") {
        	            usernameFlag = false;
        			}
        			else {
        				usernameFlag = true;
        			}
        		}
        	});
        }
    });
    
    // 点击按钮的处理
    usernameRepeatButton.click(function() {
        if ( usernameInput.val() == "") {
            usernameSpan.html("账号不能为空!");
            usernameSpan.css({"color":"red"});
            usernameRepeatButton.css({"display": "none"});
        }
        else if ( !usernameRegExpCheck(usernameInput.val()) ) {
            usernameSpan.html("必须是字母或数字,最少6位!");
            usernameSpan.css({"color":"red"});
            usernameRepeatButton.css({"display": "none"});
        }
        else {
        	$.ajax({
        		type: "post",
        		url: "loginAndRegister/checkRepeat.action",
        		data: {
        			"check_username" : usernameInput.val(),
        		},
        		success:function(data) {
        			if (data == "exist") {
        				usernameSpan.html("账号已存在!");
        	            usernameSpan.css({"color":"red"});
        	            usernameRepeatButton.css({"display": "none"});
        			}
        			else {
        				usernameSpan.html("恭喜你,可用!");
        				usernameSpan.css({"color":"green"});
        				usernameRepeatButton.css({"display": "none"});
        			}
        		}
        	});
        }
    });
    
    // 按键并放开键盘后的处理
    usernameInput.keyup(function() {
        usernameSpan.html("");
        usernameRepeatButton.css({"display": "inline-block"});
    });
}

// 正则表达式限定账号输入格式 只能为字母或数字且最少为6位
function usernameRegExpCheck (value) {
    var usernameReg = /^[A-Za-z0-9]{6,}$/;
    if (usernameReg.test(value)) {
        return true;
    }
    return false;
}

// ===============================
// 密码及密码确认输入相关处理
function check_password() {

    passwordFlag = false;
    passwordConfirmFlag = false;
    // 密码输入框失去焦点的处理
    passwordInput.blur(function() {
        if (passwordInput.val() == "") {
            passwordSpan.html("密码不能为空!");
            passwordFlag = false;
        }
        else if ( passwordInput.val().length < 6 ) {
            passwordSpan.html("密码最少6位!");
            passwordFlag = false;
        }
        else {
            if ( passwordInput.val() != "" && passwordConfirmInput.val() != passwordInput.val() ) {
                passwordSpan.html("");
                passwordConfirmSpan.html("两次输入的密码不一致!");
                passwordConfirmFlag = false;
            }
            else {
                passwordConfirmFlag = true;
                passwordSpan.html("");
                passwordConfirmSpan.html("");
            }
            passwordFlag = true;
        }
    });

    // 确认密码输入框失去焦点的处理
    passwordConfirmInput.blur(function() {
        if ( passwordConfirmInput.val() != passwordInput.val()) {
            passwordConfirmSpan.html("两次输入的密码不一致!")
            passwordConfirmFlag = false;
        }
        else {
            passwordConfirmFlag = true;
            passwordConfirmSpan.html("");
        }
    });
}

// ===============================
// 名字输入相关处理
function check_name() {

    nameFlag = false;
    // 密码输入框失去焦点的处理
    nameInput.blur(function() {
        if (nameInput.val() == "") {
            nameSpan.html("名字不能为空!");
            nameFlag = false;
        }
        else {
            nameFlag = true;
            nameSpan.html("");
        }
    });
}

// ===============================
// 性别与出生日期相关处理 主要为了设置注册是否完整的标记
function sexRadioAndBirthday() {
    
    sexFlag = false;
    birthdayFlag = false;
    if (sexRadioMen.prop("checked") || sexRadioWoMen.prop("checked")) {
        sexFlag = true;
    }
    if (birthdayInput.val() != "")
    {
        birthdayFlag = true;
    }

}

// ===============================
// 关闭后清除输入的信息 并将标签重置
function closeAndClear() {

    closeButton.click(function() {
        
        usernameFlag = false;
        passwordFlag = false;
        passwordConfirmFlag = false;
        nameFlag = false;
        sexFlag = false;
        birthdayFlag = false;

        $(".adjustment2").html("");
        usernameRepeatButton.css({"display": "inline-block"});
        usernameInput.val("");
        passwordInput.val("");
        passwordConfirmInput.val("");
        nameInput.val("");
        $("input[type='radio']").prop("checked", false);
        birthdayInput.val("");
        registerSpan.css({"display" : "none"});
    })

}

// ===============================
// 注册验证
function registerCheck() {
    registerButton.click(function() {
    	
        sexRadioAndBirthday();
        if (usernameFlag && passwordFlag && passwordConfirmFlag && nameFlag && sexFlag && birthdayFlag) {
        	// 提交数据给后台
        	$.ajax({
        		type: "post",
        		url: "loginAndRegister/register.action",
        		data: {
        			"register_username" : usernameInput.val(),
        			"register_password" : passwordInput.val(),
        			"register_name" : nameInput.val(),
        			"register_sex" : $('input:radio:checked').val(),
        			"register_birthday" : birthdayInput.val()
        		},
        		success:function() {
        			alert("恭喜你注册成功!");
        			$("#myModal").modal('hide');
        			usernameFlag = false;
        			passwordFlag = false;
        			passwordConfirmFlag = false;
        			nameFlag = false;
        			sexFlag = false;
        			birthdayFlag = false;
        			
        			$(".adjustment2").html("");
        			usernameRepeatButton.css({"display": "inline-block"});
        			usernameInput.val("");
        			passwordInput.val("");
        			passwordConfirmInput.val("");
        			nameInput.val("");
        			$("input[type='radio']").prop("checked", false);
        			birthdayInput.val("");
        			registerSpan.css({"display" : "none"});
        		}
        	});
        }
        else {
            registerSpan.css({
                "line-height" : "35px",
                "height" : "37px",
                "font-size" : "20px",
                "font-weight" : "bold",
                "color" : "red",
                "margin-left" : "15px",
                "display" : "inline"
            });
            if ( !usernameFlag ) {
                registerSpan.html("请检查账号!");
            }
            else if ( !passwordFlag || !passwordConfirmFlag ) {
                registerSpan.html("请检查密码!");
            }
            else if ( !nameFlag ) {
                registerSpan.html("请输入名字!");
            }
            else if ( !sexFlag ) {
                registerSpan.html("请选择性别!");
            }
            else if ( !birthdayFlag ) {
                registerSpan.html("请选择出生日期!");
            }
        }
    })
}
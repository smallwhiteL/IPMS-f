<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>

<!-- Own Javascript -->
<script src="${pageContext.request.contextPath}/js/registerJS.js"></script>

</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document" style="width: 800px">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close closeAndClear" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title adjustment1" id="myModalLabel"
				style="color: blue">用户注册</h4>
			</div>
		  	<div class="modal-body">
				<!-- 账号 -->
				<div class="form-group">
						<label for="register-username" class="col-xs-3 control-label adjustment1">账号</label>
						<div class="col-xs-6">
							<input type="text" class="form-control " id="register-username"
							placeholder="请输入账号" name="register-username"  maxlength="20">
						</div>
						<div class="col-xs-3">
							<a class="btn btn-info" style="font-size: 17px; margin-left: -10px"
							id="check_repeat">
								是否可用
							</a>
							<span id="check_username" class="adjustment2"></span>
						</div>
				</div>
				<br><br>
				<!-- 密码 -->
				<div class="form-group">
					<label for="register-password" class="col-xs-3 control-label adjustment1">密码</label>
					<div class="col-xs-6">
						<input type="password" class="form-control" id="register-password"
						placeholder="请输入密码" name="register-password" maxlength="20">
					</div>
					<div class="col-xs-3">
						<span id="check_password" class="adjustment2"></span>
					</div>
				</div>
				<br><br>
				<!-- 确认密码 -->
				<div class="form-group">
					<label for="register-password-confirm" class="col-xs-3 control-label adjustment1">确认密码</label>
					<div class="col-xs-6">
						<input type="password" class="form-control" id="register-password-confirm"
						placeholder="请确认密码" name="register-password-confirm" maxlength="20">
					</div>
					<div class="col-xs-3">
						<span id="check_password_confirm" class="adjustment2"></span>
					</div>
				</div>
				<br><br>
				<!-- 名字 -->
				<div class="form-group">
					<label for="name" class="col-xs-3 control-label adjustment1">名字</label>
					<div class="col-xs-6">
						<input type="text" class="form-control" id="name" placeholder="请输入名字"name="name" 
						maxlength="20">
					</div>
					<div class="col-xs-3">
						<span id="check_name" class="adjustment2"></span>
					</div>
				</div>
				<br><br>
				<!-- 性别 -->
				<div class="form-group">
					<label class="col-xs-3 control-label adjustment1">性别</label>
					<div class="col-xs-1">
						<label class="radio-inline" style="font-size: 25px; height: 37px;">
							<input type="radio" id="men" name="sex" value="男"
							style="height: 20px; width: 20px; margin-top: 8px" class="form-control">男
						</label>
					</div>
					<div class="col-xs-1" >
						<label class="radio-inline" style="font-size: 25px; height: 37px;">
							<input type="radio" id="women" name="sex" value="女"
							style="height: 20px; width: 20px; margin-top: 8px" class="form-control">女
						</label>
					</div>
				</div>
				<br><br>
				<!-- 出生日期 -->
				<div class="form-group">
					<label for="birthday" class="col-xs-3 control-label adjustment1">出生日期</label>
					<div class="col-xs-6">
						<input type="date" name="birthday" class="form-control" id="birthday">
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-xs-offset-3 col-xs-3">
					<span id="checkAll"></span>
				</div>
			</div>
			<br>
			<div style="text-align:center">
				<a class="btn btn-danger closeAndClear" data-dismiss="modal" style="font-size: 25px">关闭</a>
				<span style="white-space:pre">                             </span>
				<a class="btn btn-primary" style="font-size: 25px" id="register">注册</a>
			</div>
		</div>
	  </div>
	</div>
</body>
</html>

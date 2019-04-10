<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>计划详情及修改</title>

</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="plan-detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
         <div class="modal-dialog" role="document">
             <div class="modal-content" style="font-size:20px;">
                 <div class="modal-header">
                 <button type="button" class="close cancel-update" data-dismiss="modal" aria-label="Close">
                 	<span aria-hidden="true">&times;</span>
           		 </button>
                 <h4 class="modal-title">
                     <input type="text" class="form-control" id="plan-title-detail"
                      style="font-size:1.2em" placeholder="计划标题" maxlength="30" readonly>
                 </h4>
                 </div>
                 <div class="modal-body">
                     <div class="form-group">
                         <textarea class="form-control" id="plan-describe-detail" placeholder="计划描述"
                          style="font-size:1.1em;height: 250px;" readonly></textarea>
                     </div>
                     <div class="form-group">
                         开始时间:
                         <input type="date" class="form-control" id="plan-start-detail" style="font-size:1.1em" disabled>
                     </div>
                     <div class="form-group">
                         截止时间:
                         <input type="date" class="form-control" id="plan-end-detail" style="font-size:1.1em" disabled>
                     </div>
                     <div class="form-group">
                         <label class="control-label adjustment1">状态:</label><br>
                         <label class="radio-inline" style="height: 37px; color: blue">
                             <input type="radio" value="1" name="status" id="toDo-status"
                             style="height: 20px; width: 20px; margin-top: 8px" class="form-control" disabled>
                             未开始
                         </label>
                         <label class="radio-inline" style="height: 37px; color: yellow">
                             <input type="radio" value="2" name="status" id="doing-status"
                             style="height: 20px; width: 20px; margin-top: 8px" class="form-control" disabled>
                             进行中
                         </label>
                         <label class="radio-inline" style="height: 37px; color: green">
                             <input type="radio" value="3" name="status" id="done-status"
                             style="height: 20px; width: 20px; margin-top: 8px" class="form-control" disabled>
                             已结束
                         </label>
                         <label class="radio-inline" style="height: 37px; color: red">
                             <input type="radio" value="4" name="status" id="failed-status"
                             style="height: 20px; width: 20px; margin-top: 8px" class="form-control" disabled>
                             已逾期
                         </label>
                     </div>
                     <div class="form-group" style="color:red" id="edit-tips"></div>
                 </div>
                 <div class="modal-footer">
                 <button type="button" class="btn btn-default cancel-update" data-dismiss="modal">取消</button>
                 <button type="button" class="btn btn-primary" id="update">修改</button>
                 </div>
             </div>
         </div>
     </div>
</body>
</html>

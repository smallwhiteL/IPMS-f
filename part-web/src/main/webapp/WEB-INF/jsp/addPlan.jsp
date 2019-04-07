<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加任务</title>

</head>
<body>
	<!-- Modal -->
    <div class="modal fade" id="addPlanModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
        <div class="modal-content" style="font-size:1.3em;">
            <div class="modal-header">
            <button type="button" class="close cancel-add" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">
                <input type="text" class="form-control" id="plan-title" style="font-size:1.2em" placeholder="计划标题" maxlength="30">
            </h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <textarea class="form-control" id="plan-describe" placeholder="计划描述" style="font-size:1.2em;height: 250px;"></textarea>
                </div>
                <div class="form-group">
                    开始时间:
                    <input type="date" class="form-control" id="plan-start" style="font-size:1.2em">
                </div>
                <div class="form-group">
                    截止时间:
                    <input type="date" class="form-control" id="plan-end" style="font-size:1.2em">
                </div>
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default cancel-add" data-dismiss="modal">关闭</button>
            <button type="button" class="btn btn-primary">添加</button>
            </div>
        </div>
        </div>
    </div>
</body>
</html>

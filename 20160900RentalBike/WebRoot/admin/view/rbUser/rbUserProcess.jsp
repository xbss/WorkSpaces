<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- 增加用户 USER -->
<div class="modal fade" id="modal_add" tabindex="-1" role="dialog"
	aria-labelledby="addUserModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="addUserModalLabel">新增</h4>
			</div>
			<div class="modal-body">
				<form action="" id="form_add" class="form-horizontal">
					<div class="form-group ">
                        <label for="userName" class="col-sm-2 control-label input-sm">姓名</label>
                        <div class="col-sm-10">
                              <input type="text" id="userName" name="userName" placeholder="" class=" form-control input-sm" required data-msg-required="不能为空">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sex" class="col-sm-2  control-label input-sm" >性别</label>
                        <div class="col-sm-10">
                            <select  id="sex" name="sex" class="form-control input-sm" required>
                            <option value="0">男</option>
                            <option value="1">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="age" class="col-sm-2  control-label input-sm"  >年龄</label>
                        <div class="col-sm-10">
                            <input type="text" id="age" name="age" placeholder="" class=" form-control input-sm" required >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="userState" class="col-sm-2  control-label input-sm" >状态</label>
                        <div class="col-sm-10">
                            <select  id="userState" name="userState" class="form-control input-sm" required>
                            <option value="0">禁用</option>
                            <option value="1">启用</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobileNumber" class="col-sm-2  control-label input-sm"  >手机号</label>
                        <div class="col-sm-10">
                            <input type="text" id="mobileNumber" name="mobileNumber" placeholder="" class=" form-control input-sm" required >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2  control-label input-sm"  >邮箱地址</label>
                        <div class="col-sm-10">
                            <input type="text" id="email" name="email" placeholder="" class=" form-control input-sm" required >
                        </div>
                    </div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn button-primary"
					data-dismiss="modal">关闭</button>
				<button onclick="f_add()" type="button" class="btn button-primary">提交</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>
<!-- ***************************************************************************************************************************************** -->
<!-- 编辑 editUSER -->
<div class="modal fade" id="modal_edit" tabindex="-1" role="dialog"
	aria-labelledby="editUserModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="editUserModalLabel">修改</h4>
			</div>
			<div class="modal-body">
                <form action="" id="form_edit" class="form-horizontal">
                    <div class="form-group ">
                        <label for="userName" class="col-sm-2 control-label input-sm">姓名</label>
                        <div class="col-sm-10">
                              <input type="text" id="userName" name="userName" placeholder="" class=" form-control input-sm" required data-msg-required="不能为空">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sex" class="col-sm-2  control-label input-sm" >性别</label>
                        <div class="col-sm-10">
                            <select  id="sex" name="sex" class="form-control input-sm" required>
                            <option value="0">男</option>
                            <option value="1">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="age" class="col-sm-2  control-label input-sm"  >年龄</label>
                        <div class="col-sm-10">
                            <input type="text" id="age" name="age" placeholder="" class=" form-control input-sm" required >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="userState" class="col-sm-2  control-label input-sm" >状态</label>
                        <div class="col-sm-10">
                            <select  id="userState" name="userState" class="form-control input-sm" required>
                            <option value="0">禁用</option>
                            <option value="1">启用</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobileNumber" class="col-sm-2  control-label input-sm"  >手机号</label>
                        <div class="col-sm-10">
                            <input type="text" id="mobileNumber" name="mobileNumber" placeholder="" class=" form-control input-sm" required >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2  control-label input-sm"  >邮箱地址</label>
                        <div class="col-sm-10">
                            <input type="text" id="email" name="email" placeholder="" class=" form-control input-sm" required >
                        </div>
                    </div>
                    <!-- 隐藏域 -->
                    <input id="userId"  name="userId" type="hidden" >
                </form>
            </div>
			<div class="modal-footer">
				<button type="button" class="btn button-primary"
					data-dismiss="modal">关闭</button>
				<button type="button" onclick="btn_editSubmit()"
					class="btn button-primary">提交</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>
<!-- ****************************************************************************************************************************************** -->
<!-- 一级弹窗-修改密码 -->
<div class="modal fade" id="modal_editPassword" tabindex="-1" role="dialog"
    aria-labelledby="editUserModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="editUserModalLabel">修改密码</h4>
            </div>
            <div class="modal-body">
                <form id="form_editPassword" action="" class="form-horizontal">
                    <div class="form-group ">
                        <label for="new_password" class="col-sm-2 control-label input-sm">新密码</label>
                        <div class="col-sm-10">
                              <input type="password" id="new_password" name="password" placeholder="" class=" form-control input-sm"  required data-msg-required="不能为空">
                        </div>
                    </div>
                    <div class="form-group ">
                        <label for="comPassword" class="col-sm-2 control-label input-sm">确认密码</label>
                        <div class="col-sm-10">
                              <input type="password" id="comPassword" name="comPassword" placeholder="" class=" form-control input-sm"  required equalTo="#new_password">
                        </div>
                    </div>
                    <!-- 隐藏域 -->
                    <input type="hidden" id="userId" name="userId">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn button-primary"
                    data-dismiss="modal">关闭</button>
                <button type="button" onclick="btn_editPasswordSubmit()"
                    class="btn button-primary">提交</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<!-- ***************************************************************************************************************************************** -->
<!-- 二级弹窗-选择厂库 -->
<div class="modal fade" id="modal_selectStorage" tabindex="-1" role="dialog"
    aria-labelledby="editUserModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="editUserModalLabel">选择仓库</h4>
            </div>
            <div class="modal-body">
                <table id="table_selectStorage" data-click-to-select="true" ></table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn button-primary"
                    data-dismiss="modal">关闭</button>
                <button type="button" onclick="btn_selectStorage()"
                    class="btn button-primary">提交</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

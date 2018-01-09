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
                    <div class="form-group">
                        <label for="address" class="col-sm-2  control-label input-sm" >地址</label>
                        <div class="col-sm-10">
                            <input type="text" id="address" name="address" placeholder="" class=" form-control input-sm" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="state" class="col-sm-2  control-label input-sm" >状态</label>
                        <div class="col-sm-10">
                            <select  id="state" name="state" class="form-control input-sm" required>
                            <option value="0">禁用</option>
                            <option value="1">启用</option>
                            </select>
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="information" class="col-sm-2  control-label input-sm" >具体信息</label>
                        <div class="col-sm-10">
                            <textarea id="information" name="information"  class="form-control input-sm" rows="3"></textarea>
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
                     <div class="form-group">
                        <label for="address" class="col-sm-2  control-label input-sm" >地址</label>
                        <div class="col-sm-10">
                            <input type="text" id="address" name="address" placeholder="" class=" form-control input-sm" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="state" class="col-sm-2  control-label input-sm" >状态</label>
                        <div class="col-sm-10">
                            <select  id="state" name="state" class="form-control input-sm" required>
                            <option value="0">禁用</option>
                            <option value="1">启用</option>
                            </select>
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="information" class="col-sm-2  control-label input-sm" >具体信息</label>
                        <div class="col-sm-10">
                            <textarea id="information" name="information"  class="form-control input-sm" rows="3"></textarea>
                        </div>
                    </div>  
                    <!-- 隐藏域 -->
                    <input id="storageId"  name="storageId" type="hidden" >
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

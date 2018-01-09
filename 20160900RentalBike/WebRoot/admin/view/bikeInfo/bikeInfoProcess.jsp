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
                        <label for="price" class="col-sm-2 control-label input-sm">租车价格</label>
                        <div class="col-sm-10">
                              <input type="text" id="price" name="price" placeholder="" class=" form-control input-sm" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="state" class="col-sm-2  control-label input-sm" >车辆状态</label>
                        <div class="col-sm-10">
                            <select  id="state" name="state" class="form-control input-sm" required>
                            <option value="0">禁用</option>
                            <option value="1">启用</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="rentalState" class="col-sm-2  control-label input-sm" >租借状态</label>
                        <div class="col-sm-10">
                            <select  id="rentalState" name="rentalState" class="form-control input-sm" required>
                            <option value="0">未租借</option>
                            <option value="1">使用中</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for=storageName class="col-sm-2  control-label input-sm" >所属仓库</label>
                        <div class="col-sm-7">
                            <input type="text" id="storageName" name="storageName" placeholder="" class=" form-control input-sm">
                            <input type="hidden" id="storageId" name="storageId" >
                        </div>
                        <div class="col-sm-3">
                            <button onclick="btn_selectStorageLoad()"  type="button" data-toggle="modal" data-target="#modal_selectStorage"  class="btn ">选择仓库</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for=bikeTypeName class="col-sm-2  control-label input-sm" >车型</label>
                        <div class="col-sm-7">
                            <input type="text" id="bikeTypeName" name="bikeTypeName" placeholder="" class=" form-control input-sm">
                            <input type="hidden" id="bikeTypeId" name="bikeTypeId" >
                        </div>
                        <div class="col-sm-3">
                            <button onclick="btn_selectBikeTypeLoad()"  type="button" data-toggle="modal" data-target="#modal_selectBikeType"  class="btn ">选择车型</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="appearanceInfo" class="col-sm-2  control-label input-sm" >外观信息</label>
                        <div class="col-sm-10">
                            <textarea id="appearanceInfo" name=appearanceInfo  class="form-control input-sm" rows="3"></textarea>
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
                        <label for="price" class="col-sm-2 control-label input-sm">租车价格</label>
                        <div class="col-sm-10">
                              <input type="text" id="price" name="price" placeholder="" class=" form-control input-sm" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="state" class="col-sm-2  control-label input-sm" >车辆状态</label>
                        <div class="col-sm-10">
                            <select  id="state" name="state" class="form-control input-sm" required>
                            <option value="0">禁用</option>
                            <option value="1">启用</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="rentalState" class="col-sm-2  control-label input-sm" >租借状态</label>
                        <div class="col-sm-10">
                            <select  id="rentalState" name="rentalState" class="form-control input-sm" required>
                            <option value="0">未租借</option>
                            <option value="1">使用中</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for=storageName class="col-sm-2  control-label input-sm" >所属仓库</label>
                        <div class="col-sm-7">
                            <input type="text" id="storageName" name="storageName" placeholder="" class=" form-control input-sm">
                            <input type="hidden" id="storageId" name="storageId" >
                        </div>
                        <div class="col-sm-3">
                            <button onclick="btn_selectStorageLoad()"  type="button" data-toggle="modal" data-target="#modal_selectStorage"  class="btn ">选择仓库</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for=bikeTypeName class="col-sm-2  control-label input-sm" >车型</label>
                        <div class="col-sm-7">
                            <input type="text" id="bikeTypeName" name="bikeTypeName" placeholder="" class=" form-control input-sm">
                            <input type="hidden" id="bikeTypeId" name="bikeTypeId" >
                        </div>
                        <div class="col-sm-3">
                            <button onclick="btn_selectBikeTypeLoad()"  type="button" data-toggle="modal" data-target="#modal_selectBikeType"  class="btn ">选择车型</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="appearanceInfo" class="col-sm-2  control-label input-sm" >外观信息</label>
                        <div class="col-sm-10">
                            <textarea id="appearanceInfo" name=appearanceInfo  class="form-control input-sm" rows="3"></textarea>
                        </div>
                    </div>
                    <!-- 隐藏域 -->
                    <input id="bikeId"  name="bikeId" type="hidden" >
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

<!-- ***************************************************************************************************************************************** -->
<!-- 二级弹窗-选择选择车型 -->
<div class="modal fade" id="modal_selectBikeType" tabindex="-1" role="dialog"
    aria-labelledby="editUserModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="editUserModalLabel">选择车型</h4>
            </div>
            <div class="modal-body">
                <table id="table_selectBikeType" data-click-to-select="true" ></table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn button-primary"
                    data-dismiss="modal">关闭</button>
                <button type="button" onclick="btn_selectBikeType()"
                    class="btn button-primary">提交</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

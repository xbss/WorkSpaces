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
                        <label for="price" class="col-sm-2 control-label input-sm">购买价格</label>
                        <div class="col-sm-10">
                              <input type="text" id="price" name="price" placeholder="" class=" form-control input-sm" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bikeTypeName" class="col-sm-2  control-label input-sm" >车型名称</label>
                        <div class="col-sm-10">
                            <input type="text" id="bikeTypeName" name="bikeTypeName" placeholder="" class=" form-control input-sm" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for=supplierName class="col-sm-2  control-label input-sm" >供应商</label>
                        <div class="col-sm-7">
                            <input type="text" id="supplierName" name="supplierName" placeholder="" class=" form-control input-sm">
                            <input type="hidden" id="supplierId" name="supplierId" >
                        </div>
                        <div class="col-sm-3">
                            <button onclick="btn_selectSupplierLoad()"  type="button" data-toggle="modal" data-target="#modal_selectSupplier"  class="btn ">选择供应商</button>
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
                        <label for="price" class="col-sm-2 control-label input-sm">购买价格</label>
                        <div class="col-sm-10">
                              <input type="text" id="price" name="price" placeholder="" class=" form-control input-sm" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bikeTypeName" class="col-sm-2  control-label input-sm" >车型名称</label>
                        <div class="col-sm-10">
                            <input type="text" id="bikeTypeName" name="bikeTypeName" placeholder="" class=" form-control input-sm" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for=supplierName class="col-sm-2  control-label input-sm" >供应商</label>
                        <div class="col-sm-7">
                            <input type="text" id="supplierName" name="supplierName" placeholder="" class=" form-control input-sm">
                            <input type="hidden" id="supplierId" name="supplierId" >
                        </div>
                        <div class="col-sm-3">
                            <button onclick="btn_selectSupplierLoad()"  type="button" data-toggle="modal" data-target="#modal_selectSupplier"  class="btn ">选择供应商</button>
                        </div>
                    </div>
                    <!-- 隐藏域 -->
                    <input id="bikeTypeId"  name="bikeTypeId" type="hidden" >
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
<!-- 二级弹窗-选择选择车型 -->
<div class="modal fade" id="modal_selectSupplier" tabindex="-1" role="dialog"
    aria-labelledby="editUserModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="editUserModalLabel">选择供应商</h4>
            </div>
            <div class="modal-body">
                <table id="table_selectSupplier" data-click-to-select="true" ></table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn button-primary"
                    data-dismiss="modal">关闭</button>
                <button type="button" onclick="btn_selectSupplier()"
                    class="btn button-primary">提交</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

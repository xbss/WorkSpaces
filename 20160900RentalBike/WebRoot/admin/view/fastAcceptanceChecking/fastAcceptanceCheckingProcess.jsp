<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- ***************************************************************************************************************************************** -->
<!-- 结算验收车辆 -->
<div class="modal fade" id="modal_check" tabindex="-1" role="dialog"
	aria-labelledby="checkUserModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="checkUserModalLabel">验收</h4>
			</div>
			<div class="modal-body">
                <form action="" id="form_check" class="form-horizontal">
                     <div class="form-group">
                        <label for="damage" class="col-sm-2  control-label input-sm" >损坏</label>
                        <div class="col-sm-10">
                            <select  id="damage" name="damage" class="form-control input-sm" required>
                            <option value="0">无</option>
                            <option value="1">有</option>
                            </select>
                        </div>
                    </div>
                    <!-- 隐藏域 -->
                    <input id="rentalId"  name="rentalId" type="hidden" >
                </form>
            </div>
			<div class="modal-footer">
				<button type="button" class="btn button-primary"
					data-dismiss="modal">关闭</button>
				<button type="button" onclick="btn_checkSubmit()"
					class="btn button-primary">提交</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>

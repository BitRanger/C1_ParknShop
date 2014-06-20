<%--
  Created by IntelliJ IDEA.
  User: Kaidi
  Date: 6/6/2014
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="modal fade" id="newAddress" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog" style="width: 640px">
		<div id="confirmAdd_main" class="modal-content">
			<div id="confirmAdd_main_head" class="modal-header">
				<button type="button" class="close" id="confirmAdd_main_close_btn"
					data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="confirmAdd_main_head_title">Add New
					Address</h4>
			</div>
			<div id="confirmAdd_main_body" class="modal-body">
				<form id="confirmAddr_div"
					action="<%=request.getContextPath()%>/addRecipient">
					<div id="confirmAddr_district">
						<label style="margin-top: 5px" class="common_label left">District</label>
						<div class="left">
							<select class="select" name="province" id="s1">
								<option></option>
							</select> <select class="select" name="city" id="s2">
								<option></option>
							</select> <select class="select" name="town" id="s3">
								<option></option>
							</select><br>
						</div>
					</div>
					<div>
						<label class="common_label">Zip Code</label> <input
							class="common_input" type="text" name="zipcode">
					</div>
					<div>
						<label class="common_label">Street</label>
						<textarea id="confirmAddr_street" name="street"
							placeholder="No need to write district again, just street, no more than 200 characters"></textarea>
					</div>
					<div>
						<label class="common_label">Receiver</label> <input
							class="common_input" type="text" name="receiver"
							placeholder="no more than 50 characters">
					</div>
					<div>
						<label class="common_label">PhoneNum</label> <input
							class="common_input" type="text" name="phonenum">
					</div>
					<div style="margin-left: 95px">
						<input id="comfirm_addAddressBtn" class="common_btn" type="submit"
							name="confirm" value="confirm">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
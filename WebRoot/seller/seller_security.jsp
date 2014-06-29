<%--
  Created by IntelliJ IDEA.
  User: Kaidi
  Date: 5/31/2014
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<div id="security_content">
	<form action="changePassword" method="post" id="security_form">
		<div>
			<p>
				<a href="#">Change your password</a>
			</p>
			<div>
				<label class="basicInfo_label" style="width: 100px">OldPassword</label> <input
					class="basicInfo_input" type="password" name="oldPassword"
					id="oldPassword">
			</div>

			<div>
				<label class="basicInfo_label" style="width: 100px">NewPassword</label> <input
					class="basicInfo_input" type="password" name="newPassword"
					id="newPassword">
			</div>

			<div>
				<label class="basicInfo_label" style="width: 100px">ConfirmPassword</label> <input
					class="basicInfo_input" type="password" name="confirmPassword"
					id="confirmPassword">
			</div>

			<div style="margin-left: 115px; margin-top: 30px">
				<input style="width: 80px" class="common_btn" value="Confirm"
					type="button" id="passwordConfirmBtn">
			</div>

		</div>
	</form>
</div>
<fieldset>
	<legend>User Details</legend>
	<div class="form-group">
		<label for="user.login" class="control-label col-sm-2 required">Login</label>
		<div class="col-sm-8">
			<g:textField name="user.login" class="form-control" value="${user.login}" size="25" />
		</div>
	</div>

	<div class="form-group">
		<label for="user.email" class="control-label col-sm-2 required">Email</label>
		<div class="col-sm-8">
			<g:textField name="user.email" class="form-control" value="${user.email}" size="25" />
		</div>
	</div>

	<div class="form-group">
		<label for="user.firstName" class="control-label col-sm-2 required">First Name</label>
		<div class="col-sm-8">
			<g:textField name="user.firstName" class="form-control" value="${user.firstName}" size="25" />
		</div>
	</div>

	<div class="form-group">
		<label for="user.lastName" class="control-label col-sm-2 required">Last Name</label>
		<div class="col-sm-8">
			<g:textField name="user.lastName" class="form-control" value="${user.lastName}" size="25" />
		</div>
	</div>

</fieldset>
<fieldset>
	<legend>Credentials</legend>
	<div class="form-group">
		<label for="user.password" class="control-label col-sm-2 required">Password</label>
		<div class="col-sm-8">
			<g:passwordField name="user.password" class="form-control" size="25" />
			<p class="help-block">Password must be at least 8 characters</p>
		</div>
	</div>

	<div class="form-group">
		<label for="user.passwordConfirmation" class="control-label col-sm-2 required">Confirm</label>
		<div class="col-sm-8">
			<g:passwordField name="user.passwordConfirmation" class="form-control" size="25" />
			<p class="help-block">Retype your password here.</p>
		</div>
	</div>
</fieldset>
<fieldset>
	<legend>Roles</legend>
	<div class="form-group">
		<div class="col-sm-8 col-sm-offset-2">
			<div class="checkbox">
				<label>
					<g:checkBox name="user.superAdmin" checked="${user.superAdmin}" /> Super Admin			
				</label>
			</div>
		</div>
	</div>
</fieldset>

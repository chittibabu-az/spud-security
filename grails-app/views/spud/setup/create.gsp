<g:applyLayout name="spud/setup">
	<content tag="detail">
		<g:form name="new_user" url="[action: 'save',controller: 'setup',namespace: 'spud_admin', method: 'POST']" method="POST" class="form-horizontal">

		<fieldset>
			<legend>New Admin Account</legend>

				<div class="form-group">
					<label for="login" class="control-label col-sm-2">Login</label>

					<div class="col-sm-8">
						<g:textField name="login" class="form-control" value="${user?.login}" size="25" />
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="control-label col-sm-2">Email</label>
					<div class="col-sm-8">
						<g:textField name="email" class="form-control" value="${user?.login}" size="25" />
					</div>
				</div>

				<div class="form-group">
					<label for="password" class="control-label col-sm-2">Password</label>
					<div class="col-sm-8">
						<g:passwordField name="password" class="form-control" size="25" />
						<p class="help-block">Password must be at least 8 characters</p>
					</div>
				</div>
				<div class="form-group">
					<label for="passwordConfirmation" class="control-label col-sm-2">Confirm</label>
					<div class="col-sm-8">
						<g:passwordField name="passwordConfirmation" class="form-control" size="25" />
						<p class="help-block">Retype your password here.</p>
					</div>
				</div>
		</fieldset>
		<div class="form-group">
			<div class="col-sm-8 col-sm-offset-2">
				<g:submitButton name="_submit" value="Create Admin Account" class="btn btn-primary"/>		
			</div>
		</div>
	</g:form>

	</content>
</g:applyLayout>

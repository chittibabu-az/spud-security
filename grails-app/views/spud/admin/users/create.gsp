<g:applyLayout name="spud/admin/detail" >

<content tag="detail">
	<g:form name="new_user" url="[action: 'index',controller: 'user',namespace: 'spud_admin']" method="POST" class="form-horizontal">
		<g:render template="/spud/admin/users/form" model="[user: user]" />

		<div class="form-group">
			<div class="col-sm-8 col-sm-offset-2">
				<g:submitButton name="_submit" value="Create User" class="btn btn-primary"/>
			</div>
		</div>
	</g:form>

</content>

</g:applyLayout>

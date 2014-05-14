package spud.security

class SpudUser {
	transient springSecurityService
	static transients = ["passwordConfirmation", 'displayName']

	Long id

	String login
	String email
	String firstName
	String lastName
	String password

	String passwordSalt
	Date lastLoginAt
	Date lastRequestAt
	Date lastLoginIp
	Date currentLoginAt
	Integer failedLoginCount = 0
	Integer loginCount = 0
	String perishableToken
	String persistenceToken
	String singleAccessToken
	Date dateCreated
	Date lastUpdated
	String timeZone

	Boolean enabled=true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	Boolean superAdmin = false


	static constraints = {
		login blank: false, nullable: false, unique: true
		email blank: false, nullable: false
		password nullable: false, blank:false
		passwordSalt nullable: true, blank: true
		timeZone nullable:true
		singleAccessToken nullable:true
		persistenceToken nullable:true
		perishableToken nullable:true
		currentLoginAt nullable:true
		lastLoginIp nullable:true
		lastLoginAt nullable:true
		lastRequestAt nullable:true
		firstName nullable:true
		lastName nullable:true

		// Add Custom Validator on Password to match against transient passwordConfirmation
	}

	static mapping = {
		def cfg = it?.getBean('grailsApplication')?.config
		datasource(cfg?.spud?.core?.datasource ?: 'DEFAULT')
		table 'spud_users'
		autoTimestamp true
		password column: 'crypted_password'
		dateCreated column: 'created_at'
		lastUpdated column: 'updated_at'
	}

	public String getDisplayName() {
		if(firstName && lastName) {
			return "${firstName} ${lastName}"
		}
		if(firstName) {
			return firstName
		}
		if(lastName) {
			return lastName
		}
		return login
	}

	Set<SpudRole> getAuthorities() {
			SpudUserRole.findAllByUser(this).collect { it.role } as Set
	 }

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	void setPassword(String newPassword) {
		if(newPassword) {
			password = newPassword
		}
	}

	protected void encodePassword() {
		if(!this.passwordSalt) {
			this.passwordSalt = login;
		}

		
		password = springSecurityService.encodePassword(password)

	}



	def updateSessionInfo(request) {
		this.lastRequestAt = new Date()
		this.save()
	}

	public String toString() {
		return this.displayName
	}
}

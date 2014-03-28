package spud.security

import org.grails.plugin.securitybridge.AbstractSecurityBridge
import org.springframework.security.web.savedrequest.DefaultSavedRequest
import org.springframework.security.web.WebAttributes
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.security.web.savedrequest.HttpSessionRequestCache
import java.lang.reflect.Field

class SpudSecurityBridge extends AbstractSecurityBridge{
	def springSecurityService

		/**
	 * Returns the current user object if they are logged in
	 * @return the implementation's user object or null if nobody is logged in
	 */
	def getCurrentUser() {
		return springSecurityService.currentUser
	}

	/**
	 * Get the user Identifier.
	 * @return the user identity or null if nobody is logged in
	 */
	def getUserIdentity() {
		return springSecurityService.currentUser.id
	}

	/**
	 * Returns the current account object of the logged in user
	 * @return the implementation's account (for basic auth can just be the user object) object or null if nobody is logged in
	 */
	def getCurrentAccount() {
		getCurrentUser()
	}

	/**
	 * Returns the current users account identity. (Useful if multiple users are tied to one account)
	 * @return the account name or identity, null if nobody is logged in.
	 */
	def getAccountIdentity() {
		getUserIdentity()
	}

	/**
	 * Return the current users display name.
	 */
	def getCurrentUserDisplayName() {
		return springSecurityService.currentUser.displayName
	}

	/**
	 * Check if the user is currently logged in.
	 */
	boolean isLoggedIn() {
		return springSecurityService.isLoggedIn()
	}

	/**
	 * Check if the currently logged in user is authorized to perform an action on the passed object
	 * @param object The object with which we are dealing with.
	 * @param action The action you would like to perform
	 */
	boolean isAuthorized(object, action) {
		// WE ACTUALLY DONT IMPLEMENT THIS SECURITY
		log.warn("isAuthorized is not implemented in the sharedSecurityBridge")
		return true
	}

	/**
   * Check if the currently logged in user has the specified role
   * @param role
   */
	boolean hasRole(role) {
		if(!springSecurityService.isLoggedIn()) {
			return false
		}

		if(role == 'AUTHORIZED') {
			return true
		}
		if(getCurrentUser().superAdmin) {
			return true
		}

		def requiredAuthorities = spudSecureAnnotation.value()
		def authorities = getCurrentUser().authorities
		def authorized = false
		authorities.find { currentRole ->

			if(currentRole.authority == role) {
				authorized = true
				return true
			}
		}

		return authorized
	}

	/**
	 * Store the request location for the security service to redirect to upon login success
	 * @param request The request object
	 */
	def storeLocation(request) {
		def savedRequest = new SpudSecurityRequestWrapper(request, 'AUTHORIZED')
		new HttpSessionRequestCache().saveRequest(savedRequest,RequestContextHolder.getRequestAttributes().getResponse())
	}

	/**
	 * Execute code masquerading as the specified user, for the duration of the Closure block
	 * @return Whatever the closure returns
	 */
	def withUser(identity, Closure code) {
		def user = SpudUser.read(identity)
		def account = user
		code(user,account)
	}

	/**
   * Create a link to the specified security action
   * @param action One of "login", "logout", "signup"
   * @return Must return a Map of arguments to pass to g:link to create the link
   */
  Map createLink(String action) {
	switch(action) {
		case 'login':
			return getLoginUrl();
		case 'logout':
			return getLogoutUrl();
	}
  }

  Map getLoginUrl() {
	def userCount = SpudUser.count()
		if(userCount == 0) {
			return [controller: "setup", namespace: "spud_admin", action: "create"]
		}
		return [controller: 'login', action: 'auth']
  }

  Map getLogoutUrl() {
		return [controller: 'logout', action: 'index', method: 'POST', "data-method": 'POST']
	}
}

// configuration for plugin testing - will not be included in the plugin zip

log4j = {
  error 'org.codehaus.groovy.grails',
        'org.springframework',
        'org.hibernate',
        'net.sf.ehcache.hibernate'
}
// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.password.algorithm = 'SHA-512'
grails.plugins.springsecurity.userLookup.userDomainClassName = 'spud.security.SpudUser'
grails.plugins.springsecurity.userLookup.usernamePropertyName = 'login'
grails.plugins.springsecurity.password.algorithm = 'SHA-512'
grails.plugins.springsecurity.authority.className = 'spud.security.SpudRole'
grails.plugins.springsecurity.authority.nameField = 'authority'
grails.plugins.springsecurity.userLookup.authoritiesPropertyName = 'authorities'

// configuration for plugin testing - will not be included in the plugin zip

log4j = {
  error 'org.codehaus.groovy.grails',
        'org.springframework',
        'org.hibernate',
        'net.sf.ehcache.hibernate'
}
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.password.algorithm = 'SHA-512'
grails.plugin.springsecurity.userLookup.userDomainClassName = 'spud.security.SpudUser'
grails.plugin.springsecurity.userLookup.usernamePropertyName = 'login'
grails.plugin.springsecurity.password.algorithm = 'SHA-512'
grails.plugin.springsecurity.authority.className = 'spud.security.SpudRole'
grails.plugin.springsecurity.authority.nameField = 'authority'
grails.plugin.springsecurity.userLookup.authoritiesPropertyName = 'authorities'

/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import spud.security.SpudSecurityBridge

class SpudSecurityGrailsPlugin {
    def version = "0.1.0"
    def grailsVersion = "2.3 > *"
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]
    def title       = "Spud Security Plugin"
    def author      = "David Estes"
    def authorEmail = "destes@bcap.com"
    def description = "Implements Security, using Spring Security Core, for SpudCore and the rest of the spud suite. Spud Security also provides user models and role models that can be managed from a convenient administrative panel within the spud admin."
    def documentation = "https://github.com/spud-grails/spud-security"
    def license = "APACHE"
    def organization = [name: "Bertram Labs", url: "http://www.bertramlabs.com/"]
    def issueManagement = [system: "GITHUB", url: "https://github.com/spud-grails/spud-security/issues"]
    def scm = [url: "https://github.com/spud-grails/spud-security"]


    def doWithSpring = {
        application.config.grails.plugins.springsecurity.password.algorithm = 'SHA-512'
        application.config.grails.plugins.springsecurity.userLookup.userDomainClassName = 'spud.security.SpudUser'
        application.config.grails.plugins.springsecurity.userLookup.usernamePropertyName = 'login'
        application.config.grails.plugins.springsecurity.password.algorithm = 'SHA-512'
        application.config.grails.plugins.springsecurity.authority.className = 'spud.security.SpudRole'
        application.config.grails.plugins.springsecurity.authority.nameField = 'authority'
        application.config.grails.plugins.springsecurity.userLookup.authoritiesPropertyName = 'authorities'

        sharedSecurityBridge(SpudSecurityBridge) {
            springSecurityService = ref('springSecurityService')
        }
    }
}

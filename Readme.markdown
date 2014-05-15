Spud Security
===============

Implements Security, using Spring Security Core, for SpudCore and the rest of the spud suite. Spud Security also provides user models and role models that can be managed from a convenient administrative panel within the spud admin.

Installation/Usage
------------------

To install simply add the spud-security plugin to your BuildConfig:

```groovy
repositories {
  mavenRepo "http://repo.spring.io/milestone/"
}
plugins {
  compile ':spud-security:0.4.1'
}
```

**NOTE** The repository directive is for the current RC2 release of Spring Security (this should go away when spring security goes final)

This plugin also provides a convenient administrative interface for managing users/roles. (View from your /spud/admin interface).

**First Time Users**: First time users will be redirected to a setup page where an initial user can be created.

This plugin is compatible and implements a `grails-security-bridge`.

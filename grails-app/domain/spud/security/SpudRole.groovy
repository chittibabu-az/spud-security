package spud.security

class SpudRole {

    String authority

    static mapping = {
        def cfg = it?.getBean('grailsApplication')?.config
        datasource(cfg?.spud?.core?.datasource ?: 'DEFAULT')
        cache true
    }

    static constraints = {
        authority blank: false, unique: true
    }
}

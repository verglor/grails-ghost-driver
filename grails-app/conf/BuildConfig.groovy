grails.project.work.dir = ".grails"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    legacyResolve true // whether to do a secondary resolve on plugin installation, not advised but set here for backwards compatibility
    repositories {
        grailsCentral()
        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        //mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.18'

//        compile "xerces:xercesImpl:2.9.1", { excludes 'xml-apis' }
//        test "org.seleniumhq.selenium:selenium-support:2.39.0", { excludes 'xml-apis' }
        test "com.github.detro.ghostdriver:phantomjsdriver:1.1.0", { excludes 'xml-apis', 'xerces', 'xercesImpl' }

    }

    plugins {
        runtime ":console:1.2", { export = false }
        build(":tomcat:$grailsVersion",
              ":release:2.2.0",
              ":rest-client-builder:1.0.3") {
            export = false
        }
    }
}

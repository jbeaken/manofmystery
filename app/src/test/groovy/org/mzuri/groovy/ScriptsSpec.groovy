package org.mzuri.groovy

import spock.lang.Specification

class ScriptsSpec extends Specification {

    def "Run script using GroovyClassLoader"() {

        given: "Class loader is booted up"
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(this.getClass().getClassLoader());

        and: "Ivy is added to the classpath"
        groovyClassLoader.addClasspath("/home/hal/.groovy/grapes/org.apache.ivy/ivy/jars/ivy-2.4.0.jar")
        def ivyMessageLoggerClazz = groovyClassLoader.loadClass("org.apache.ivy.util.MessageLogger")

        when: "Class is loaded"
        Class clazz = groovyClassLoader.parseClass( new File( getClass().getResource("/scripts/WelcomeScript.groovy").toURI() ))

        then: "Class is verfified"
        clazz.getDeclaredConstructor().newInstance()
    }
}

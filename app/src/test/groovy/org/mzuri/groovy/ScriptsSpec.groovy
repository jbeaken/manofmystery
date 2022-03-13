package org.mzuri.groovy

import spock.lang.Specification

class ScriptsSpec extends Specification {

    def "Run script using GroovyClassLoader"() {

        given: "Class loader is booted up"
        ClassLoader classLoader = this.getClass().getClassLoader()
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(classLoader);

        and: "Ivy is added to the classpath"
        groovyClassLoader.addClasspath("/home/hal/.groovy/grapes/org.apache.ivy/ivy/jars/ivy-2.4.0.jar")

        when: "Ivy class is loaded"
        def ivyMessageLoggerClazz = groovyClassLoader.loadClass("org.apache.ivy.util.MessageLogger")

        then: "It is valid"
        ivyMessageLoggerClazz.toString() == "interface org.apache.ivy.util.MessageLogger"

        when: "Script is loaded"
        Class clazz = groovyClassLoader.parseClass( new File( getClass().getResource("/scripts/WelcomeScript.groovy").toURI() ))

        then: "Class is verified"
        clazz.getDeclaredConstructor().newInstance()
    }

    def "Load script with GroovyScriptEngine and CPS"() {

        URL resource = getClass().getResource("/scripts/")
        def engine = new GroovyScriptEngine([ resource ] as URL[] )

        // Set script base class
        gse.getConfig().setScriptBaseClass(scriptBaseClass.getName())
//        // Add transformer for CPS compilation
//        def transformer = new CpsTransformer()
//        transformer.setConfiguration(new TransformerConfiguration().withClosureType(MockClosure.class))
//        gse.getConfig().addCompilationCustomizers(transformer)
    }
}

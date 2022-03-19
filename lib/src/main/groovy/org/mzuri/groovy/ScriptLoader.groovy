package org.mzuri.groovy

class ScriptLoader {

    static void main(String[] args) {

        def scriptLoader  = new ScriptLoader()

        scriptLoader.loadScript()
    }

    def loadScript() {
        def binding = new Binding()

        URL resource = getClass().getResource("/scripts/")

        URL ivyUrl = new URI("file:/home/hal/.groovy/grapes/org.apache.ivy/ivy/jars/ivy-2.4.0.jar").toURL()

        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(this.getClass().getClassLoader());
        groovyClassLoader.addClasspath("/home/hal/.groovy/grapes/org.apache.ivy/ivy/jars/ivy-2.4.0.jar")

        def engine = new GroovyScriptEngine([ resource ] as URL[], groovyClassLoader )

        engine.groovyClassLoader.addClasspath("/home/hal/.groovy/grapes/org.apache.ivy/ivy/jars/ivy-2.4.0.jar")

        while (true) {
            def greeter = engine.run('WelcomeScript.groovy', binding)
            println greeter.sayHello()
            Thread.sleep(1000)
        }
    }
}

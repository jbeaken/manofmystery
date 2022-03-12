package org.mzuri.groovy

class ScriptLoader {

    static void main(String[] args) {

        def scriptLoader  = new ScriptLoader()

        scriptLoader.loadScript()
    }

    def loadScript() {
        def binding = new Binding()

        File context = new File(getClass().getResource("/scripts/WelcomeScript.groovy").toURI())

        def engine = new GroovyScriptEngine([context.toURI().toURL()] as URL[])
//        def engine = new GroovyScriptEngine( ScriptLoader.getClass().getResource("resources/scripts/").toURI() as URI[])

        while (true) {
            def greeter = engine.run('WelcomeScript.groovy', binding)
            println greeter.sayHello()
            Thread.sleep(1000)
        }


    }
}

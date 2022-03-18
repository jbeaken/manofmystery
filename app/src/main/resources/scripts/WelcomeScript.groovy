//@GrabConfig(initContextClassLoader = true)
//@Grab(group='org.yaml', module='snakeyaml', version='1.30')

class Greeter {
    def sayHello(self) {
        assert this == self
        // assert this.metaClass == self.metaClass

        self.metaClass.greeting = { System.out.println "Hello!" }
        greeting()
    }
}

def greeter = new Greeter()
greeter.sayHello(greeter)


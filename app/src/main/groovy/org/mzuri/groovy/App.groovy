/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package org.mzuri.groovy

class Application {
    String getGreeting() {
        return 'Hello World!'
    }

    static void main(String[] args) {

        def app = new Application()

        def cyclist = new Cyclist()

        println cyclist
    }

    
}



record Cyclist(String firstName, String lastName) { }



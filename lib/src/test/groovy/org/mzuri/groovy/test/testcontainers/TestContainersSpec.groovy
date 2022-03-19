package org.mzuri.groovy.test.testcontainers

import groovy.util.logging.Slf4j
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.output.Slf4jLogConsumer
import spock.lang.Specification

@Slf4j
class TestContainersSpec extends Specification {

    final GenericContainer genericContainer = new GenericContainer("ubuntu")
        .withLogConsumer(new Slf4jLogConsumer(log))
        .withCommand("/bin/sh", "-c", "while true; do sleep 10000; done")

    def "Boot Unbuntu container script"() {
        given: "Boot"
        genericContainer.start()
    }
}

package org.mzuri.groovy.cps

import com.cloudbees.groovy.cps.Block
import com.cloudbees.groovy.cps.Env
import com.cloudbees.groovy.cps.impl.CpsClosure
import org.codehaus.groovy.runtime.InvokerHelper

class MockClosure extends CpsClosure {

    MockClosure(Object owner, Object thisObject, List<String> parameters, Block body, Env capture) {
        super(owner, thisObject, parameters, body, capture)
    }

    /**
     * Override sleep method
     */
    void sleep(long milliseconds) {
        InvokerHelper.invokeMethod(getOwner(), "sleep", milliseconds)
    }
}
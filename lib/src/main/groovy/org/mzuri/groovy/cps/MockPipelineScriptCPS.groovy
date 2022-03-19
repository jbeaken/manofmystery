package org.mzuri.groovy.cps

abstract class MockPipelineScriptCPS extends Script implements Serializable {

    private void writeObject(ObjectOutputStream oos) throws IOException {
        // binding is defined in non-serializable Script class,
        // so we need to persist that here
        def variables = getBinding().getVariables().clone()
        oos.writeObject(variables)
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        Map m = (Map)ois.readObject()
        getBinding().getVariables().putAll(m)
    }
}


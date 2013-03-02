package javaposse.jobdsl.dsl.helpers

/**
 * @author Zsolt Takacs <zsolt@takacs.cc>
 */
class PropertiesContext implements Context {
    List<Node> propertiesNodes = []

    PropertiesContext() {
    }

    PropertiesContext(List<Node> propertiesNodes) {
        this.propertiesNodes = propertiesNodes
    }

    def heavyJob(int jobWeight) {
        def nodeBuilder = new NodeBuilder()
        Node weightNode = nodeBuilder.'hudson.plugins.heavy__job.HeavyJobProperty' {
            weight(jobWeight)
        }

        propertiesNodes << weightNode
    }
}

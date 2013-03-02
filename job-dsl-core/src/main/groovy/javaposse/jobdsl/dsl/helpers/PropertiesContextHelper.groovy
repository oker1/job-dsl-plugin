package javaposse.jobdsl.dsl.helpers

import javaposse.jobdsl.dsl.WithXmlAction

/**
 * @author Zsolt Takacs <zsolt@takacs.cc>
 */
class PropertiesContextHelper extends AbstractContextHelper<PropertiesContext> {
    PropertiesContextHelper(List<WithXmlAction> withXmlActions) {
        super(withXmlActions)
    }

    /**
     * Public method available directly on job {}
     * @param closure
     * @return
     */
    def properties(Closure closure) {
        execute(closure, new PropertiesContext())
    }

    Closure generateWithXmlClosure(PropertiesContext context) {
        return { Node project ->
            def propertiesNode
            if (project.properties.isEmpty()) {
                propertiesNode = project.appendNode('properties')
            } else {
                propertiesNode = project.properties[0]
            }
            context.propertiesNodes.each {
                propertiesNode << it
            }
        }
    }
}

package de.tu_bs.cs.isf.spl.simplecad.presentation;

import de.tu_bs.cs.isf.spl.simplecad.model.Shape;

public class NodeBuilderTestSub extends NodeBuilder {

    private StringBuilder logString;

    public NodeBuilderTestSub(StringBuilder logString) {
        this.logString = logString;
    }

    public Shape makeShape() {
        logString.append("c");
        return new LoggingNodeSpy(logString);
    }
}

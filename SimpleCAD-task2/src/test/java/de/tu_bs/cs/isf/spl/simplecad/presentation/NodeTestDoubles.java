package de.tu_bs.cs.isf.spl.simplecad.presentation;

import de.tu_bs.cs.isf.spl.simplecad.model.Node;
import de.tu_bs.cs.isf.spl.simplecad.model.Point;

class NodeStub extends Node {
    protected Point first;
    protected Point second;

    public void setFirst(Point first) {
        this.first = first;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getFirst() {
        return first;
    }

    public Point getSecond() {
        return second;
    }
}

class LoggingNodeSpy extends NodeStub {

    private StringBuilder logString;

    public LoggingNodeSpy(StringBuilder logString) {
        this.logString = logString;
    }

    public void setFirst(Point first) {
        logString.append("f");
        this.first = first;
    }

    public void setSecond(Point second) {
        logString.append("s");
        this.second = second;
    }
}

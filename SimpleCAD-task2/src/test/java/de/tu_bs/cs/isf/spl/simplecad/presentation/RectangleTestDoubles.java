package de.tu_bs.cs.isf.spl.simplecad.presentation;

import de.tu_bs.cs.isf.spl.simplecad.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.model.Rectangle;

class RectangleStub extends Rectangle {
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

class LoggingRectangleSpy extends RectangleStub {

    private StringBuilder logString;

    public LoggingRectangleSpy(StringBuilder logString) {
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
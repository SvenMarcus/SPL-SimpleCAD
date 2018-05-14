package de.tu_bs.cs.isf.spl.simplecad.presentation;

import de.tu_bs.cs.isf.spl.simplecad.model.Line;
import de.tu_bs.cs.isf.spl.simplecad.model.Point;

class LineStub extends Line {
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

class LoggingLineSpy extends LineStub {

    private StringBuilder logString;

    public LoggingLineSpy(StringBuilder logString) {
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

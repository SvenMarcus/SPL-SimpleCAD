package de.tu_bs.cs.isf.spl.simplecad.presentation;

import de.tu_bs.cs.isf.spl.simplecad.model.Shape;

public class LineBuilderTestSub extends LineBuilder {

    private StringBuilder logString;

    public LineBuilderTestSub(StringBuilder logString) {
        super();
        this.logString = logString;
    }

    @Override
    protected Shape makeShape() {
        logString.append("c");
        return new LoggingLineSpy(logString);
    }
}

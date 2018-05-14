package de.tu_bs.cs.isf.spl.simplecad.presentation;

import de.tu_bs.cs.isf.spl.simplecad.model.Shape;

public class RectangleBuilderTestSub extends RectangleBuilder {

    private StringBuilder logString;

    public RectangleBuilderTestSub(StringBuilder logString) {
        super();
        this.logString = logString;
    }

    @Override
    protected Shape makeShape() {
        logString.append("c");
        return new LoggingRectangleSpy(logString);
    }

}

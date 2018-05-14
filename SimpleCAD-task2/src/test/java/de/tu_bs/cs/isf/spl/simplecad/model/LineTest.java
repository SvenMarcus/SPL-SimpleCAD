package de.tu_bs.cs.isf.spl.simplecad.model;

import static de.tu_bs.cs.isf.spl.simplecad.RendererAssertions.assertLastLineWasRendered;
import static de.tu_bs.cs.isf.spl.simplecad.TestUtil.makePoint;

import org.junit.Test;

import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRendererSpy;

public class LineTest {
    @Test
    public void givenBothPointsSet__whenCallingRender__shouldRenderLineWithCorrectCoordinates() {
        Line sut = new Line();
        ShapeRendererSpy shapeRendererSpy = new ShapeRendererSpy();

        Point first = makePoint(3, 7);
        Point second = makePoint(12, 60);
        sut.setFirst(first);
        sut.setSecond(second);

        sut.render(shapeRendererSpy);

        Point expectedFirst = makePoint(3, 7);
        Point expectedSecond = makePoint(12, 60);
        assertLastLineWasRendered(shapeRendererSpy, expectedFirst, expectedSecond);
    }
}

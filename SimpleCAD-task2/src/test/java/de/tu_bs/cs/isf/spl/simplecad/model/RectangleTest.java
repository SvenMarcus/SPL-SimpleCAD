package de.tu_bs.cs.isf.spl.simplecad.model;

import static de.tu_bs.cs.isf.spl.simplecad.RendererAssertions.assertLastRectangleWasRendered;
import static de.tu_bs.cs.isf.spl.simplecad.TestUtil.makePoint;

import org.junit.Test;

import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRendererSpy;

public class RectangleTest {

    @Test
    public void givenBothPointsSet_and_firstPointIsBottomRight__whenCallingRender__shouldRenderWithCorrectCorners() {
        Rectangle sut = new Rectangle();
        ShapeRendererSpy shapeRendererSpy = new ShapeRendererSpy();

        Point first = makePoint(10, 5);
        Point second = makePoint(3, 12);
        sut.setFirst(first);
        sut.setSecond(second);

        sut.render(shapeRendererSpy);

        Point expectedTopLeft = makePoint(3, 5);
        Point expectedBottomRight = makePoint(10, 12);
        assertLastRectangleWasRendered(shapeRendererSpy, expectedTopLeft, expectedBottomRight);
    }

    @Test
    public void givenBothPointsSet_and_firstIsTopRight__whenCallingRender__shouldRenderWithCorrectCorners() {
        Rectangle sut = new Rectangle();
        ShapeRendererSpy shapeRendererSpy = new ShapeRendererSpy();

        Point first = makePoint(10, 12);
        Point second = makePoint(3, 5);
        sut.setFirst(first);
        sut.setSecond(second);

        sut.render(shapeRendererSpy);

        Point expectedFirstRenderedPoint = makePoint(3, 5);
        Point expectedSecondRenderedPoint = makePoint(10, 12);
        assertLastRectangleWasRendered(shapeRendererSpy, expectedFirstRenderedPoint, expectedSecondRenderedPoint);
    }


}

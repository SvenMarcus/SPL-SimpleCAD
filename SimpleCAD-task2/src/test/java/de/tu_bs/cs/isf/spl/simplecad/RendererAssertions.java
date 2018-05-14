package de.tu_bs.cs.isf.spl.simplecad;

import static de.tu_bs.cs.isf.spl.simplecad.TestUtil.makePoint;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import de.tu_bs.cs.isf.spl.simplecad.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRendererSpy;

public class RendererAssertions {

    public static void assertNoLineRendered(ShapeRendererSpy shapeRendererSpy) {
        String message = "Should not have rendered any lines, but did";
        boolean expected = shapeRendererSpy.renderedLine();
        assertFalse(message, expected);
    }

    public static void assertNodeWasRendered(ShapeRendererSpy shapeRenderer, Point expectedLocation) {
        Point actualLocation = makePoint(shapeRenderer.getX1(), shapeRenderer.getY1());
        assertTrue("Node should have been rendered at " + expectedLocation + ", but was at " + actualLocation, shapeRenderer.renderedNodeAt(expectedLocation.getX(), expectedLocation.getY()));
    }

    public static void assertLastRectangleWasRendered(ShapeRendererSpy shapeRendererSpy, Point firstPoint, Point secondPoint) {
        Point actualFirst = makePoint(shapeRendererSpy.getX1(), shapeRendererSpy.getY1());
        Point actualSecond = makePoint(shapeRendererSpy.getX2(), shapeRendererSpy.getY2());
        String message = "Rectangle should have been rendered from " + firstPoint + " to " + secondPoint + ", but was from " + actualFirst + " to " + actualSecond;
        assertTrue(message, shapeRendererSpy.renderedLastRectangleWith(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY()));
    }

    public static void assertLastLineWasRendered(ShapeRendererSpy shapeRendererSpy, Point first, Point second) {
        boolean expected = shapeRendererSpy.renderedLastLineWith(first.getX(), first.getY(), second.getX(), second.getY());

        Point actualFirst = makePoint(shapeRendererSpy.getX1(), shapeRendererSpy.getY1());
        Point actualSecond = makePoint(shapeRendererSpy.getX2(), shapeRendererSpy.getY2());
        String message =
                "Last " + makeLineRenderAssertMessage(first, second, actualFirst, actualSecond);

        assertTrue(message, expected);
    }

    public static void assertPreviousLineWasRendered(ShapeRendererSpy shapeRendererSpy, Point first, Point second) {
        boolean expected = shapeRendererSpy.renderedPreviousLineWith(first.getX(), first.getY(), second.getX(), second.getY());

        Point actualFirst = makePoint(shapeRendererSpy.getPreviousX1(), shapeRendererSpy.getPreviousY1());
        Point actualSecond = makePoint(shapeRendererSpy.getPreviousX2(), shapeRendererSpy.getPreviousY2());
        String message =
                "Previous " + makeLineRenderAssertMessage(first, second, actualFirst, actualSecond);

        assertTrue(message, expected);
    }

    private static String makeLineRenderAssertMessage(Point first, Point second, Point actualFirst, Point actualSecond) {
        return "Line should have been rendered from " +
                first +
                " to " +
                second +
                ", but was from " +
                actualFirst + " to " + actualSecond;
    }

}

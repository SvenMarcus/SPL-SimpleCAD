package de.tu_bs.cs.isf.spl.simplecad.presentation;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import de.tu_bs.cs.isf.spl.simplecad.model.Line;
import de.tu_bs.cs.isf.spl.simplecad.model.Node;
import de.tu_bs.cs.isf.spl.simplecad.model.Rectangle;
import de.tu_bs.cs.isf.spl.simplecad.model.Shape;

public class ShapeBuilderAssertions {
    public static void assertObjectIsFinished(ShapeBuilder sut) {
        assertTrue("Object should be finished, but is not", sut.isObjectFinished());
    }

    public static void assertObjectIsNotFinished(ShapeBuilder sut) {
        assertFalse("Object should not be finished, but it is", sut.isObjectFinished());
    }

    public static void assertIsInstanceOfLine(Shape actual) {
        assertThat("Should return instance of Line but does not", actual, is(instanceOf(Line.class)));
    }

    public static void assertIsInstanceOfRectangle(Shape actual) {
        assertThat("Should return instance of Rectangle but does not", actual, is(instanceOf(Rectangle.class)));
    }

    public static void assertIsInstanceOfNode(Shape actual) {
        assertThat("Should return instance of Node but does not", actual, is(instanceOf(Node.class)));
    }

    public static void assertCreatesShapeThenAssignsPoints(String actual) {
        String expected = "cfs";
        assertTrue("Should create shape, then assign points, but does not. LogString is: \"" + actual + "\"", expected.equals(actual));
    }
}

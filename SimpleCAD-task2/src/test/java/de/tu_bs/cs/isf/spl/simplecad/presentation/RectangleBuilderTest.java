package de.tu_bs.cs.isf.spl.simplecad.presentation;

import static de.tu_bs.cs.isf.spl.simplecad.TestUtil.makePoint;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertCreatesShapeThenAssignsPoints;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertIsInstanceOfRectangle;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertObjectIsFinished;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertObjectIsNotFinished;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.tu_bs.cs.isf.spl.simplecad.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.model.Shape;

public class RectangleBuilderTest {

    private RectangleBuilder makeRectangleBuilder() {
        return new RectangleBuilder();
    }

    @Test
    public void whenSettingTwoPoints_objectShouldBeFinished() {
        RectangleBuilder sut = makeRectangleBuilder();

        sut.addPoint(makePoint(0, 0));
        sut.addPoint(makePoint(0, 0));

        assertObjectIsFinished(sut);
    }

    @Test
    public void whenSettingOnePoint_objectShouldNotBeFinished() {
        RectangleBuilder sut = makeRectangleBuilder();

        sut.addPoint(makePoint(0, 0));

        assertObjectIsNotFinished(sut);
    }

    @Test
    public void freshInstance__getShapeShouldReturnLine() {
        RectangleBuilder sut = makeRectangleBuilder();

        Shape actual = sut.getShape();
        assertIsInstanceOfRectangle(actual);
    }

    @Test
    public void whenSettingBothPoints__shouldCreateShapeFirstThenSetFirstAndSecondPoint() {
        StringBuilder logString = new StringBuilder();
        RectangleBuilder sut = new RectangleBuilderTestSub(logString);

        sut.addPoint(makePoint(2, 8));
        sut.addPoint(makePoint(10, 13));

        String actual = logString.toString();

        assertCreatesShapeThenAssignsPoints(actual);
    }

    @Test
    public void whenSettingBothPoints__getShapeShouldReturnLineWithCorrectCoordinates() {
        StringBuilder logString = new StringBuilder();
        RectangleBuilder sut = new RectangleBuilderTestSub(logString);

        sut.addPoint(makePoint(2, 8));
        sut.addPoint(makePoint(10, 13));

        RectangleStub actual = (RectangleStub) sut.getShape();
        Point expectedFirst = makePoint(2, 8);
        Point expectedSecond = makePoint(10, 13);
        assertCorrectCoordinates(actual, expectedFirst, expectedSecond);
    }

    private void assertCorrectCoordinates(RectangleStub actual, Point expectedFirst, Point expectedSecond) {
        assertTrue("Line should have expected coordinates, but does not", arePointsEqualToExpected(actual, expectedFirst, expectedSecond));
    }

    private boolean arePointsEqualToExpected(RectangleStub actual, Point expectedFirst, Point expectedSecond) {
        return expectedFirst.getX() == actual.getFirst().getX() &&
                expectedFirst.getY() == actual.getFirst().getY() &&
                expectedSecond.getX() == actual.getSecond().getX() &&
                expectedSecond.getY() == actual.getSecond().getY();
    }

}

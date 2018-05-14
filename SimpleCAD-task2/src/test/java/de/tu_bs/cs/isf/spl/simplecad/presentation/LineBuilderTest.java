package de.tu_bs.cs.isf.spl.simplecad.presentation;

import static de.tu_bs.cs.isf.spl.simplecad.TestUtil.makePoint;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertCreatesShapeThenAssignsPoints;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertIsInstanceOfLine;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertObjectIsFinished;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertObjectIsNotFinished;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.tu_bs.cs.isf.spl.simplecad.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.model.Shape;

public class LineBuilderTest {

    private LineBuilder makeLineBuilder() {
        return new LineBuilder();
    }

    @Test
    public void whenSettingTwoPoints_objectShouldBeFinished() {
        LineBuilder sut = makeLineBuilder();

        sut.addPoint(makePoint(0, 0));
        sut.addPoint(makePoint(0, 0));

        assertObjectIsFinished(sut);
    }

    @Test
    public void whenSettingOnePoint_objectShouldNotBeFinished() {
        LineBuilder sut = makeLineBuilder();

        sut.addPoint(makePoint(0, 0));

        assertObjectIsNotFinished(sut);
    }

    @Test
    public void freshInstance__getShapeShouldReturnLine() {
        LineBuilder sut = makeLineBuilder();

        Shape actual = sut.getShape();
        assertIsInstanceOfLine(actual);
    }

    @Test
    public void whenSettingBothPoints__shouldCreateShapeFirstThenSetFirstAndSecondPoint() {
        StringBuilder logString = new StringBuilder();
        LineBuilder sut = new LineBuilderTestSub(logString);

        sut.addPoint(makePoint(2, 8));
        sut.addPoint(makePoint(10, 13));

        String actual = logString.toString();

        assertCreatesShapeThenAssignsPoints(actual);
    }

    @Test
    public void whenSettingBothPoints__getShapeShouldReturnLineWithCorrectCoordinates() {
        StringBuilder logString = new StringBuilder();
        LineBuilder sut = new LineBuilderTestSub(logString);

        sut.addPoint(makePoint(2, 8));
        sut.addPoint(makePoint(10, 13));

        LineStub actual = (LineStub) sut.getShape();
        Point expectedFirst = makePoint(2, 8);
        Point expectedSecond = makePoint(10, 13);
        assertCorrectLineCoordinates(actual, expectedFirst, expectedSecond);
    }

    private void assertCorrectLineCoordinates(LineStub actual, Point expectedFirst, Point expectedSecond) {
        assertTrue("Line should have expected coordinates, but does not", areLinePointsEqualToExpected(actual, expectedFirst, expectedSecond));
    }

    private boolean areLinePointsEqualToExpected(LineStub actual, Point expectedFirst, Point expectedSecond) {
        return expectedFirst.getX() == actual.getFirst().getX() &&
                expectedFirst.getY() == actual.getFirst().getY() &&
                expectedSecond.getX() == actual.getSecond().getX() &&
                expectedSecond.getY() == actual.getSecond().getY();
    }


}

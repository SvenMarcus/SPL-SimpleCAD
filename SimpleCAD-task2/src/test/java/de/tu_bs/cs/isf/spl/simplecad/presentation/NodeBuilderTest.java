package de.tu_bs.cs.isf.spl.simplecad.presentation;

import static de.tu_bs.cs.isf.spl.simplecad.TestUtil.makePoint;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertIsInstanceOfNode;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertObjectIsFinished;
import static de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeBuilderAssertions.assertObjectIsNotFinished;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.tu_bs.cs.isf.spl.simplecad.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.model.Shape;

public class NodeBuilderTest {

    private NodeBuilder makeNodeBuilder() {
        return new NodeBuilder();
    }

    @Test
    public void whenSettingOnePoint__objectShouldBeFinished() {
        NodeBuilder sut = makeNodeBuilder();

        sut.addPoint(makePoint(0, 0));

        assertObjectIsFinished(sut);
    }

    @Test
    public void whenNoPointsSet__objectShouldNotBeFinished() {
        NodeBuilder sut = makeNodeBuilder();

        assertObjectIsNotFinished(sut);
    }

    @Test
    public void givenFreshInstance__getShapeShouldReturnNode() {
        NodeBuilder sut = makeNodeBuilder();

        Shape actual = sut.getShape();

        assertIsInstanceOfNode(actual);
    }

    @Test
    public void whenSettingPoint__shouldCreateShapeThenAssignPoint() {
        StringBuilder logString = new StringBuilder();
        NodeBuilder sut = new NodeBuilderTestSub(logString);

        sut.addPoint(makePoint(0, 0));

        assertCreatesShapeThenAssignsPoint(logString);
    }

    @Test
    public void whenSettingPoint__shouldReturnShapeWithCorrectCoordinates() {
        StringBuilder logString = new StringBuilder();
        NodeBuilder sut = new NodeBuilderTestSub(logString);

        sut.addPoint(makePoint(6, 4));

        NodeStub actual = (NodeStub) sut.getShape();
        Point expected = makePoint(6, 4);
        assertCorrectNodeCoordinates(actual, expected);
    }

    private void assertCreatesShapeThenAssignsPoint(StringBuilder logString) {
        String actual = logString.toString();
        String expected = "cf";
        assertTrue("Should create shape, then assign point, but does not. LogString is: \"" + actual + "\"", expected.equals(actual));
    }

    private void assertCorrectNodeCoordinates(NodeStub actual, Point expected) {
        assertTrue("Node should have expected coordinates, but does not", isPointsEqualToExpected(actual, expected));
    }

    private boolean isPointsEqualToExpected(NodeStub actual, Point expectedFirst) {
        return expectedFirst.getX() == actual.getFirst().getX() &&
                expectedFirst.getY() == actual.getFirst().getY();
    }

}

package de.tu_bs.cs.isf.spl.simplecad.presentation;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ShapeBuilderFactoryImplTest {

    @Test
    public void whenCallingMakeShapeWithLine__shouldReturnLineBuilder() {
        ShapeBuilderFactoryImpl sut = new ShapeBuilderFactoryImpl();

        ShapeBuilder actual = sut.makeShapeBuilder("Line");
        assertThat("Should return instance of LineBuilder, but does not", actual, is(instanceOf(LineBuilder.class)));
    }

    @Test
    public void whenCallingMakeShapeWithRectangle__shouldReturnRectangleBuilder() {
        ShapeBuilderFactoryImpl sut = new ShapeBuilderFactoryImpl();

        ShapeBuilder actual = sut.makeShapeBuilder("Rectangle");
        assertThat("Should return instance of RectangleBuilder, but does not", actual, is(instanceOf(RectangleBuilder.class)));
    }

    @Test
    public void whenCallingMakeShapeWithNode__shouldReturnNodeBuilder() {
        ShapeBuilderFactoryImpl sut = new ShapeBuilderFactoryImpl();

        ShapeBuilder actual = sut.makeShapeBuilder("Node");
        assertThat("Should return instance of NodeBuilder, but does not", actual, is(instanceOf(NodeBuilder.class)));
    }

    @Test(expected = InvalidBuilderTypeException.class)
    public void whenCallingMakeShapeWithInvalidType__shouldThrowException() {
        ShapeBuilderFactoryImpl sut = new ShapeBuilderFactoryImpl();

        ShapeBuilder actual = sut.makeShapeBuilder("InvalidType");
    }

}
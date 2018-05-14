package de.tu_bs.cs.isf.spl.simplecad.model;

import static de.tu_bs.cs.isf.spl.simplecad.RendererAssertions.assertNodeWasRendered;
import static de.tu_bs.cs.isf.spl.simplecad.TestUtil.makePoint;

import org.junit.Test;

import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRendererSpy;

public class NodeTest {

    @Test
    public void givenLocationSet__whenCallingRender__shouldRenderNodeWithCorrectCoordinates() {
        Node sut = new Node();
        ShapeRendererSpy shapeRendererSpy = new ShapeRendererSpy();

        Point first = makePoint(3, 7);
        sut.setFirst(first);

        sut.render(shapeRendererSpy);

        Point expectedLocation = makePoint(3, 7);
        assertNodeWasRendered(shapeRendererSpy, expectedLocation);
    }

}

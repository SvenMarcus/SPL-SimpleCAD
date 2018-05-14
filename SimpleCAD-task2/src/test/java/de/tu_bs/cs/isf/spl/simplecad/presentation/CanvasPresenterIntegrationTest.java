package de.tu_bs.cs.isf.spl.simplecad.presentation;

import static de.tu_bs.cs.isf.spl.simplecad.RendererAssertions.assertLastLineWasRendered;
import static de.tu_bs.cs.isf.spl.simplecad.RendererAssertions.assertLastRectangleWasRendered;
import static de.tu_bs.cs.isf.spl.simplecad.RendererAssertions.assertNoLineRendered;
import static de.tu_bs.cs.isf.spl.simplecad.RendererAssertions.assertNodeWasRendered;
import static de.tu_bs.cs.isf.spl.simplecad.RendererAssertions.assertPreviousLineWasRendered;
import static de.tu_bs.cs.isf.spl.simplecad.TestUtil.makePoint;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import de.tu_bs.cs.isf.spl.simplecad.model.Point;

@RunWith(HierarchicalContextRunner.class)
public class CanvasPresenterIntegrationTest {

    private CanvasPresenter makeSut(ShapeRendererSpy shapeRenderer) {
        Canvas canvasFake = makeCanvasFake(shapeRenderer);
        return new CanvasPresenter(canvasFake);
    }

    private CanvasFake makeCanvasFake(ShapeRenderer renderer) {
        return new CanvasFake(renderer);
    }

    private ShapeRendererSpy makeLineRendererSpy() {
        return new ShapeRendererSpy();
    }

    @Test
    public void givenSelectedDrawLine__whenClickingTwice__shouldRenderLine() {
        ShapeRendererSpy shapeRenderer = makeLineRendererSpy();
        CanvasPresenter sut = makeSut(shapeRenderer);

        Point firstPoint = makePoint(1, 2);
        Point secondPoint = makePoint(5, 4);
        selectDrawLineAndClickTwice(sut, firstPoint, secondPoint);

        assertLastLineWasRendered(shapeRenderer, firstPoint, secondPoint);
    }


    @Test
    public void givenFreshInstance__whenClickingOnce__shouldNotRenderLine() {
        ShapeRendererSpy shapeRenderer = makeLineRendererSpy();
        CanvasPresenter sut = makeSut(shapeRenderer);

        sut.click(0, 0);

        assertNoLineRendered(shapeRenderer);
    }

    @Test
    public void givenFreshInstance__whenClickingTwice__shouldNotRenderLine() {
        ShapeRendererSpy shapeRenderer = makeLineRendererSpy();
        CanvasPresenter sut = makeSut(shapeRenderer);

        sut.click(0, 0);
        sut.click(0, 0);

        assertNoLineRendered(shapeRenderer);
    }

    public class GivenOneLineDrawn {

        private ShapeRendererSpy shapeRenderer;
        private CanvasPresenter sut;
        private Point firstPoint;
        private Point secondPoint;

        @Before
        public void drawOneLineAndResetSpy() {
            shapeRenderer = makeLineRendererSpy();
            sut = makeSut(shapeRenderer);

            firstPoint = makePoint(4, 8);
            secondPoint = makePoint(7, 12);
            selectDrawLineAndClickTwice(sut, firstPoint, secondPoint);

            shapeRenderer.resetSpy();
        }

        @Test
        public void whenClickingAgain__shouldNotRenderNewLine() {
            sut.click(10, 15);

            assertNoLineRendered(shapeRenderer);
        }

        @Test
        public void whenSelectingDrawLine_and_clickingTwice__shouldRenderBothLines() {
            Point thirdPoint = makePoint(13, 2);
            Point fourthPoint = makePoint(25, 17);
            selectDrawLineAndClickTwice(sut, thirdPoint, fourthPoint);

            assertPreviousLineWasRendered(shapeRenderer, firstPoint, secondPoint);
            assertLastLineWasRendered(shapeRenderer, thirdPoint, fourthPoint);
        }

        @Test
        public void whenRequestingRepaint__shouldRenderLine() {
            sut.repaint();

            assertLastLineWasRendered(shapeRenderer, firstPoint, secondPoint);
        }
    }

    @Test
    public void givenSelectedDrawRectangle__whenClickingTwice__shouldRenderRectangle() {
        ShapeRendererSpy shapeRenderer = makeLineRendererSpy();
        CanvasPresenter sut = makeSut(shapeRenderer);

        sut.selectDrawMode(new RectangleBuilder());

        sut.click(10, 15);
        sut.click(35, 40);

        Point expectedTopLeft = makePoint(10, 15);
        Point expectedBottomRight = makePoint(35, 40);
        assertLastRectangleWasRendered(shapeRenderer, expectedTopLeft, expectedBottomRight);
    }

    @Test
    public void givenSelectedDrawNode__whenClickingOnce__shouldRenderNode() {
        ShapeRendererSpy shapeRenderer = makeLineRendererSpy();
        CanvasPresenter sut = makeSut(shapeRenderer);

        sut.selectDrawMode(new NodeBuilder());

        sut.click(10, 15);

        Point expectedLocation = makePoint(10, 15);
        assertNodeWasRendered(shapeRenderer, expectedLocation);
    }


    private void selectDrawLineAndClickTwice(CanvasPresenter sut, Point first, Point second) {
        sut.selectDrawMode(new LineBuilder());
        sut.click(first.getX(), first.getY());
        sut.click(second.getX(), second.getY());
    }



}

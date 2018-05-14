package de.tu_bs.cs.isf.spl.simplecad.presentation;

import java.util.ArrayList;
import java.util.List;

import de.tu_bs.cs.isf.spl.simplecad.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.model.Shape;

public class CanvasPresenter {

    private final Canvas canvas;

    private boolean drawMode = false;

    private ShapeBuilder shapeBuilder;

    private List<Shape> shapes = new ArrayList<Shape>();


    public CanvasPresenter(Canvas canvas) {
        this.canvas = canvas;
    }

    public void selectDrawMode(ShapeBuilder shapeBuilder) {
        this.shapeBuilder = shapeBuilder;
        drawMode = true;
    }

    public void click(int x, int y) {
        if (!drawMode) return;
        shapeBuilder.addPoint(new Point(x, y));
        if (shapeBuilder.isObjectFinished()) {
            shapes.add(shapeBuilder.getShape());
            canvas.redraw(makeRedrawRunnable());
            resetDrawMode();
        }
    }

    private void resetDrawMode() {
        drawMode = false;
    }

    public void repaint() {
        canvas.redraw(makeRedrawRunnable());
    }

    private Runnable makeRedrawRunnable() {
        return new Runnable() {
            public void run() {
                ShapeRenderer renderer = canvas.getShapeRenderer();
                renderShapes(renderer);

            }

            private void renderShapes(ShapeRenderer renderer) {
                for (Shape shape : shapes)
                    shape.render(renderer);
            }
        };
    }
}

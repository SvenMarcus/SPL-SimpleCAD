package de.tu_bs.cs.isf.spl.simplecad.presentation;

public class CanvasFake implements Canvas {

    private final ShapeRenderer renderer;

    public CanvasFake(ShapeRenderer renderer) {
        this.renderer = renderer;
    }

    public void redraw(Runnable runnable) {
        runnable.run();
    }

    public ShapeRenderer getShapeRenderer() {
        return renderer;
    }
}

package de.tu_bs.cs.isf.spl.simplecad.core.mainwindow; 

import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository; 

import java.util.Iterator; 

public  class  CanvasRepaintCommand {
	

    private ShapeRepository repository;

	
    private Canvas canvas;

	

    public CanvasRepaintCommand(ShapeRepository repository, Canvas canvas) {
        this.repository = repository;
        this.canvas = canvas;
    }

	

    public void execute() {
        canvas.redraw(makeRedrawRunnable());
    }

	

    private Runnable makeRedrawRunnable() {
        return new Runnable() {
            public void run() {
                ShapeRenderer renderer = canvas.getShapeRenderer();
                renderShapes(renderer);
            }

            private void renderShapes(ShapeRenderer renderer) {
                Iterator<Shape> it = repository.shapes();
                while (it.hasNext()) {
                    Shape shape = it.next();
                    shape.render(renderer);
                }
            }
        };
    }


}

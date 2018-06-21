package de.tu_bs.cs.isf.spl.simplecad.core.input; 

import de.tu_bs.cs.isf.spl.simplecad.core.builder.BuildShapeStrategy; 
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.Point; 

import java.util.Observable; 
import java.util.Observer; 

public  class  BuildCommand  implements ButtonCommand {
	

    private final BuildShapeStrategy buildShapeStrategy;

	
    private final CanvasRepaintCommand canvasRepaintCommand;

	

    public BuildCommand(BuildShapeStrategy buildShapeStrategy, final CanvasRepaintCommand canvasRepaintCommand) {
        this.buildShapeStrategy = buildShapeStrategy;
        this.canvasRepaintCommand = canvasRepaintCommand;
        this.buildShapeStrategy.addObserver(makeStrategyObserver());
    }

	

    public void execute(int x, int y) {
        if (buildShapeStrategy.hasBuilder())
            buildShapeStrategy.addPoint(new Point(x, y));
    }

	

    private Observer makeStrategyObserver() {
        return new Observer() {
            public void update(Observable o, Object arg) {
                canvasRepaintCommand.execute();
            }
        };
    }


}

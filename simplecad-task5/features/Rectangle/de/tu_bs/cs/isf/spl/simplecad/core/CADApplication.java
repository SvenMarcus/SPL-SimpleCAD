import de.tu_bs.cs.isf.spl.simplecad.core.builder.BuildShapeStrategy;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.BeginDrawTransaction;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.MainWindow;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository;

public class CADApplication {

	private void initialize(ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        original(factory, shapeBuilderFactory);
        mainWindow.addDrawCommand(new BeginDrawTransaction("Rectangle", buildShapeStrategy, shapeBuilderFactory));
    }
	
}

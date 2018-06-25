import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.input.MouseInputHandler;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;
import de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape.ShapeMoveCommand;

public class CADApplication {

	private void initialize(ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        original(factory, shapeBuilderFactory);
        mouseInputHandler.registerDragAndDropPolicy("MOUSE_1", new ShapeMoveCommand(repository, canvasRepaintCommand));
    }
	
}
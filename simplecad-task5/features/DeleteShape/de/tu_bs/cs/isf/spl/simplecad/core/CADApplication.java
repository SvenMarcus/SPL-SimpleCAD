import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.input.MouseInputHandler;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;
import de.tu_bs.cs.isf.spl.simplecad.plugins.delete.DeleteCommand;

public class CADApplication {

	private void initialize(ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        original(factory, shapeBuilderFactory);
        mouseInputHandler.registerClickPolicy("MOUSE_3", new DeleteCommand(repository, canvasRepaintCommand));
    }
	
}
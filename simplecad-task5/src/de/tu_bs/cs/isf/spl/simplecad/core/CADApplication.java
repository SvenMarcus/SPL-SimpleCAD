package de.tu_bs.cs.isf.spl.simplecad.core; 

import de.tu_bs.cs.isf.spl.simplecad.core.builder.BuildShapeStrategy; 
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilder; 
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory; 
import de.tu_bs.cs.isf.spl.simplecad.core.input.BuildCommand; 
import de.tu_bs.cs.isf.spl.simplecad.core.input.MouseInputHandler; 
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.BeginDrawTransaction; 
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand; 
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory; 
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.MainWindow; 
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository; 
import de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape.ShapeMoveCommand; 
import de.tu_bs.cs.isf.spl.simplecad.plugins.delete.DeleteCommand; 
import de.tu_bs.cs.isf.spl.simplecad.plugins.clearshapes.ClearShapesTransaction; 
import de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard.*; 


public   class  CADApplication {
	

    private ShapeRepository repository;

	
    private MainWindow mainWindow;

	
    private ShapeBuilderFactory shapeBuilderFactory;

	
    private MouseInputHandler mouseInputHandler;

	
    private BuildShapeStrategy buildShapeStrategy;

	
    private CanvasRepaintCommand canvasRepaintCommand;

	

    public CADApplication(ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
//        mainWindow = factory.makeMainWindow();
//        this.shapeBuilderFactory = shapeBuilderFactory;
//        repository = new ShapeRepository();
//        buildShapeStrategy = new BuildShapeStrategy(repository);
//        canvasRepaintCommand = new CanvasRepaintCommand(repository, mainWindow.getCanvas());
//        setupMouseInputHandler();
        initialize(factory, shapeBuilderFactory);
    }

	

    public void run() {
        mainWindow.showWindow();
    }

	

    public MouseInputHandler getMouseInputHandler() {
        return mouseInputHandler;
    }

	

    public ShapeRepository getShapeRepository() {
        return repository;
    }

	

    public CanvasRepaintCommand getCanvasRepaintCommand() {
        return canvasRepaintCommand;
    }

	
    
     private void  initialize__wrappee__SimpleCAD  (ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
    	mainWindow = factory.makeMainWindow();
        this.shapeBuilderFactory = shapeBuilderFactory;
        repository = new ShapeRepository();
        buildShapeStrategy = new BuildShapeStrategy(repository);
        canvasRepaintCommand = new CanvasRepaintCommand(repository, mainWindow.getCanvas());
        setupMouseInputHandler();
    }

	

	 private void  initialize__wrappee__Line  (ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        initialize__wrappee__SimpleCAD(factory, shapeBuilderFactory);
        mainWindow.addDrawCommand(new BeginDrawTransaction("Line", buildShapeStrategy, shapeBuilderFactory));
    }

	

	 private void  initialize__wrappee__Rectangle  (ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        initialize__wrappee__Line(factory, shapeBuilderFactory);
        mainWindow.addDrawCommand(new BeginDrawTransaction("Rectangle", buildShapeStrategy, shapeBuilderFactory));
    }

	

	 private void  initialize__wrappee__Node  (ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        initialize__wrappee__Rectangle(factory, shapeBuilderFactory);
        mainWindow.addDrawCommand(new BeginDrawTransaction("Node", buildShapeStrategy, shapeBuilderFactory));
    }

	

	 private void  initialize__wrappee__ShapeMove  (ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        initialize__wrappee__Node(factory, shapeBuilderFactory);
        mouseInputHandler.registerDragAndDropPolicy("MOUSE_1", new ShapeMoveCommand(repository, canvasRepaintCommand));
    }

	

	 private void  initialize__wrappee__DeleteShape  (ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        initialize__wrappee__ShapeMove(factory, shapeBuilderFactory);
        mouseInputHandler.registerClickPolicy("MOUSE_3", new DeleteCommand(repository, canvasRepaintCommand));
    }

	

	 private void  initialize__wrappee__ClearAll  (ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        initialize__wrappee__DeleteShape(factory, shapeBuilderFactory);
        mainWindow.addDrawCommand(new ClearShapesTransaction(repository, canvasRepaintCommand));
    }

	

    private void initialize(ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        initialize__wrappee__ClearAll(factory, shapeBuilderFactory);
        TextField textField = factory.makeTextField();
        KeyboardInputParser parser = new KeyboardInputParser(shapeBuilderFactory, buildShapeStrategy, textField);
        textField.setParser(parser);
        mainWindow.addTextField(textField);
    }

	

    private void setupMouseInputHandler() {
        mouseInputHandler = new MouseInputHandler();
        mainWindow.getCanvas().setMouseInputHandler(mouseInputHandler);
        mouseInputHandler.registerClickPolicy("MOUSE_1", new BuildCommand(buildShapeStrategy, canvasRepaintCommand));
    }


}

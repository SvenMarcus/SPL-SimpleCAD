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

public class CADApplication {

    private final ShapeRepository repository;
    private MainWindow mainWindow;
    private ShapeBuilderFactory shapeBuilderFactory;
    private MouseInputHandler mouseInputHandler;
    private BuildShapeStrategy buildShapeStrategy;
    private CanvasRepaintCommand canvasRepaintCommand;

    public CADApplication(ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        mainWindow = factory.makeMainWindow();
        this.shapeBuilderFactory = shapeBuilderFactory;
        repository = new ShapeRepository();
        buildShapeStrategy = new BuildShapeStrategy(repository);
        canvasRepaintCommand = new CanvasRepaintCommand(repository, mainWindow.getCanvas());
        setupMouseInputHandler();
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }
    
    public BuildShapeStrategy getBuildShapeStrategy() {
    	return buildShapeStrategy;
    }

    public void registerShape(String shapeName, Class<? extends ShapeBuilder> builder) {
        shapeBuilderFactory.registerShapeBuilder(shapeName, builder);
        mainWindow.addDrawCommand(new BeginDrawTransaction(shapeName, buildShapeStrategy, shapeBuilderFactory));
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

    private void setupMouseInputHandler() {
        mouseInputHandler = new MouseInputHandler();
        mainWindow.getCanvas().setMouseInputHandler(mouseInputHandler);
        mouseInputHandler.registerClickPolicy("MOUSE_1", new BuildCommand(buildShapeStrategy, canvasRepaintCommand));
    }


}

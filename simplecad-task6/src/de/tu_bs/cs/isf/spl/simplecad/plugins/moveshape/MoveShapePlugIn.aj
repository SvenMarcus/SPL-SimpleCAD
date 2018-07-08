package de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape;

import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;

privileged public aspect MoveShapePlugIn {
	after(CADApplication app) : execution(CADApplication.new(ComponentFactory, ShapeBuilderFactory)) && target(app){
		app.getMouseInputHandler().registerDragAndDropPolicy("MOUSE_1", new ShapeMoveCommand(app.repository, app.canvasRepaintCommand));
	}
}

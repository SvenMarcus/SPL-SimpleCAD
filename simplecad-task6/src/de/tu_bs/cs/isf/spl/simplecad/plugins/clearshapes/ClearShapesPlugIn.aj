package de.tu_bs.cs.isf.spl.simplecad.plugins.clearshapes;

import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;

privileged public aspect ClearShapesPlugIn {
	after(CADApplication app) : execution(CADApplication.new(ComponentFactory, ShapeBuilderFactory)) && target(app){
		app.mainWindow.addDrawCommand(new ClearShapesTransaction(app.repository, app.canvasRepaintCommand));
	}
}

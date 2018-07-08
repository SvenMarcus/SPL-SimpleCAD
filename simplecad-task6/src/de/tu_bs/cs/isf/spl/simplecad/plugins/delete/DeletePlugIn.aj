package de.tu_bs.cs.isf.spl.simplecad.plugins.delete;

import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;

privileged public aspect DeletePlugIn {

	after(CADApplication app) : execution(CADApplication.new(ComponentFactory, ShapeBuilderFactory)) && target(app){
		app.getMouseInputHandler().registerClickPolicy("MOUSE_3", new DeleteCommand(app.repository, app.canvasRepaintCommand));
	}
}

package de.tu_bs.cs.isf.spl.simplecad.plugins.line;

import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilder;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactoryImpl;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.BeginDrawTransaction;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;

privileged public aspect LinePlugIn {
	
	after(CADApplication app) : execution(CADApplication.new(ComponentFactory, ShapeBuilderFactory)) && target(app){
		app.mainWindow.addDrawCommand(new BeginDrawTransaction("Line", app.buildShapeStrategy, app.shapeBuilderFactory));
	}
	
	ShapeBuilder around(String type) : execution(ShapeBuilder ShapeBuilderFactoryImpl.makeShapeBuilder(String)) && args(type) {
		if(type.equals("Line"))
			return new LineBuilder();
		return proceed(type);
	}
}

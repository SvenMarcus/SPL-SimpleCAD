package de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle;

import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilder;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactoryImpl;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.BeginDrawTransaction;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;


privileged public aspect RectanglePlugIn {

	after(CADApplication app) : execution(CADApplication.new(ComponentFactory, ShapeBuilderFactory)) && target(app){
		app.mainWindow.addDrawCommand(new BeginDrawTransaction("Rectangle", app.buildShapeStrategy, app.shapeBuilderFactory));
	}
	
	ShapeBuilder around(String type) : execution(ShapeBuilder ShapeBuilderFactoryImpl.makeShapeBuilder(String)) && args(type) {
		if(type.equals("Rectangle"))
			return new RectangleBuilder();
		return proceed(type);
	}
	
}

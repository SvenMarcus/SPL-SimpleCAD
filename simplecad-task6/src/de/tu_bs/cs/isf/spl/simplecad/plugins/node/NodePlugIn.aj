package de.tu_bs.cs.isf.spl.simplecad.plugins.node;

import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilder;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactoryImpl;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.BeginDrawTransaction;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;

privileged public aspect NodePlugIn {
	
	after(CADApplication app) : execution(CADApplication.new(ComponentFactory, ShapeBuilderFactory)) && target(app){
		app.mainWindow.addDrawCommand(new BeginDrawTransaction("Node", app.buildShapeStrategy, app.shapeBuilderFactory));
	}
	
	ShapeBuilder around(String type) : execution(ShapeBuilder ShapeBuilderFactoryImpl.makeShapeBuilder(String)) && args(type) {
		if(type.equals("Node"))
			return new NodeBuilder();
		return proceed(type);
	}
}

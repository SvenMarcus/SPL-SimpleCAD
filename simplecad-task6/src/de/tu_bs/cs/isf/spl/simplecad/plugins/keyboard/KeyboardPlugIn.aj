package de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard;

import java.awt.BorderLayout;

import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.MainWindow;
import de.tu_bs.cs.isf.spl.simplecad.impl.SwingComponentFactory;
import de.tu_bs.cs.isf.spl.simplecad.impl.SwingMainWindow;

privileged public aspect KeyboardPlugIn {
	public abstract TextField ComponentFactory.makeTextField();
	
	public TextField SwingComponentFactory.makeTextField() {
		return new SwingTextField();
	}
	
	public abstract void MainWindow.addTextField(TextField textField);	
	
	public void SwingMainWindow.addTextField(TextField textField) {
		add((SwingTextField) textField, BorderLayout.SOUTH);
	}
	
	after(CADApplication app, ComponentFactory factory) : execution(CADApplication.new(ComponentFactory,ShapeBuilderFactory)) && target(app) && args(factory, *){
		TextField textField = ((SwingComponentFactory)factory).makeTextField();
        KeyboardInputParser parser = new KeyboardInputParser(app.shapeBuilderFactory, app.buildShapeStrategy, textField);
        textField.setParser(parser);
        app.mainWindow.addTextField(textField);
	}
}
	
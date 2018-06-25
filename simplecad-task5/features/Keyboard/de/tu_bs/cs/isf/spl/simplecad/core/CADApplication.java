package de.tu_bs.cs.isf.spl.simplecad.core;

import de.tu_bs.cs.isf.spl.simplecad.core.builder.BuildShapeStrategy;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory;
import de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard.*;


public class CADApplication {

    private void initialize(ComponentFactory factory, ShapeBuilderFactory shapeBuilderFactory) {
        original(factory, shapeBuilderFactory);
        TextField textField = factory.makeTextField();
        KeyboardInputParser parser = new KeyboardInputParser(shapeBuilderFactory, buildShapeStrategy, textField);
        textField.setParser(parser);
        mainWindow.addTextField(textField);
    }


}

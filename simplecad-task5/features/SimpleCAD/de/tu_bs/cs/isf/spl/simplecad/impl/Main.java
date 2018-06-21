package de.tu_bs.cs.isf.spl.simplecad.impl;

import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactoryImpl;
import de.tu_bs.cs.isf.spl.simplecad.impl.*;




public class Main {
    public static void main(String[] args) {
        SwingComponentFactory factory = new SwingComponentFactory();
        ShapeBuilderFactoryImpl shapeBuilderFactory = new ShapeBuilderFactoryImpl();
        CADApplication app = new CADApplication(factory, shapeBuilderFactory);

        app.run();
    }
}
				
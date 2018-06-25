package de.tu_bs.cs.isf.spl.simplecad.core.mainwindow; 

import de.tu_bs.cs.isf.spl.simplecad.core.builder.BuildShapeStrategy; 
import de.tu_bs.cs.isf.spl.simplecad.core.builder.ShapeBuilderFactory; 

public  class  BeginDrawTransaction  implements Transaction {
	

    private final ShapeBuilderFactory builderFactory;

	
    private final String type;

	
    private BuildShapeStrategy shapeStrategy;

	

    public BeginDrawTransaction(String type, BuildShapeStrategy shapeStrategy, ShapeBuilderFactory factory) {
        this.type = type;
        this.shapeStrategy = shapeStrategy;
        this.builderFactory = factory;
    }

	

    public void execute() {
        shapeStrategy.setShapeBuilder(builderFactory.makeShapeBuilder(type));
    }

	

    public String getName() {
        return type;
    }


}

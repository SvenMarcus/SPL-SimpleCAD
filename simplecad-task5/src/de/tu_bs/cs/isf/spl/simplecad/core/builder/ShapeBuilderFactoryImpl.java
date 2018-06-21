package de.tu_bs.cs.isf.spl.simplecad.core.builder; 

import java.util.HashMap; 
import java.util.Map; 

import de.tu_bs.cs.isf.spl.simplecad.plugins.line.LineBuilder; 

import de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle.RectangleBuilder; 

import de.tu_bs.cs.isf.spl.simplecad.plugins.node.NodeBuilder; 

public   class  ShapeBuilderFactoryImpl  implements ShapeBuilderFactory {
	

    private Map<String, Class<? extends ShapeBuilder>> builderMap = new HashMap<String, Class<? extends ShapeBuilder>>();

	

    public ShapeBuilderFactoryImpl  () {
	
    	builderMap.put("Line", LineBuilder.class);
    
    	builderMap.put("Rectangle", RectangleBuilder.class);
    
    	builderMap.put("Node", NodeBuilder.class);
    }

	

    @Override
    public ShapeBuilder makeShapeBuilder(String shapeBuilder) {
        Class<? extends ShapeBuilder> clazz = builderMap.get(shapeBuilder);
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}

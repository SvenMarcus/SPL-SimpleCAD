package de.tu_bs.cs.isf.spl.simplecad.core.builder;

import java.util.HashMap;
import java.util.Map;

public class ShapeBuilderFactoryImpl implements ShapeBuilderFactory {

    private Map<String, Class<? extends ShapeBuilder>> builderMap = new HashMap<String, Class<? extends ShapeBuilder>>();
    
    public public ShapeBuilderFactoryImpl() {
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

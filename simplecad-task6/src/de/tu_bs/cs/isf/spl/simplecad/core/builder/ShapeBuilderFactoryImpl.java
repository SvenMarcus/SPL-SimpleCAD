package de.tu_bs.cs.isf.spl.simplecad.core.builder;

import java.util.HashMap;
import java.util.Map;

public class ShapeBuilderFactoryImpl implements ShapeBuilderFactory {

    private Map<String, Class<? extends ShapeBuilder>> builderMap = new HashMap<String, Class<? extends ShapeBuilder>>();

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

    public void registerShapeBuilder(String shapeName, Class<? extends ShapeBuilder> builderClass) {
        builderMap.put(shapeName, builderClass);
    }
}

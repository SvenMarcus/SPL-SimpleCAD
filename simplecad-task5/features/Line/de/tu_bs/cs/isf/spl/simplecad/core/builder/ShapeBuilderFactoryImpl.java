package de.tu_bs.cs.isf.spl.simplecad.core.builder;

import java.util.HashMap;
import java.util.Map;

import de.tu_bs.cs.isf.spl.simplecad.plugins.line.LineBuilder;

public class ShapeBuilderFactoryImpl implements ShapeBuilderFactory {
	
    public ShapeBuilderFactoryImpl() {
    	builderMap.put("Line", LineBuilder.class);
    }
}

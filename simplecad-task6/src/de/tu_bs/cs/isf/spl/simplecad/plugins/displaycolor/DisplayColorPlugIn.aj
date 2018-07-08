package de.tu_bs.cs.isf.spl.simplecad.plugins.displaycolor;

import java.awt.Color;
import java.util.Random;

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ShapeRenderer;
import de.tu_bs.cs.isf.spl.simplecad.impl.SwingShapeRenderer;


privileged public aspect DisplayColorPlugIn {

	public abstract void ShapeRenderer.setColor(Color c);
	
	public void SwingShapeRenderer.setColor(Color c) {
		graphics.setColor(c);
	}
	
	before(ShapeRenderer renderer) : call(* ShapeRenderer.*(..)) && !call(void ShapeRenderer.setColor(Color)) && target(renderer) {
		Random rand = new Random();
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);
		Color c = new Color(r, g, b);
		renderer.setColor(c);
	}
}

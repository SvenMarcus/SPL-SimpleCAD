package de.tu_bs.cs.isf.spl.simplecad.impl; 

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ShapeRenderer; 

import java.awt.*; 

 

class  SwingShapeRenderer  implements ShapeRenderer {
	

    private Graphics graphics;

	

    void setGraphics(Graphics g) {
        this.graphics = g;
    }

	

    public void renderLine(final int x1, final int y1, final int x2, final int y2) {
        graphics.drawLine(x1, y1, x2, y2);
    }

	

    public void renderRectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        int width = Math.abs(topLeftX - bottomRightX);
        int height = Math.abs(topLeftY - bottomRightY);
        graphics.drawRect(topLeftX, topLeftY, width, height);
    }

	

    public void renderNode(int x, int y) {
        graphics.drawLine(x - 5, y + 5, x + 5, y - 5);
        graphics.drawLine(x - 5, y - 5, x + 5, y + 5);
    }


}

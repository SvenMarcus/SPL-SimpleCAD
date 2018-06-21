package de.tu_bs.cs.isf.spl.simplecad.impl; 

import de.tu_bs.cs.isf.spl.simplecad.core.input.MouseInputHandler; 
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.Canvas; 
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ShapeRenderer; 

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.awt.event.MouseMotionListener; 

public  class  SwingCanvas  extends JPanel  implements Canvas, MouseListener, MouseMotionListener {
	

    private MouseInputHandler mouseInputHandler;

	
    private Runnable runnable;

	
    private SwingShapeRenderer renderer;

	

    public SwingCanvas() {
        this.renderer = new SwingShapeRenderer();
    }

	

    @Override
    public void setMouseInputHandler(MouseInputHandler inputHandler) {
        mouseInputHandler = inputHandler;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

	


    public void mouseClicked(MouseEvent e) {

    }

	

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            mouseInputHandler.click(e.getX(), e.getY(), "MOUSE_1");
        else if (e.getButton() == MouseEvent.BUTTON3)
            mouseInputHandler.click(e.getX(), e.getY(), "MOUSE_3");
    }

	

    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            mouseInputHandler.release(e.getX(), e.getY(), "MOUSE_1");
        } else if (SwingUtilities.isRightMouseButton(e))
            mouseInputHandler.release(e.getX(), e.getY(), "MOUSE_3");
    }

	

    public void mouseEntered(MouseEvent e) {
    }

	

    public void mouseExited(MouseEvent e) {

    }

	

    public void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            mouseInputHandler.drag(e.getX(), e.getY(), "MOUSE_1");
        } else if (SwingUtilities.isRightMouseButton(e))
            mouseInputHandler.drag(e.getX(), e.getY(), "MOUSE_3");
    }

	

    public void mouseMoved(MouseEvent e) {
    }

	


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderShapes(g);
    }

	

    private void renderShapes(Graphics g) {
        renderer.setGraphics(g);
        if (runnable != null)
            runnable.run();
    }

	

    public void redraw(Runnable runnable) {
        this.runnable = runnable;
        repaint();
    }

	

    public ShapeRenderer getShapeRenderer() {
        return renderer;
    }


}

package de.tu_bs.cs.isf.spl.simplecad.view;

import de.tu_bs.cs.isf.spl.simplecad.presentation.MouseInputHandler;
import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Canvas extends JPanel implements de.tu_bs.cs.isf.spl.simplecad.presentation.Canvas, MouseListener, MouseMotionListener {

    private MouseInputHandler presenter;
    private Runnable runnable;
    private SwingShapeRenderer renderer;


    public void setPresenter(final MouseInputHandler presenter) {
        this.presenter = presenter;
        this.renderer = new SwingShapeRenderer();
        addMouseListener(this);
    }


    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            presenter.click(e.getX(), e.getY(), "MOUSE_1");
        else if (e.getButton() == MouseEvent.BUTTON3)
            presenter.click(e.getX(), e.getY(), "MOUSE_3");
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderLines(g);

    }

    private void renderLines(Graphics g) {
        renderer.setGraphics(g);
        runnable.run();
    }

    public void redraw(Runnable runnable) {
        repaint();
        this.runnable = runnable;
    }

    public ShapeRenderer getShapeRenderer() {
        return renderer;
    }
}

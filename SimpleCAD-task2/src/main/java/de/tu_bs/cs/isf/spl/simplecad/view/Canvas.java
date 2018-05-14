package de.tu_bs.cs.isf.spl.simplecad.view;

import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import de.tu_bs.cs.isf.spl.simplecad.presentation.CanvasPresenter;
import de.tu_bs.cs.isf.spl.simplecad.presentation.ShapeRenderer;

public class Canvas extends JPanel implements de.tu_bs.cs.isf.spl.simplecad.presentation.Canvas, MouseListener, MouseMotionListener {

    private CanvasPresenter presenter;
    private Runnable runnable;
    private SwingShapeRenderer renderer;


    public void setPresenter(final CanvasPresenter presenter) {
        this.presenter = presenter;
        this.renderer = new SwingShapeRenderer();
        addMouseListener(this);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                presenter.repaint();
            }
        });
    }


    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        presenter.click(e.getX(), e.getY());
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

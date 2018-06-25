package de.tu_bs.cs.isf.spl.simplecad.plugins.moveshape;

import de.tu_bs.cs.isf.spl.simplecad.core.model.Point;
import de.tu_bs.cs.isf.spl.simplecad.plugins.line.Line;
import de.tu_bs.cs.isf.spl.simplecad.plugins.line.LineVisitor;
import de.tu_bs.cs.isf.spl.simplecad.plugins.node.Node;
import de.tu_bs.cs.isf.spl.simplecad.plugins.node.NodeVisitor;
import de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle.Rectangle;
import de.tu_bs.cs.isf.spl.simplecad.plugins.rectangle.RectangleVisitor;

public class ShapeMover implements LineVisitor, NodeVisitor, RectangleVisitor {

    private int dx;
    private int dy;

    public void setMoveDistance(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void visit(Line line) {
        Point point = line.getFirst();
        line.setFirst(new Point(point.getX() + dx, point.getY() + dy));

        point = line.getSecond();
        line.setSecond(new Point(point.getX() + dx, point.getY() + dy));
    }

    public void visit(Node node) {
        Point point = node.getPoint();
        node.setPoint(new Point(point.getX() + dx, point.getY() + dy));
    }

    public void visit(Rectangle rectangle) {
        Point point = rectangle.getFirst();
        rectangle.setFirst(new Point(point.getX() + dx, point.getY() + dy));

        point = rectangle.getSecond();
        rectangle.setSecond(new Point(point.getX() + dx, point.getY() + dy));
    }
}

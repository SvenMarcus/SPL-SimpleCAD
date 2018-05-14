package de.tu_bs.cs.isf.spl.simplecad.presentation;

public class ShapeRendererSpy implements ShapeRenderer {

    private String previousShape = "";
    private String lastShape = "";
    private int x1 = -1;
    private int y1 = -1;
    private int x2 = -1;
    private int y2 = -1;
    private int previousX1 = -1;
    private int previousY1 = -1;
    private int previousX2 = -1;
    private int previousY2 = -1;
    private boolean rendered;


    public void resetSpy() {
        rendered = false;
        x1 = -1;
        y1 = -1;
        x2 = -1;
        y2 = -1;
        previousX1 = -1;
        previousY1 = -1;
        previousX2 = -1;
        previousY2 = -1;
        previousShape = "";
        lastShape = "";
    }

    public boolean renderedLine() {
        return rendered;
    }

    public boolean renderedLastLineWith(int x1, int y1, int x2, int y2) {
        return lastShape.equals("Line") && this.x1 == x1 && this.y1 == y1 && this.x2 == x2 && this.y2 == y2;
    }

    public boolean renderedPreviousLineWith(int x1, int y1, int x2, int y2) {
        return lastShape.equals("Line") && this.previousX1 == x1 && this.previousY1 == y1 && this.previousX2 == x2 && this.previousY2 == y2;
    }

    public boolean renderedLastRectangleWith(int x1, int y1, int x2, int y2) {
        return lastShape.equals("Rectangle") && this.x1 == x1 && this.y1 == y1 && this.x2 == x2 && this.y2 == y2;
    }

    public boolean renderedNodeAt(int x, int y) {
        return lastShape.equals("Node") && this.x1 == x && this.y1 == y;
    }

    public void renderLine(int x1, int y1, int x2, int y2) {
        previousShape = lastShape;
        lastShape = "Line";
        rendered = true;
        previousX1 = this.x1;
        previousY1 = this.y1;
        previousX2 = this.x2;
        previousY2 = this.y2;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void renderRectangle(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        previousShape = lastShape;
        lastShape = "Rectangle";
        rendered = true;
        previousX1 = this.x1;
        previousY1 = this.y1;
        previousX2 = this.x2;
        previousY2 = this.y2;
        this.x1 = topLeftX;
        this.y1 = topLeftY;
        this.x2 = bottomRightX;
        this.y2 = bottomRightY;
    }

    public void renderNode(int x, int y) {
        previousShape = lastShape;
        lastShape = "Node";
        rendered = true;
        previousX1 = this.x1;
        previousY1 = this.y1;
        previousX2 = this.x2;
        previousY2 = this.y2;
        this.x1 = x;
        this.y1 = y;
        this.x2 = -1;
        this.y2 = -1;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getPreviousX1() {
        return previousX1;
    }

    public int getPreviousY1() {
        return previousY1;
    }

    public int getPreviousX2() {
        return previousX2;
    }

    public int getPreviousY2() {
        return previousY2;
    }


}

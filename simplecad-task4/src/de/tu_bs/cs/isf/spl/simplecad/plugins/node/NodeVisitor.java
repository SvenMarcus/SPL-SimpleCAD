package de.tu_bs.cs.isf.spl.simplecad.plugins.node;

import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeVisitor;

public interface NodeVisitor extends ShapeVisitor {
    void visit(Node node);
}

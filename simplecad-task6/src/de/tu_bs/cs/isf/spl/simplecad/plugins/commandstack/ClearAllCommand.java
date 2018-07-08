package de.tu_bs.cs.isf.spl.simplecad.plugins.commandstack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository;

public class ClearAllCommand implements Command {
	private ShapeRepository repository;
	private CanvasRepaintCommand repaintCommand;

	private List<Shape> shapes = new ArrayList<Shape>();

	public ClearAllCommand(ShapeRepository repository, CanvasRepaintCommand repaintCommand) {
		this.repository = repository;
		this.repaintCommand = repaintCommand;
	}

	@Override
	public void execute() {
		Iterator<Shape> it = repository.shapes();
		while (it.hasNext())
			shapes.add(it.next());

		repository.clear();
		repaintCommand.execute();
	}

	@Override
	public void undo() {
		for (Shape shape : shapes)
			repository.addShape(shape);
		repaintCommand.execute();
	}
}

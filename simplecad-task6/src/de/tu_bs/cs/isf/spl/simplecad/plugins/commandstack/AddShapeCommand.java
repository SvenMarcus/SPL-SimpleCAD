package de.tu_bs.cs.isf.spl.simplecad.plugins.commandstack;

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository;

public class AddShapeCommand implements Command {
	private ShapeRepository repository;
	private Shape shape;
	private CanvasRepaintCommand repaintCommand;

	public AddShapeCommand(ShapeRepository repository, Shape shape, CanvasRepaintCommand repaintCommand) {
		this.repository = repository;
		this.shape = shape;
		this.repaintCommand = repaintCommand;
	}

	@Override
	public void execute() {
		System.out.println("Executing AddShapeCommand");
		repository.addShape(shape);
		repaintCommand.execute();
	}

	@Override
	public void undo() {
		repository.removeShape(shape);
		repaintCommand.execute();
	}
	
	
}

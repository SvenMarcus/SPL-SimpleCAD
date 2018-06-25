package de.tu_bs.cs.isf.spl.simplecad.plugins.clearshapes;

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.Transaction;

public class ClearShapesTransaction implements Transaction {
	
	private ShapeRepository repository;
	private CanvasRepaintCommand canvasRepaintCommand;
	
	public ClearShapesTransaction  (ShapeRepository repository, CanvasRepaintCommand canvasRepaintCommand) {
		this.repository = repository;
		this.canvasRepaintCommand = canvasRepaintCommand;
    }
	
	public void execute() {
		repository.clear();
		canvasRepaintCommand.execute();
	}
	
	public String getName() {
		return "Clear Shapes";
	}
	
}
package de.tu_bs.cs.isf.spl.simplecad.plugins.commandstack;

import org.aspectj.lang.ProceedingJoinPoint;

import de.tu_bs.cs.isf.spl.simplecad.core.CADApplication;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.CanvasRepaintCommand;
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.Transaction;
import de.tu_bs.cs.isf.spl.simplecad.core.model.Shape;
import de.tu_bs.cs.isf.spl.simplecad.core.model.ShapeRepository;

privileged public aspect CommandStackPlugIn {

	private CommandStack commandStack = new CommandStack();
	private CanvasRepaintCommand repaintCommand;

	after(CADApplication app) : execution(CADApplication.new(*,*)) && target(app) {
		repaintCommand = app.getCanvasRepaintCommand();
		app.mainWindow.addDrawCommand(new Transaction() {

			@Override
			public String getName() {
				return "Undo";
			}

			@Override
			public void execute() {
				commandStack.undo();
			}
		});

		app.mainWindow.addDrawCommand(new Transaction() {

			@Override
			public String getName() {
				return "Redo";
			}

			@Override
			public void execute() {
				commandStack.redo();
			}
		});
	}

	private boolean capture = true;

	pointcut shapeAdded(ShapeRepository repository, Shape shape) : execution(void ShapeRepository.addShape(Shape)) && target(repository) && args(shape);

	pointcut shapeRemoved(ShapeRepository repository, Shape shape) : execution(void ShapeRepository.removeShape(Shape)) && target(repository) && args(shape);

	pointcut clearAll(ShapeRepository repository) : execution(void ShapeRepository.clear()) && target(repository);

	before() : call(void ShapeRepository.addShape(Shape)) || call(void ShapeRepository.removeShape(Shape)) || call(void ShapeRepository.clear()){
		if(thisJoinPoint.getThis() instanceof Command)
			capture = false;
		else
			capture = true;
	}
	
	void around(ShapeRepository repository, Shape shape) : shapeAdded(repository, shape) {
		System.out.println(thisJoinPoint.getThis());
		if (capture) {
			System.out.println(repository);
			commandStack.addCommand(new AddShapeCommand(repository, shape, repaintCommand));
		} else {
			proceed(repository, shape);
		}
	}

	void around(ShapeRepository repository, Shape shape) : shapeRemoved(repository, shape) {
		if (capture) {
			commandStack.addCommand(new DeleteShapeCommand(repository, shape, repaintCommand));
		} else {
			proceed(repository, shape);
		}
	}

	void around(ShapeRepository repository) : clearAll(repository) {
		if (capture) {
			commandStack.addCommand(new ClearAllCommand(repository, repaintCommand));
		} else {
			proceed(repository);
		}
	}
}

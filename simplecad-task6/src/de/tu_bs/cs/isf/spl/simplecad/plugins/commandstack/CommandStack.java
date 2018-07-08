package de.tu_bs.cs.isf.spl.simplecad.plugins.commandstack;

import java.util.Stack;

public class CommandStack {

	private Stack<Command> undoCommands = new Stack<Command>();
	private Stack<Command> redoCommands = new Stack<Command>();
	
	public void addCommand(Command command) {
		System.out.println("Adding command");
		command.execute();
		undoCommands.add(command);
		redoCommands.clear();
	}
	
	public void undo() {
		if(undoCommands.isEmpty())
			return;
		Command command = undoCommands.pop();
		command.undo();
		
		redoCommands.add(command);
	}
	
	public void redo() {
		if(redoCommands.isEmpty())
			return;
		Command command = redoCommands.pop();
		command.execute();
		undoCommands.add(command);
	}
	
}

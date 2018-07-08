package de.tu_bs.cs.isf.spl.simplecad.plugins.commandstack;

public interface Command {

	void execute();

	void undo();
}

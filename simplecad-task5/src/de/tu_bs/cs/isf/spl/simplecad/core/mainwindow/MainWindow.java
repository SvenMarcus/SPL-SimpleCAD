package de.tu_bs.cs.isf.spl.simplecad.core.mainwindow; 

import de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard.TextField; 

public   interface  MainWindow {
	
    void addDrawCommand(Transaction transaction);

	

    Canvas getCanvas();

	

    void showWindow();

	
    void addTextField(TextField textField);


}

package de.tu_bs.cs.isf.spl.simplecad.core.mainwindow; 

import de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard.TextField; 

public   interface  ComponentFactory {
	
    MainWindow makeMainWindow();

	
    TextField makeTextField();


}

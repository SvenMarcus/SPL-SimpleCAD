package de.tu_bs.cs.isf.spl.simplecad.impl; 

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.ComponentFactory; 
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.MainWindow; 

public  class  SwingComponentFactory  implements ComponentFactory {
	
    @Override
    public MainWindow makeMainWindow() {
        return new SwingMainWindow("Simple CAD");
    }


}

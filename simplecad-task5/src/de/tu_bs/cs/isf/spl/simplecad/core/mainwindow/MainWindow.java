package de.tu_bs.cs.isf.spl.simplecad.core.mainwindow; 

public  interface  MainWindow {
	
    void addDrawCommand(BeginDrawTransaction transaction);

	

    Canvas getCanvas();

	

    void showWindow();


}

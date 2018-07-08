package de.tu_bs.cs.isf.spl.simplecad.core.mainwindow;

public interface MainWindow {
    void addDrawCommand(Transaction transaction);

    Canvas getCanvas();

    void showWindow();
}

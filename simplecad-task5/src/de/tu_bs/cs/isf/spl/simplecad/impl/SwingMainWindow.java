package de.tu_bs.cs.isf.spl.simplecad.impl; 

import de.tu_bs.cs.isf.spl.simplecad.core.input.MouseInputHandler; 

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.Transaction; 
import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.Canvas; 

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.MainWindow; 

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import java.awt.BorderLayout; 
import java.awt.HeadlessException; 

import javax.swing.JFrame; 
import de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard.TextField; 

public   class  SwingMainWindow  extends JFrame  implements MainWindow {
	
    private SwingCanvas canvas;

	
    private JToolBar toolBar;

	

    public SwingMainWindow(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(createToolBar(), BorderLayout.NORTH);
        add(createCanvas(), BorderLayout.CENTER);
        setSize(800, 600);
    }

	

    @Override
    public void showWindow() {
        setVisible(true);
    }

	

    public void setMouseInputHandler(MouseInputHandler inputHandler) {
        canvas.setMouseInputHandler(inputHandler);
    }

	

    @Override
    public void addDrawCommand(final Transaction transaction) {
        JButton lineButton = new JButton(transaction.getName());
        lineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                transaction.execute();
            }
        });
        toolBar.add(lineButton);
    }

	

    public Canvas getCanvas() {
        return canvas;
    }

	

    private JToolBar createToolBar() {
        toolBar = new JToolBar();
        return toolBar;
    }

	

    private SwingCanvas createCanvas() {
        canvas = new SwingCanvas();
        canvas.setBackground(Color.GRAY);
        return canvas;
    }

	

	public void addTextField(TextField textField) {
		add((SwingTextField) textField, BorderLayout.SOUTH);
	}


}

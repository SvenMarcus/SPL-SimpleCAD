package de.tu_bs.cs.isf.spl.simplecad.impl;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import de.tu_bs.cs.isf.spl.simplecad.core.mainwindow.MainWindow;
import de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard.TextField;

public class SwingMainWindow extends JFrame implements MainWindow {

	public void addTextField(TextField textField) {
		add((SwingTextField) textField, BorderLayout.SOUTH);
	}
}
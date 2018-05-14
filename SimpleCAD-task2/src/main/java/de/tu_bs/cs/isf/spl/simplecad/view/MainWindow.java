package de.tu_bs.cs.isf.spl.simplecad.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;

import de.tu_bs.cs.isf.spl.simplecad.presentation.BeginDrawTransaction;
import de.tu_bs.cs.isf.spl.simplecad.presentation.CanvasPresenter;

public class MainWindow extends JFrame {


    private Canvas canvas;
    private JToolBar toolBar;

    public MainWindow(String title) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout());
        add(createToolBar(), BorderLayout.NORTH);
        add(createCanvas(), BorderLayout.CENTER);
        setSize(800, 600);
    }

    public void setCanvasPresenter(CanvasPresenter presenter) {
        canvas.setPresenter(presenter);
    }

    public void addToolBarCommand(final BeginDrawTransaction transaction) {
        JButton lineButton = new JButton(transaction.getShapeType());
        lineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                transaction.execute();
            }
        });
        toolBar.add(lineButton);
    }

    private Canvas getCanvas() {
        return canvas;
    }

    private JToolBar createToolBar() {
        toolBar = new JToolBar();
        return toolBar;
    }

    private Canvas createCanvas() {
        canvas = new Canvas();
        canvas.setBackground(Color.GRAY);
        return canvas;
    }

    public static void main(String[] args) {
        boolean rectangles = false;
        boolean nodes = false;

        for (String arg : args) {
            System.out.println(arg);
            if (arg.equals("rectangles"))
                rectangles = true;
            else if (arg.equals("nodes"))
                nodes = true;
        }

        MainWindow mainWindow = new MainWindow("Simple CAD");
        CanvasPresenter presenter = new CanvasPresenter(mainWindow.getCanvas());

        BeginDrawTransaction lineTransaction = new BeginDrawTransaction("Line", presenter);
        mainWindow.addToolBarCommand(lineTransaction);

        if (rectangles) {
            BeginDrawTransaction rectangleTransaction = new BeginDrawTransaction("Rectangle", presenter);
            mainWindow.addToolBarCommand(rectangleTransaction);
        }
        
        if (nodes) {
            BeginDrawTransaction nodeTransaction = new BeginDrawTransaction("Node", presenter);
            mainWindow.addToolBarCommand(nodeTransaction);
        }

        mainWindow.setCanvasPresenter(presenter);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }


}

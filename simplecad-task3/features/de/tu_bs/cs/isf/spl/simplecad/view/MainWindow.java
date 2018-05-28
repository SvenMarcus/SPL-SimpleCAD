package de.tu_bs.cs.isf.spl.simplecad.view;

import de.tu_bs.cs.isf.spl.simplecad.presentation.*;
import de.tu_bs.cs.isf.spl.simplecad.presentation.buttonpolicies.BuildCommand;
import de.tu_bs.cs.isf.spl.simplecad.presentation.buttonpolicies.DeleteCommand;
import de.tu_bs.cs.isf.spl.simplecad.presentation.textinput.KeyboardInputParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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

    public void setCanvasPresenter(MouseInputHandler presenter) {
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
        ShapeRepository repository = new ShapeRepository();
        BuildShapeStrategy buildShapeStrategy = new BuildShapeStrategy(repository);

        MainWindow mainWindow = new MainWindow("Simple CAD");
        final CanvasRepaintCommand canvasRepaintCommand = new CanvasRepaintCommand(repository, mainWindow.getCanvas());
        mainWindow.getCanvas().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                canvasRepaintCommand.execute();
            }
        });
        MouseInputHandler mouseInputHandler = new MouseInputHandler();

        mouseInputHandler.registerButtonPolicy("MOUSE_1", new BuildCommand(buildShapeStrategy, canvasRepaintCommand));

        /* if[DeleteShape] */
        mouseInputHandler.registerButtonPolicy("MOUSE_3", new DeleteCommand(repository, canvasRepaintCommand));
        /* end[DeleteShape] */

        /* if[Line] */
        BeginDrawTransaction lineTransaction = new BeginDrawTransaction("Line", buildShapeStrategy);
        mainWindow.addToolBarCommand(lineTransaction);
        /* end[Line] */

        /* if[Rectange] */
        BeginDrawTransaction rectangleTransaction = new BeginDrawTransaction("Rectangle", buildShapeStrategy);
        mainWindow.addToolBarCommand(rectangleTransaction);
        /* end[Rectange] */

        /* if[Node] */
        BeginDrawTransaction nodeTransaction = new BeginDrawTransaction("Node", buildShapeStrategy);
        mainWindow.addToolBarCommand(nodeTransaction);
        /* end[Node] */

        /* if[Keyboard] */
        KeyBoardInput console = new KeyBoardInput();
        KeyboardInputParser parser = new KeyboardInputParser(new ShapeBuilderFactoryImpl(), buildShapeStrategy, console);
        console.setParser(parser);
        mainWindow.add(console, BorderLayout.SOUTH);
        /* end[Keyboard] */

        mainWindow.setCanvasPresenter(mouseInputHandler);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);
    }


}

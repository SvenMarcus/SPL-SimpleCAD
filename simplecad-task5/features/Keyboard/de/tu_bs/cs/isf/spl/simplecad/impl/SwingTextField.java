package de.tu_bs.cs.isf.spl.simplecad.impl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard.*;

public class SwingTextField extends JPanel implements de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard.TextField {

    private final JTextField input;
    private final JLabel output;
    private final JButton send;
    private KeyboardInputParser parser;

    public SwingTextField() {
        setLayout(new BorderLayout());
        input = new JTextField();
        output = new JLabel();
        send = new JButton("Execute");
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parser.process(input.getText());
            }
        });
        add(input, BorderLayout.CENTER);
        add(output, BorderLayout.NORTH);
        add(send, BorderLayout.SOUTH);
    }

    public void setParser(KeyboardInputParser parser) {
        this.parser = parser;
    }

    public void setText(String text) {
        output.setText(text);
    }

    public void clear() {
        input.setText("");
        output.setText("");
    }
}

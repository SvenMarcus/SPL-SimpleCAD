package de.tu_bs.cs.isf.spl.simplecad.view;

import de.tu_bs.cs.isf.spl.simplecad.presentation.textinput.KeyboardInputParser;
import de.tu_bs.cs.isf.spl.simplecad.presentation.textinput.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyBoardInput extends JPanel implements TextField {

    private final JTextField input;
    private final JLabel output;
    private final JButton send;
    private KeyboardInputParser parser;

    public KeyBoardInput() {
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

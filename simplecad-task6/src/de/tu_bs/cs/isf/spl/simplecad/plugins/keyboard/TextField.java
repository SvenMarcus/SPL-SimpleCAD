package de.tu_bs.cs.isf.spl.simplecad.plugins.keyboard;

public interface TextField {
    void setText(String text);
    void clear();
    void setParser(KeyboardInputParser parser);
}

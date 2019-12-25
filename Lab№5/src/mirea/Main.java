package mirea;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Wreath");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100,100);

        frame.setSize(400,400);
        frame.add(new Panel());

        frame.setVisible(true);
    }
}

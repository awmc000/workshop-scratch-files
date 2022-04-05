package com.school;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;

public class HiLoGui {
    private int theNum;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hi-Lo Game");
        JTextField enterNum = new JTextField("Enter here");
        JLabel gameText = new JLabel("Enter a number!");
        JButton button = new JButton("Guess");

        frame.setLayout(new GridBagLayout());
        GridBagConstraints layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        frame.add(gameText,layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10,10,10,10);
        frame.add(enterNum,layoutConst);


        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10,10,10,10);
        frame.add(button,layoutConst);

        frame.pack();
        frame.setVisible(true);
    }
}

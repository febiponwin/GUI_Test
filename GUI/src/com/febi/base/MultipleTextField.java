package com.febi.base;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MultipleTextField extends JFrame {
/**
*
*/
private static final long serialVersionUID = 1L;

public MultipleTextField () {
super("Text Field Array");
JTextField jTextFieldArray = null;
JLabel labek=null;
String[] textFieldStrings = new String[10];
this.setLayout(new FlowLayout(FlowLayout.LEADING));

for (int i = 0; i < 10; i++) {
textFieldStrings[i] = "TextField : " + i;
jTextFieldArray = new JTextField(textFieldStrings[i]);
labek = new JLabel(textFieldStrings[i]);
this.add(labek);
this.add(jTextFieldArray);
}
}

public static void main(String[] args) {
MultipleTextField main = new MultipleTextField ();
main.setSize(new Dimension(400, 300));
main.setVisible(true);
main.setDefaultCloseOperation(EXIT_ON_CLOSE);
}
}
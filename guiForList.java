import javax.swing.*;
import java.awt.Color;

public class guiForList {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setTitle("Java Apllication");
        JButton button = new JButton("I am a silly button");

        frame.getContentPane().setBackground(new Color(120, 120, 120));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// makes x app actually close it
    }
}
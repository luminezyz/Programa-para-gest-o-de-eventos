package org.example;
import javax.swing.*;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceGrafica().setVisible(true);
            }
        });
    }
}

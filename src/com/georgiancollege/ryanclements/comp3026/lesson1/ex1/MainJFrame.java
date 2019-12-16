package com.georgiancollege.ryanclements.comp3026.lesson1.ex1;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class MainJFrame extends JFrame {
    private int windowWidthInPixels;
    private int windowHeightInPixels;

    // Create the fence object
    private transient FlawedFence flawedFence = new FlawedFence();

    private MainJFrame()
    {
        windowWidthInPixels = 1000; // set window width
        windowHeightInPixels = 200; // set window height
        initUI(); // init the UI
    }

    private void initUI()
    {
        add(new JPanelSurface(flawedFence)); // Create a new JPanel
        setTitle("Drawing a Flawed Fence");
        setSize(windowWidthInPixels, windowHeightInPixels);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            // Create main JFrame and begin drawing fence
            MainJFrame mainJFrame = new MainJFrame();
            mainJFrame.setVisible(true);
        });
    }
}
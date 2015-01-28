package GsGUI;

import Model.Field;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gildekel on 1/27/15.
 */


public class MainView extends JFrame {

    private static String TITLE = "The Game Of Life";
    private static String GENERATION_PREFIX = "Generation: ";
    private JLabel generation;
    private Container content;
    private LevelView currentLevel = new LevelView(new Field());


    public MainView() {
        setLocationRelativeTo(null);
        setMinimumSize(currentLevel.getSize());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(TITLE);

        generation = new JLabel(GENERATION_PREFIX, JLabel.LEFT);
        content = getContentPane();

        content.add(currentLevel, BorderLayout.CENTER);
        content.add(generation, BorderLayout.SOUTH);

        pack();
        setResizable(false);
        setVisible(true);
    }

    public void runLevel() {

        int generationNum = 0;
        while(true) {
            generation.setText(GENERATION_PREFIX + generationNum);
            currentLevel.nextGeneration();
            pack();
            setVisible(true);
            try {
                Thread.sleep(100);
            }
            catch (Exception e) {}

            generationNum++;
        }
    }
}

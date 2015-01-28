package GsGUI;

import Model.Field;
import sun.security.acl.GroupImpl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gildekel on 1/27/15.
 */
public class LevelView extends JPanel {

    private final int GRID_SCALING_FACTOR = 6;
    private int levelHeight;
    private int levelWidth;
    private Graphics2D g2;
    private Field currentLevel;



    public LevelView(Field currentLevel) {
        this.currentLevel = currentLevel;
        levelHeight = this.currentLevel.getHeight();
        levelWidth = this.currentLevel.getWidth();
        setSize(levelWidth * GRID_SCALING_FACTOR,
                levelHeight * GRID_SCALING_FACTOR);

        setBackground(Color.WHITE);

        currentLevel.setInitialGeneration();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g2 = (Graphics2D)g;
        int hPosition = 0;
        int wPosition = 0;

        for(int h = 0; h < levelHeight; h++) {
            for(int w = 0; w < levelWidth; w++) {
                if (currentLevel.getCellStateAt(h, w)) {
                    g2.setColor(Color.GREEN);
                }
                else {
                    g2.setColor(Color.WHITE);
                }

                g2.fillRect(wPosition,
                        hPosition,
                        wPosition + GRID_SCALING_FACTOR,
                        hPosition + GRID_SCALING_FACTOR);
                wPosition += GRID_SCALING_FACTOR;
            }
            hPosition += GRID_SCALING_FACTOR;
            wPosition = 0;
        }
    }

    public void nextGeneration() {
        currentLevel.updateAllCells();
        currentLevel.nextGeneration();
        repaint();
    }
}

package GsGUI;

import Model.Field;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gildekel on 1/27/15.
 */
public class LevelView extends JPanel {

    private final int GRID_SCALING_FACTOR = 8; //Change cell size here.
    private int levelHeight;
    private int levelWidth;
    private Dimension levelSize;
    private Graphics2D g2;
    private Field currentLevel;
    private boolean gridGraphics = false;



    public LevelView(Field currentLevel) {

        //Set the panel's size according to the
        //scaling factor.
        this.currentLevel = currentLevel;
        levelHeight = this.currentLevel.getHeight();
        levelWidth = this.currentLevel.getWidth();
        setSize(levelWidth * GRID_SCALING_FACTOR,
                levelHeight * GRID_SCALING_FACTOR);
        levelSize = getSize();

        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g2 = (Graphics2D)g;

        //The current position of the canvas's pen.
        int hPosition = 0;
        int wPosition = 0;

        for(int h = 0; h < levelHeight; h++) {
            for(int w = 0; w < levelWidth; w++) {
                if (currentLevel.getCellStateAt(h, w)) {
                    g2.setColor(Color.GREEN);   //if the cell is alive, paint a green square
                }
                else {
                    g2.setColor(Color.WHITE);   //if the cell is alive, paint a green square
                }

                //Paint a square with the given color.
                g2.fillRect(wPosition,
                        hPosition,
                        wPosition + GRID_SCALING_FACTOR,
                        hPosition + GRID_SCALING_FACTOR);

                wPosition += GRID_SCALING_FACTOR;   //Advance the canvas pen right one scaling factor position.
            }
            hPosition += GRID_SCALING_FACTOR;   //Advance the canvas pen down one scaling factor position.
            wPosition = 0;  //Put the canvas pen back to the left.
        }

        if(gridGraphics)    //if grid wanted, draw the grid.
            drawGrid(g2);
    }

    /**
     * Advances the current graphical view of the
     * field one generation into the future, and
     * repaint the canvas.
     */
    public void nextGeneration() {
        currentLevel.updateAllCells();
        currentLevel.nextGeneration();
        repaint();
    }

    /**
     * Flip the grid state.
     */
    public void flipGrid() {
        gridGraphics = !gridGraphics;
        repaint();  //in case the user chooses to turn on the grid while paused.
    }

    /**
     * Set a new initial state and update the graphics.
     */
    public void reloadLevel() {
        currentLevel.setInitialGeneration();
        repaint();
    }

    /**
     * Kill all cells and update the graphics.
     */
    public void clearLevel () {
        currentLevel.clearGrid();
        repaint();
    }

    /**
     * @return the current iteration/generation.
     */
    public int getGenerationNum() { return currentLevel.getGenerationNum(); }

    /**
     * Draws straight lines from one end of the canvas to the other
     * with consideration of the scaling factor.
     * @param g2 the graphic element used in the paintComponent() method.
     */
    private void drawGrid(Graphics g2) {
        g2.setColor(Color.GRAY);

        for(int w = GRID_SCALING_FACTOR; w < getSize().getWidth(); w += GRID_SCALING_FACTOR) {
            g2.drawLine(w, 0, w, (int)getSize().getHeight()-1);
        }

        for(int h = GRID_SCALING_FACTOR; h < getSize().getHeight(); h += GRID_SCALING_FACTOR) {
            g2.drawLine(0, h, (int)getSize().getWidth()-1, h);

        }
    }
}

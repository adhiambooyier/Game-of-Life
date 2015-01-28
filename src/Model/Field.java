package Model;

import java.util.Random;
import java.util.ArrayList;

/**
 * Created by Gil Dekel on 1/16/15.
 *
 * This class is the data structure for the application.
 * It holds all the cells (of any kind) as private
 * variable members, and will define all work functions.
 *
 * Author: Gil Dekel
 * Last Modified: 1/16/2015
 */

public class Field {

    private int fieldHeight;
    private int fieldWidth;
    private Random rnd = new Random();
    private ArrayList<ArrayList<Cell>> grid;

    public Field() {
        fieldWidth = 100;
        fieldHeight = (fieldWidth/16)*9;

        grid = new ArrayList<ArrayList<Cell>>(fieldHeight);
        for(int h = 0; h < fieldHeight; h++) {
            grid.add(h, new ArrayList<Cell>(fieldWidth));
        }

        populateGrid();
    }

    public Field(int inputHeight, int inputWidth) {
        fieldHeight = inputHeight;
        fieldWidth = inputWidth;

        grid = new ArrayList<ArrayList<Cell>>(fieldHeight);
        for(int h = 0; h < fieldHeight; h++) {
            grid.add(h, new ArrayList<Cell>(fieldWidth));
        }

        populateGrid();
    }

    /**
     * This method will serve as an initializer for
     * the first generation of the cell culture.
     * For now it is merely randomized. In the future
     * the user should be able to input the initial
     * state of generation 0.
     */
    public void setInitialGeneration() {
        int numOfAttempts = rnd.nextInt((fieldHeight*fieldWidth)/2);
        for(int i = 0; i < numOfAttempts; i++) {
            if(rnd.nextBoolean()) {
                Cell currentCell = grid.get(rnd.nextInt(fieldHeight)).get(rnd.nextInt(fieldWidth));
                if(!currentCell.isAlive()) {
                    currentCell.revive();
                }
            }
        }
    }

    /**
     * This can serve as a general draw command to any
     * graphical interface. Simply replace the
     * System.out part.
     */
    public void drawMap() {
        for(int h = 0; h < grid.size(); h++) {
            for (int w = 0; w < grid.get(h).size(); w++) {
                if (grid.get(h).get(w).isAlive()) {
                    System.out.print("O");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }

    /**
     * The Game of Life rules:
     * Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
     * Any live cell with more than three live neighbours dies, as if by overcrowding.
     * Any live cell with two or three live neighbours lives on to the next generation.
     * Any dead cell with exactly three live neighbours becomes a live cell.
     */
    public void nextGeneration() {
        for (int h = 0; h < grid.size(); h++) {
            for (int w = 0; w < grid.get(h).size(); w++) {
                Cell currentCell = grid.get(h).get(w);

                if (currentCell.isAlive()) {
                    if (currentCell.getNumOfNeighbors() < 2 ||
                            currentCell.getNumOfNeighbors() > 3) {
                        currentCell.kill();
                    }
                } else {
                    if (currentCell.getNumOfNeighbors() == 3) {
                        currentCell.revive();
                    }
                }
            }
        }
    }

    /**
     * In order to follow the four rules of the Game of Life,
     * all cells must be aware of their neighbors before any
     * work is done on the map.
     */
    public void updateAllCells() {
        for (int h = 0; h < grid.size(); h++) {
            for (int w = 0; w < grid.get(h).size(); w++) {
                Cell currentCell = grid.get(h).get(w);
                currentCell.setNumOfNeighbors(countNeighbors(h, w));
            }
        }
    }

    public int getHeight() { return fieldHeight; }

    public int getWidth() { return fieldWidth; }

    public Cell getCellAt(int h, int w) {
        return grid.get(h).get(w);
    }

    public boolean getCellStateAt(int h, int w) {
        return grid.get(h).get(w).isAlive();
    }

    /**
     * Populates the grid with dead cells.
     */
    private void populateGrid() {
        for (int h = 0; h < grid.size(); h++) {
            for (int w = 0; w < fieldWidth; w++) {
                grid.get(h).add(w, new Cell());
            }
        }
    }

    /**
     * Counts the number of neighbors surrounding a cell.
     * @param height - Y location on the grid.
     * @param width - X location on the grid.
     * @return 4 or less.
     */
    private int countNeighbors(int height, int width) {
        int neighborCount = 0;

        for(int i = -1; i < 2; i ++) {
            for(int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) {
                    //do nothing.
                } else {
                    if ((height+i >= 0 && height + i < fieldHeight) &&
                            (width + j >= 0 && width + j < fieldWidth)) {
                        if (grid.get(height + i).get(width + j).isAlive()) {
                            neighborCount++;
                            if (neighborCount > 3) {
                                return neighborCount;
                            }
                        }
                    }
                }
            }
        }
        return neighborCount;
    }

}




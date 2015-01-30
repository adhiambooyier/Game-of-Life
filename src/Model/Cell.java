package Model;

/**
 * Created by Gil Dekel on 1/16/15.
 *
 * This class will eventually be Abstract.
 * It represent the most basic form of cell.
 * All other kinds of cells will conform
 * to this class' interface and structure.
 *
 * Author: Gil Dekel
 * Last Modified: 1.16.2015
 */

public class Cell {
    private boolean living;
    private int xCoord;
    private int yCoord;
    private int numOfNeighbors;
    private String size;

    /**
     * All instances of Model.Cell are stillborn.
     */
    public Cell() {
        living = false;
        numOfNeighbors = 0;
    }

    public Cell(int x, int y, String size) {
        xCoord = x;
        yCoord = y;
        living = false;
        numOfNeighbors = 0;
        this.size = size;
    }

    public boolean isAlive() {
        return living;
    }

    public void kill() {
        living = false;
    }

    public void revive() { living = true; }

    public void setNumOfNeighbors(int num) { numOfNeighbors = num; }

    public int getNumOfNeighbors() { return numOfNeighbors; }
}

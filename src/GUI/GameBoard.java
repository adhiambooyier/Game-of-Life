package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by user-VII on 1/17/15.
 * Description:
 * Last Edit: MW
 * Last Modified: 1/17/15
 */
public class GameBoard extends JPanel {
    Random rand = new Random();
    Graphics2D g2d;
    int rX;
    int rY;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GREEN);

        rX = randomGenerator(boardWidth(), 0);
        rY = randomGenerator(boardHeight(), 0);

        g2d.fillOval(rX, rY, 10, 10);

        g2d.setColor(Color.RED);
        g2d.fillOval(0, 0, 10, 10);
        g2d.fillOval(getWidth() - 10, 0, 10, 10);
        g2d.fillOval(0, getHeight() - 10, 10, 10);
        g2d.fillOval(getWidth() - 10, getHeight() - 10, 10, 10);
        System.out.println(rX + "," + rY);

    }

    public void createCircle() {

    }

    public int boardWidth() {
        return this.getWidth();
    }

    public int boardHeight() {
        return this.getHeight();
    }

    private int randomGenerator(int max, int min) {
        return rand.nextInt((max - min) + 1) + min;
    }
}


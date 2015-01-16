import java.util.Scanner;

/**
 * Created by Gil Dekel on 1/16/15.
 *
 * This is the main() class. It runs the program
 * and operates on all the classes.
 *
 * Author: Gil Dekel
 * Last Modified: 1.16.2015
 */
public class GoL {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Field stage = new Field();
        int generationCounter = 0;
        char yesOrNo;

        stage.setInitialGeneration();
        stage.drawMap();
        System.out.println("Generation: " + generationCounter);

        System.out.print("Next Generation? (y/n): ");
        yesOrNo = in.nextLine().toLowerCase().charAt(0);

        while (yesOrNo == 'y') {
            generationCounter++;
            stage.nextGeneration();
            stage.drawMap();
            System.out.println("Generation: " + generationCounter);

            System.out.print("Next Generation? (y/n): ");
            yesOrNo = in.nextLine().toLowerCase().charAt(0);
        }
    }
}

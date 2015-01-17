import GUI.GameController;

import java.util.Scanner;

/**
 * Created by Gil Dekel on 1/16/15.
 *
 * This is the main() class. It runs the program
 * and operates on all the classes.
 *
 * Author: Gil Dekel
 * Last Edit: MW
 * Last Modified: 1.17.2015
 */
public class GoL {

    public GoL() {

    }

    public void ConsoleCreationism() {
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

    public void GUICreationism() {
        GameController controller = new GameController();
    }

    public static void main(String[] args) {
        GoL init = new GoL();
        init.GUICreationism();
        //init.ConsoleCreationism();
    }
}

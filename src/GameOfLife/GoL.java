package GameOfLife;

import GameOfLife.GUI.MainView;

/**
 * Created by Gil Dekel on 1/16/15.
 *
 * This is the main()'s class. It runs the program
 * and operates on all the classes.
 *
 * Author: Gil Dekel
 * Last Modified: 3.15.2015
 */
public class GoL {

    public GoL() {

    }

    public void runGsGUI() {
        MainView mainView = new MainView();
        mainView.run();
    }

    public static void main(String[] args) {
        GoL init = new GoL();
        init.runGsGUI();
    }
}

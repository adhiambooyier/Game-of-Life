package Model;

import GUI.GameController;
import GsGUI.MainView;

import javax.swing.*;
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

    public void GUICreationism() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameController controller = new GameController();
            }
        });

    }

    public void runGsGUI() {
        MainView mainView = new MainView();
        mainView.run();
    }

    public static void main(String[] args) {
        GoL init = new GoL();
        init.runGsGUI();
        //init.GUICreationism();
    }
}

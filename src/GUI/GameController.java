package GUI;

import javax.swing.*;

/**
 * Created by user-VII on 1/17/15.
 * Description:
 * Last Edit: MW
 * Last Modified: 1/17/15
 */
public class GameController {
    private GameView view;
    private GameModel model;

    public GameController() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                view = new GameView();
                view.setVisible(true);
            }
        });
        model = new GameModel();
    }
}

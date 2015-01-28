package GUI;

/**
 * Created by user-VII on 1/17/15.
 * Description:
 * Last Edit: MW
 * Last Modified: 1/17/15
 */
public class GameController {
    private GameView view;
    private GameModel model;
    private GameBoard gameBoard;

    public GameController() {
        gameBoard = new GameBoard();
        view = new GameView(gameBoard);
        view.setVisible(true);

        model = new GameModel();

        createThings();
    }

    private void createThings() {
        view.createCircle();
    }
}

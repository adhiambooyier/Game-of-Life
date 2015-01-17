package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user-VII on 1/17/15.
 *
 * This is the main GUI for the program.
 *
 * Author: MW
 * Last Edit: MW
 * Last Modified: 1/17/15
 */
public class GameView {
    private JFrame frame;
    private GameBoard gameBoard;


    public GameView(GameBoard gameBoard) {
        frame = new JFrame();
        this.gameBoard = gameBoard;

        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Game-of-Life");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Error creating main window");
        }
        frame.setTitle("Game-of-Life");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(GameMenuBar());
        frame.add(GamePanel(), BorderLayout.WEST);
        frame.add(gameBoard, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(true);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    private JMenuBar GameMenuBar() {
        JMenuBar mainMenu = new JMenuBar();

        JMenu file = new JMenu("File");

        JMenuItem fileMenuItemNew = new JMenuItem("New", null);
        JMenuItem fileMenuItemExit = new JMenuItem("Exit", null);

        fileMenuItemNew.setToolTipText("New Game!");
        fileMenuItemExit.setToolTipText("Exit Game!");


        file.add(fileMenuItemNew);
        file.add(fileMenuItemExit);

        mainMenu.add(file);

        return mainMenu;
    }

    private JPanel GamePanel() {
        JPanel content = new JPanel();


        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createMatteBorder(
                0, 0, 0, 1, Color.BLACK));
        content.add(new JButton("Play"));
        content.add(new JButton("Pause"));

        return content;
    }

    public void createCircle() {
        gameBoard.createCircle();
    }
}

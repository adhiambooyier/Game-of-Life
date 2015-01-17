package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user-VII on 1/17/15.
 * <p/>
 * This is the main GUI for the program.
 * <p/>
 * Author: MW
 * Last Edit: MW
 * Last Modified: 1/17/15
 */
public class GameView {
    private JFrame frame;

    public GameView() {
        frame = new JFrame();
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
        frame.add(GamePanel());
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

        content.setLayout(new FlowLayout());
        content.add(new JLabel("Stuff!"));
        content.add(new JLabel("and a game!"));
        return content;
    }
}

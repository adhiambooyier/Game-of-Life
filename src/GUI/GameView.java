package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

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
        frame.add(GamePanel(), BorderLayout.WEST);
        frame.add(new GameBoard(), BorderLayout.CENTER);
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

    private class GameBoard extends JPanel {

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.fillOval(0, 0, 30, 30);
            g2d.drawOval(0, 50, 30, 30);
            g2d.fillRect(50, 0, 30, 30);
            g2d.drawRect(50, 50, 30, 30);

            g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
        }

    }


}

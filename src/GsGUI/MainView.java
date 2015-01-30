package GsGUI;

import Model.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gildekel on 1/27/15.
 */


public class MainView implements Runnable {

    private static String TITLE = "The Game Of Life";   //Change Title here
    private static String GENERATION_PREFIX = "Generation: ";
    private static String PLAYBUTTON_ICON = "\u25B6";   //Play icon
    private static String STOPBUTTON_ICON = "\u25FC";   //Stop icon
    private static String RELOADBUTTON_ICON = "\u21BA"; //Reload icon
    private static String CLEARBUTTON_ICON = "\u232B";  //Clear icon

    private JFrame mainFrame;
    private JLabel generation;
    private JButton playButton, stopButton, clearButton, reloadButton;
    private JCheckBox gridCheck;
    private Container frameContent, southPanel, eastPanel,
                      centerPanel, mediaPanel, statusBar;
    private LevelView levelView = new LevelView(new Field());
    private boolean stillRunning = false;


    public MainView() {
        mainFrame = new JFrame();
        mainFrame.setLocationRelativeTo(null);
//        mainFrame.setMinimumSize(levelView.getLevelSize());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle(TITLE);


        //Containers
        frameContent = mainFrame.getContentPane();
        frameContent.setLayout(new BoxLayout(frameContent, BoxLayout.Y_AXIS));
        levelView.setPreferredSize(levelView.getSize());
        southPanel = new Container();
        eastPanel = new Container();
        centerPanel = new Container();
        mediaPanel = new Container();
        statusBar = new Container();


        //Labels, Buttons, etc.
        generation = new JLabel(GENERATION_PREFIX);//, JLabel.LEFT);
        playButton = new JButton(PLAYBUTTON_ICON);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playLevel();
            }
        });

        stopButton = new JButton(STOPBUTTON_ICON);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopLevel();
            }
        });

        clearButton = new JButton(CLEARBUTTON_ICON);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearLevel();
            }
        });

        reloadButton = new JButton(RELOADBUTTON_ICON);
        reloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadLevel();
            }
        });

        gridCheck = new JCheckBox("Grid");
        gridCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                levelView.flipGrid();
            }
        });


        //Building the frame
        eastPanel.setLayout(new GridLayout(4, 2));

        //BoxLayout left to right: add the levelView, a border, and the eastPanel.
        //This is done to insure the fixed size of the elements.
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.add(levelView);
        centerPanel.add(Box.createRigidArea(new Dimension(5,0)));
        centerPanel.add(eastPanel);



        southPanel.setLayout(new GridLayout(2, 1));

        //Play, Stop, Reload, Clear, and Grid options in one panel.
        mediaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, -10, 0));
        mediaPanel.add(playButton);
        mediaPanel.add(stopButton);
        mediaPanel.add(reloadButton);
        mediaPanel.add(clearButton);
        mediaPanel.add(gridCheck);

        southPanel.add(mediaPanel);
        southPanel.add(generation);

        frameContent.add(centerPanel);
        frameContent.add(southPanel);


        mainFrame.pack();
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

    }

    public void run() {



        while(true) {

            if(stillRunning) {
                generation.setText(GENERATION_PREFIX + levelView.getGenerationNum());
                levelView.nextGeneration();
            }

            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }

        }
    }

    //Action methods.
    public void playLevel() { stillRunning = true; }

    public void stopLevel() { stillRunning = false; }

    public void reloadLevel() {
        levelView.reloadLevel();
        generation.setText(GENERATION_PREFIX + levelView.getGenerationNum());
    }

    public void clearLevel() {
        levelView.clearLevel();
        generation.setText(GENERATION_PREFIX + levelView.getGenerationNum());
    }
}

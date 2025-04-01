package Game;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, victoryPanel;
    JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel, playerLabel, playerNameLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea, victoryTextArea;
    Font victoryFont = new Font("Times New Roman", Font.BOLD, 32);
    Font titleFont = new Font("Times New Roman", Font.BOLD, 90);
    Font normalFont = new Font("Times New Roman", Font.BOLD, 26);

    public void createUI(Game.ChoiceHandler cHandler) {

        //WINDOW

        window = new JFrame();
        window.setSize(1200,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLayout(null);
        window.getContentPane().setBackground(Color.black);
        // VICTORY SCREEN

        victoryPanel = new JPanel();
        victoryPanel.setBounds(200, 100, 800, 300);
        victoryPanel.setBackground(Color.black);
        window.add(victoryPanel);

        victoryTextArea = new JTextArea();
        victoryTextArea.setEditable(false);
        victoryTextArea.setBackground(Color.black);
        victoryTextArea.setFont(victoryFont);
        victoryTextArea.setLineWrap(true);
        victoryTextArea.setWrapStyleWord(true);
        victoryTextArea.setForeground(Color.white);
        victoryTextArea.setBounds(200, 100, 800, 300);
        victoryPanel.add(victoryTextArea);

        // TITLE SCREEN

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(300,100,600,500);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ZombieWalk");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(500, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setForeground(Color.white);
        startButton.setBackground(Color.black);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("START");
        startButtonPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);

        //GAME SCREEN

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(200, 100, 800, 300);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setEditable(false);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setBounds(200, 100, 800, 300);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(150, 450, 900, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonPanel);

        choice1 = new JButton("");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(50, 15, 1100, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,6));
        window.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setForeground(Color.white);
        hpLabel.setFont(normalFont);
        playerPanel.add(hpLabel);
        hpNumberLabel = new JLabel();
        hpNumberLabel.setForeground(Color.white);
        hpNumberLabel.setFont(normalFont);
        playerPanel.add(hpNumberLabel);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(normalFont);
        playerPanel.add(weaponLabel);
        weaponNameLabel = new JLabel();
        weaponNameLabel.setForeground(Color.white);
        weaponNameLabel.setFont(normalFont);
        playerPanel.add(weaponNameLabel);

        playerLabel = new JLabel("Name: ");
        playerLabel.setForeground(Color.white);
        playerLabel.setFont(normalFont);
        playerPanel.add(playerLabel);
        playerNameLabel = new JLabel();
        playerNameLabel.setForeground(Color.white);
        playerNameLabel.setFont(normalFont);
        playerPanel.add(playerNameLabel);

        window.setVisible(true);

    }
}



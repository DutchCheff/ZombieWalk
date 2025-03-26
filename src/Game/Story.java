package Game;

import Player.Player;
import Player.armyKnife;
import Player.M9_pistol;
import World.SuperMonster

import javax.swing.*;

public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {
        player.hp = 20;
        ui.hpNumberLabel.setText("" + player.hp);

        player.name = "";

    }

    public void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "apartment": apartmentStart(); break;
            case "window": window(); break;
            case "tv": tv(); break;
            case "frontDoor": frontDoor(); break;
        }
    }
    public void play() {
        defaultSetup();
        String playerName = JOptionPane.showInputDialog(ui.mainTextPanel, "What is your first and last name?");
        player.name = playerName;
        ui.playerNameLabel.setText(playerName);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "apartment";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void apartmentStart() {
        vm.playingScreen();
        ui.mainTextArea.setText("You wake up in your apartment and hear chaos outside on the streets, someone is knocking on your front door.\n\nWhat do you do? ");
        ui.choice1.setText("You go to the window and look outside");
        ui.choice2.setText("You turn on the tv to see if the news might tell you more");
        ui.choice3.setText("You walk to the front door and open it");

        game.nextPosition1 = "window";
        game.nextPosition2 = "tv";
        game.nextPosition3 = "frontDoor";

    }
    public void window() {
        ui.mainTextArea.setText("You go to the window and look outside \nYou see chaos outside, cars on fire, people running and screaming and distant gunshots");
        ui.choice1.setText("You walk to your home vault to arm yourself");
        ui.choice2.setText("You walk to the door and open it");
        ui.choice3.setText("You turn on your TV to see if the news might tell you more");

        game.nextPosition1 = "vault";
        game.nextPosition2 = "frontDoor";
        game.nextPosition3 = "tv";
    }
    public void tv() {
        ui.mainTextArea.setText("Your TV turns on. You see a video from the president urging people to stay calm, follow quarantine instructions from the army and follow evacuation plans");
        ui.choice1.setText("You get your phone and call your brother");
        ui.choice2.setText("You walk over to the door and open it");
        ui.choice3.setText("You walk to you vault to arm yourself");

        game.nextPosition1 = "phone";
        game.nextPosition2 = "frontDoor";
        game.nextPosition3 = "vault";
    }




//    Front door Story Line

    public void frontDoor() {
        ui.mainTextArea.setText("Upon opening the door you see a soldier. \n\n'Thanks for opening the door. Please follow me, I will bring you to a truck that goes to the designated Quarantine zone'");
        ui.choice1.setText("Follow the soldier");
        ui.choice2.setText("You slam the door in his face and lock it");
        ui.choice3.setText("");

        game.nextPosition1 = "exitWithSoldier";
        game.nextPosition2 = "callBrother";
    }
    public void exitWithMilitaryMan() {
        ui.mainTextArea.setText("You follow the soldier down the hallway, down the staircase and out of the emergency exit of the building");
        ui.choice1.setText(">");

        game.nextPosition1 = "alley";
    }
    public void alley() {
        ui.mainTextArea.setText("Exiting the building you come in to the alley on the side of the building. \nOn the right you hear screams as a group of zombies comes running around the corner. \n\nWhat do you do?");
        ui.choice1.setText("You freeze from fear and hope the soldier opens fire");
        ui.choice2.setText("You Run!!");

        game.nextPosition1 = "waitAndSee";
        game.nextPosition2 = "run";
    }
    public void waitAndSee() {
        ui.mainTextArea.setText("The soldier opens fire and takes down 2 of the 5 zombies that came around the corner. \nSoldier: 'Can you shoot a gun?'");
        ui.choice1.setText("Yes, toss me your side-arm");
        ui.choice2.setText("No....");

        game.nextPosition1 = "getSoldiersGun";
        game.nextPosition2 = "getSoldiersKnife";
    }
    public void getM9(){
        player.currentWeapon = new M9_pistol();
        ui.mainTextArea.setText("The soldier tosses his sidearm to you. \nSoldier: 'Start shooting those bastards'");
        ui.choice1.setText(">");
    }
    public void getKnife() {
        player.currentWeapon = new armyKnife();
        ui.mainTextArea.setText("The soldier puts his knife in your hand. \nSoldier: 'They come to close for my gun and you start stabbing'");
        ui.choice1.setText(">");
        game.nextPosition1 = "knifeFight";
    }

}































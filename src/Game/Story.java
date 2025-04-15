package Game;


import Player.Player;
import Player.armyKnife;
import Player.M9_pistol;
import Player.Glock_18;
import Player.M4_AssaultRifle;
import World.SuperMonster;
import World.Zombie;
import Player.fists;

import javax.swing.*;
import java.awt.*;

public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    SuperMonster monster;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {
        player.hp = 25;
        ui.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new fists();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        player.name = "";

    }

    public void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "apartment": apartmentStart(); break;
            case "window": window(); break;
            case "phone": phone(); break;
            case "vaultCallBrother": vaultCallBrother(); break;
//            EXIT ALLEY LEFT
            case "leftExitAlley": leftExitAlley(); break;
            case "searchPoliceCarAlone": searchPoliceCarAlone(); break;
            case "drivePoliceCarAlone": drivePoliceCarAlone(); break;
            case "driveOutOfTown": driveOutOfTown(); break;
            case "goLeft": goLeft(); break;
            case "helpStuckCar": helpStuckCar(); break;
            case "connectCables": connectCables(); break;
            case "goRight": goRight(); break;
            case "carKeysLeave": carKeysLeave(); break;
            case "forestCabin": forestCabin(); break;

//            TV Cases
            case "tv": tv(); break;
            case "vault": vault(); break;
//            Fire Escape
            case "fireEscape": fireEscape(); break;
            case "exitAlleyRight": exitAlleyRight(); break;
            case "engageConvoy": engageConvoy(); break;
            case "runToTackle": runToTackle(); break;
//            FrontDoor no Soldiers
            case "frontDoorNoSoldier": frontDoorNoSoldier(); break;
            case "leaveElevator": leaveElevator(); break;
            case "elevatorChaos": elevatorChaos(); break;

            case "leaveStaircase": leaveStaircase(); break;
            case "searchDoorMan": searchDoorMan(); break;
            case "downToGarageDoorman": downToGarageDoorman(); break;
            case "enterDoormanCar": enterDoormanCar(); break;
            case "driveAlone": driveAlone(); break;
            case "driveToQuarantine": driveToQuarantine(); break;

//            FrontDoor cases
            case "frontDoor": frontDoor(); break;
            case "exitWithSoldier": exitWithSoldier(); break;
            case "alley": alley(); break;
            case "waitAndSee": waitAndSee(); break;

//            M9 fight
            case "getM9": getM9(); break;
            case "zombieM9Close": zombieM9Close(); break;
            case "startM9Fight": startM9Fight(); break;
            case "M9PlayerAttacks": M9PlayerAttacks(); break;
            case "M9ZombieAttacks": M9ZombieAttacks(); break;
            case "moveOnwardFrontDoorOne": moveOnwardFrontDoorOne(); break;
//            onward frontDoor One
            case "fightConvoy": fightConvoy(); break;
            case "soldierDown": soldierDown(); break;
            case "helpSoldier": helpSoldier(); break;
            case "holdSoldier": holdSoldier(); break;
            case "leftExitAlleySoldier": leftExitAlleySoldier(); break;
            case "searchPoliceCar": searchPoliceCar(); break;
            case "drivePoliceCarSoldier": drivePoliceCarSoldier(); break;

//          Knife Fight
            case "getKnife": getKnife(); break;
            case "zombieKnifeClose": zombieKnifeClose(); break;
            case "startKnifeFight": startKnifeFight(); break;
            case "knifePlayerAttacks": knifePlayerAttacks(); break;
            case "knifeZombieAttacks": knifeZombieAttacks(); break;
//          Onward frontdoor Two
            case "moveOnwardFrontDoorTwo": moveOnwardFrontDoorTwo(); break;
            case "lootingSoldier": lootingSoldier(); break;
            case "backInside": backInside(); break;
            case "frontDoorConvoy": frontDoorConvoy(); break;
            case "screamAtConvoy": screamAtConvoy(); break;
            case "explodeConvoy": explodeConvoy(); break;
            case "safeConvoy": safeConvoy(); break;
            case "handcuffedConvoy": handcuffedConvoy(); break;
            case "aliveButHow": aliveButHow(); break;
            case "endKnife": endKnife(); break;

            case "Restart": play(); break;
            case "Death": Death(); break;
            case "Victory": Victory(); break;
        }
    }
    public void play() {
        defaultSetup();


        ui.mainTextArea.setText("");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        String playerName = JOptionPane.showInputDialog(ui.mainTextPanel, "What is your first and last name?");
        player.name = playerName;
        ui.playerNameLabel.setText(playerName);

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

//    WINDOW STORYLINE
    public void window() {
        ui.mainTextArea.setText("You go to the window and look outside \nYou see chaos outside, cars on fire, people running and screaming and distant gunshots");
        ui.choice1.setText("You walk to your home vault to arm yourself");
        ui.choice2.setText("You walk to the door and open it");
        ui.choice3.setText("You turn on your TV to see if the news might tell you more");
        ui.choice4.setText("Call your brother");

        game.nextPosition1 = "vault";
        game.nextPosition2 = "frontDoor";
        game.nextPosition3 = "tv";
        game.nextPosition4 = "phone";
    }
    public void phone() {
        if (player.currentWeapon instanceof Glock_18) {
            ui.mainTextArea.setText("You reach your brother. He tells you he has a cabin in the forest that is safe. He is stocked up with food to survive but has nothing to defend. He asks you to bring your gun and hangs up");
            ui.choice1.setText("You grab you car keys");
            ui.choice2.setText("You leave through the fire escape at your window");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "carKeysLeave";
            game.nextPosition2 = "fireEscape";
        } else {
            ui.mainTextArea.setText("You reach your brother. He tells you he has a cabin in the forest that is safe. He is stocked up with food to survive but has nothing to defend. He asks you to bring your gun and hangs up");
            ui.choice1.setText("You go to your home vault to get you gun");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "vaultCallBrother";
        }
    }
    public void vaultCallBrother() {
        player.currentWeapon = new Glock_18();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        ui.mainTextArea.setText("You open your vault and grab your Glock-18 and the three magazines with ammo.\n\nWhat do you do?");
        ui.choice1.setText("You grab your car keys and go out the front door");
        ui.choice2.setText("You leave your apartment with the fire escape at your window");

        game.nextPosition1 = "carKeysLeave";
        game.nextPosition2 = "fireEscape";
    }
//    EXIT ALLEY LEFT NO SOLDIER
    public void leftExitAlley() {
        ui.mainTextArea.setText("You run out the alley and see a crash that has happened on the left with a school bus that blocks the whole road. You go right and see a police car.\n\nWhat do you do?");
        ui.choice1.setText("You search the trunk of the car");
        ui.choice2.setText("You get in the car and start driving");

        game.nextPosition1 = "searchPoliceCarAlone";
        game.nextPosition2 = "drivePoliceCarAlone";
    }
    public void searchPoliceCarAlone() {
        player.currentWeapon = new M4_AssaultRifle();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        ui.mainTextArea.setText("You find an M4 Assault Rifle with 2 magazines containing bullets");
        ui.choice1.setText("Get in the car and start driving");
        ui.choice2.setText("");

        game.nextPosition1 = "drivePoliceCarAlone";
    }
    public void drivePoliceCarAlone() {
        ui.mainTextArea.setText("You start driving to you brother's known forest cabin");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "driveOutOfTown";
    }
    public void driveOutOfTown() {
        ui.mainTextArea.setText("You get to a t-junction. Both left and right can take you to your brother.\n\nWhat do you do?");
        ui.choice1.setText("Take the left");
        ui.choice2.setText("Take the right");

        game.nextPosition1 = "goLeft";
        game.nextPosition2 = "goRight";
    }
    public void goLeft() {
        ui.mainTextArea.setText("You go to the left and after a while you see a car in the distance blocking the road with the hood open and a man checking the engine.\n\nWhat do you do?");
        ui.choice1.setText("Turn around");
        ui.choice2.setText("Continue driving and see if you can help out");

        game.nextPosition1 = "goRight";
        game.nextPosition2 = "helpStuckCar";
    }
    public void helpStuckCar() {
        ui.mainTextArea.setText("You come to a stop and step out of your car. The man at the broken down car turns around and goes:\n'Oh hi there. Can you help jump my car with some cables. It broke down and its not safe to stay here for long'\n\nWhat do you do?");
        ui.choice1.setText("You walk to him to help connect the cables");
        ui.choice2.setText("");

        game.nextPosition1 = "connectCables";
    }
    public void connectCables() {
        ui.mainTextArea.setText("You walk up to the man and help him out. As you are connecting the cables under his hood you hear other footsteps coming in. When you turn around to see what's going on you get hit in the back of the head with something pointy. Life fades out of your body");
        ui.choice1.setText(">");

        game.nextPosition1 = "Death";
    }
    public void goRight() {
        ui.mainTextArea.setText("You exit the city to the right and after driving for about an hour you see the exit that goes in to the forest to the cabin of your brother");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "forestCabin";
    }
    public void forestCabin() {
        ui.mainTextArea.setText("You come up to the cabin and see your brother patiently waiting outside. You and your brother set up a perimeter, make the place safe. After two years you find out there is a vaccine ready and the world will slowly go back to the way it was. You and your brother life out the rest of your days in the forest");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "Victory";
    }
    public void carKeysLeave() {
        ui.mainTextArea.setText("You leave your apartment and go down the stairs to the garage. Here you step in to your car and start driving");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "driveOutOfTown";
    }

//    Frontdoor Story Line
    public void frontDoor() {
        ui.mainTextArea.setText("Upon opening the door you see a soldier. \n\n'Thanks for opening the door. Please follow me, I will bring you to a truck that goes to the designated Quarantine zone'");
        ui.choice1.setText("Follow the soldier");
        ui.choice2.setText("You slam the door in his face and lock it");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "exitWithSoldier";
        game.nextPosition2 = "apartment";
    }
    public void exitWithSoldier() {
        ui.mainTextArea.setText("You follow the soldier down the hallway, down the staircase and out of the emergency exit of the building");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "alley";
    }
    public void alley() {
        ui.mainTextArea.setText("Exiting the building you come in to the alley on the side of the building. \nOn the right you hear screams as a group of zombies comes running around the corner. \n\nWhat do you do?");
        ui.choice1.setText("You freeze from fear and hope the soldier opens fire");
        ui.choice2.setText("You Run!!");

        game.nextPosition1 = "waitAndSee";
        game.nextPosition2 = "leftExitAlley";
    }
    public void waitAndSee() {
        ui.mainTextArea.setText("The soldier opens fire and takes down 2 of the 5 zombies that came around the corner. \nSoldier: 'Can you shoot a gun?'");
        ui.choice1.setText("Yes, toss me your side-arm");
        ui.choice2.setText("No....");

        game.nextPosition1 = "getM9";
        game.nextPosition2 = "getKnife";
    }

//    M9 Fight
    public void getM9(){
        player.currentWeapon = new M9_pistol();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        ui.mainTextArea.setText("The soldier tosses his sidearm to you. \nSoldier: 'Start shooting those bastards'");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "zombieM9Close";
    }
    public void zombieM9Close() {
        monster = new Zombie();
        ui.mainTextArea.setText("The soldier shoots down 2 more zombies. One zombie gets in closer when the soldier has to reload. \n\nThe " + monster.name + ": " + monster.hp + "HP");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "startM9Fight";
    }
    public void startM9Fight() {
        ui.mainTextArea.setText(monster.name + ": " + monster.hp + "HP");
        ui.choice1.setText("Attack");
        ui.choice2.setText("You run");

        game.nextPosition1 = "M9PlayerAttacks";
        game.nextPosition2 = "leftExitAlley";
    }
    public void M9PlayerAttacks() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        ui.mainTextArea.setText("You shoot and hit the " + monster.name + " for: " + playerDamage + " HP");
        monster.hp -= playerDamage;
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (monster.hp > 0) {
            game.nextPosition1 = "M9ZombieAttacks";

        } else {
            ui.mainTextArea.setText("You killed the " + monster.name + "!");

            game.nextPosition1 = "moveOnwardFrontDoorOne";

        }
    }
    public void M9ZombieAttacks() {
        int monsterDamage = new java.util.Random().nextInt(monster.damage);
        ui.mainTextArea.setText("The " + monster.name + " attacks you, the one who shot him, and does " + monster.damage + " damage!");
        player.hp -= monster.damage;
        ui.hpNumberLabel.setText(Integer.toString(player.hp));

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "startM9Fight";
        } else {
            game.nextPosition1 = "Death";
        }
    }

//    Move onward One
    public void moveOnwardFrontDoorOne() {
        ui.mainTextArea.setText("You both finish the group of zombies off and push onward to the exit of the alley. Around the corner you see the trucks and soldiers that belong to the Quarantine Zone convoy");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "fightConvoy";
}
    public void fightConvoy() {
        ui.mainTextArea.setText("A fight breaks loose, gunshots are fired and an explosion of a grenade follows. The trucks explode and chaos follows.\n\nThe soldier starts running to the convoy.\nWhat do you do?");
        ui.choice1.setText("Watch the chaos unfold");
        ui.choice2.setText("Stop the soldier from running to the convoy");

        game.nextPosition1 = "soldierDown";
        game.nextPosition2 = "holdSoldier";
}
    public void soldierDown() {
        ui.mainTextArea.setText("The soldier continues running to the convoy.\nAbout 15 meters away from you he gets jumped by a zombie coming out of the apartment complex.\n\nWhat do you do?");
        ui.choice1.setText("Run to the soldier to try and save him");
        ui.choice2.setText("Run back in the alley and towards the opposing exit of the alley");

        game.nextPosition1 = "helpSoldier";
        game.nextPosition2 = "leftExitAlley";
}
    public void helpSoldier() {
        ui.mainTextArea.setText("You run to the soldier to try and save him. Upon arriving you see that the Zombie is the doorman from the apartment complex. You are so stunned by this that the zombie has the time to jump on you and shred your throat to bits.");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "Death";
}
    public void holdSoldier() {
        ui.mainTextArea.setText("You hold the soldier back and show him the chaos, his fellow soldiers down, people screaming on the ground.\n\nNo two seconds later zombies come from buildings and from alleyways to feast on the disaster.\nYou and the soldier have no way but the opposite alley exit");
        ui.choice1.setText("You move back in to the alley");
        ui.choice2.setText("");

        game.nextPosition1 = "leftExitAlleySoldier";
}
    public void leftExitAlleySoldier() {
        ui.mainTextArea.setText("You and the soldier come to the other end of the alley. On the left on the road you see that a schoolbus has crashed in to other cars and is completely blocking the road.\nYou take the right and after one minute of walking find a police car.\n\nWhat do you do?");
        ui.choice1.setText("Get in the car and start driving");
        ui.choice2.setText("Search the car before getting in");

        game.nextPosition1 = "drivePoliceCarSoldier";
        game.nextPosition2 = "searchPoliceCar";
}
    public void searchPoliceCar() {
        player.currentWeapon = new M4_AssaultRifle();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        ui.mainTextArea.setText("You find an M4 Assault Rifle with 2 magazines containing bullets");
        ui.choice1.setText("Get in the car and start driving");
        ui.choice2.setText("");

        game.nextPosition1 = "drivePoliceCarSoldier";
}
    public void drivePoliceCarSoldier() {
        ui.mainTextArea.setText("The soldier guides your way to the Quarantine Zone.\nArriving there you find out the soldier you've travelled with is a high ranking officer.\n\nYou get taken in to the ranks and quickly work your way up. When the Vaccine arrives you stay with the standing army and help the region getting back to the life it was before the outbreak");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "Victory";
}

//    Knife Fight
    public void getKnife() {
        player.currentWeapon = new armyKnife();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        ui.mainTextArea.setText("The soldier puts his knife in your hand. \nSoldier: 'They come to close for my gun and you start stabbing'");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "zombieKnifeClose";
    }
    public void zombieKnifeClose() {
        monster = new Zombie();
        ui.mainTextArea.setText("1 more zombies go down but 1 closes in and comes for you.\n\n The" + monster.name + ": " + monster.hp + "HP");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "startKnifeFight";
    }
    public void startKnifeFight() {
        ui.mainTextArea.setText(monster.name + ": " + monster.hp + "HP");
        ui.choice1.setText("Attack");
        ui.choice2.setText("You run");

        game.nextPosition1 = "knifePlayerAttacks";
        game.nextPosition2 = "leftExitAlley";
    }
    public void knifePlayerAttacks() {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        ui.mainTextArea.setText("You stab at the" + monster.name + " and hit for: " + playerDamage + " HP");
        monster.hp -= playerDamage;
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (monster.hp > 0) {
            game.nextPosition1 = "knifeZombieAttacks";
        } else {
            ui.mainTextArea.setText("You killed the " + monster.name + "!");

            game.nextPosition1 = "moveOnwardFrontDoorTwo";
        }
    }
    public void knifeZombieAttacks() {
        int monsterDamage = new java.util.Random().nextInt(monster.damage);
        ui.mainTextArea.setText("The " + monster.name + " attacks you and does " + monster.damage + " damage!");
        player.hp -= monster.damage;
        ui.hpNumberLabel.setText(Integer.toString(player.hp));

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "startKnifeFight";
        } else {
            game.nextPosition1 = "Death";
        }
    }

//    Move onward Two
    public void moveOnwardFrontDoorTwo() {
        ui.mainTextArea.setText("You look up after the killing blow on the Zombie just to see that the Soldier has bled to his death after having killed the zombie that jumped him.\n\nWhat do you do");
        ui.choice1.setText("Check his body for his gun");
        ui.choice2.setText("Run to the opposite exit of the alley then the Zombies came from");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "lootingSoldier";
        game.nextPosition2 = "leftExitAlley";
    }
    public void lootingSoldier() {
        player.currentWeapon = new M9_pistol();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        ui.mainTextArea.setText("You see that he is empty on bullets for his M4-Assault rifle and take his side-arm.");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");

        game.nextPosition1 = "backInside";

    }
    public void backInside() {
        ui.mainTextArea.setText("Two more Zombies come around the same corner, you dart back inside and lock the door behind you.\nInside you make your way to the entry hall of the apartment complex. You see the doormen lying dead on his desk.");
        ui.choice1.setText("Go to the front door");
        ui.choice2.setText("");

        game.nextPosition1 = "frontDoorConvoy";

    }
    public void frontDoorConvoy() {
        ui.mainTextArea.setText("Upon stepping into the door opening you see the trucks from the military standing ready for transport to the quarantine zone.\n\nOn the other side of the street you see a man standing in an alley. He seems to be holding a grenade and is looking at the soldiers with anger.");
        ui.choice1.setText("Aim for the man to try and shoot him");
        ui.choice2.setText("Step out of the door and scream at the soldiers to warn them");

        game.nextPosition1 = "safeConvoy";
        game.nextPosition2 = "screamAtConvoy";
    }
    public void screamAtConvoy() {
        ui.mainTextArea.setText("You step outside and scream at the soldiers: \n'Look out, he has a grenade!!' \nWhile pointing at the man in the alley. \nThe man sees this and throws his grenade at the trucks and soldiers that are helping civilians getting in.");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "explodeConvoy";
    }
    public void explodeConvoy() {
        ui.mainTextArea.setText("The grenade flies through the air before the soldiers can even hear you scream. When they notice you pointing and screaming at the man in the alley, the grenade lands, rolls and explodes. The trucks explode one after the other.\nThe blast of the explosion blasts you back in the building. Your head lands on the desk and breaks your neck.");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "Death";
    }
    public void safeConvoy() {
        int random = new java.util.Random().nextInt(11);
        if (random < 5) {
            ui.mainTextArea.setText("You shoot, but barely hit. The man hears the bullet whizz past and throws the grenade at the Convoy. The grenade explodes and the trucks go with it. The massive explosion blasts you back in to the entry hall and you hit your neck on the desk.");
            ui.choice1.setText(">");
            ui.choice2.setText("");

            game.nextPosition1 = "Death";
        } else {
            ui.mainTextArea.setText("You hit the man in the middle of his eyes. He drops down on the floor.\n\nThe soldiers come to arms hearing the shot. You get swarmed by two soldiers.");
            ui.choice1.setText(">");
            ui.choice2.setText("");

            game.nextPosition1 = "handcuffedConvoy";
        }
    }
    public void handcuffedConvoy() {
        ui.mainTextArea.setText("You get handcuffed by the soldiers and put in to a truck from the convoy.\n\n You try to explain why you shot the man but they won't listen to you.\n\nAt the Quarantine Zone you get put in prison and sit out your days in silence.");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "aliveButHow";
    }
    public void aliveButHow() {
        ui.mainTextArea.setText("After a year or two in prison the vaccine comes out. Everyone gets vaccinated as soon as possible and you get released by reasoning special circumstances. \n\nYou roam around the quarantine zone and find the forest cabin of your brother.\nSadly on inspecting inside you find the remains of what you believe to be your brother.");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "endKnife";
    }
    public void endKnife() {
        ui.mainTextArea.setText("You bury your brothers remains and live out the rest of your days in his cabin, becoming self providing and walled off for the remaining Zombies roaming the wild");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "Victory";
    }

//    TV Storyline
    public void tv() {
        ui.mainTextArea.setText("Your TV turns on. You see a video from the president urging people to stay calm, follow quarantine instructions from the army and follow evacuation plans");
        ui.choice1.setText("You get your phone and call your brother");
        ui.choice2.setText("You walk over to the door and open it");
        ui.choice3.setText("You walk to your home-vault to arm yourself");
        ui.choice4.setText("");

        game.nextPosition1 = "phone";
        game.nextPosition2 = "frontDoor";
        game.nextPosition3 = "vault";
    }
    public void vault() {
        player.currentWeapon = new Glock_18();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        ui.mainTextArea.setText("You unlock your home-vault and find your Glock-18 Pistol with three magazines containing ammo");
        ui.choice1.setText("Call your brother");
        ui.choice2.setText("Wait until the person at the door leaves to exit your apartment");
        ui.choice3.setText("Exit your apartment through you fire escape staircase outside your window");
        ui.choice4.setText("");

        game.nextPosition1 = "phone";
        game.nextPosition2 = "frontDoorNoSoldier";
        game.nextPosition3 = "fireEscape";
    }
//    FIRE ESCAPE
    public void fireEscape() {
        ui.mainTextArea.setText("You climb down your fire escape and land in the alley on the side of your apartment complex");
        ui.choice1.setText("Go right, towards the entrance of your apartment complex");
        ui.choice2.setText("Go left, away from your apartment complex");
        ui.choice3.setText("");

        game.nextPosition1 = "exitAlleyRight";
        game.nextPosition2 = "leftExitAlley";

    }
    public void exitAlleyRight() {
        ui.mainTextArea.setText("You come out of the alley and see a convoy of army trucks standing close to the entrance of your apartment complex");
        ui.choice1.setText("Go back and exit the alley on the other side");
        ui.choice2.setText("Walk towards the convoy");
        ui.choice3.setText("");

        game.nextPosition1 = "exitAlleyLeft";
        game.nextPosition2 = "engageConvoy";
    }
    public void engageConvoy() {
        ui.mainTextArea.setText("You start walking towards the convoy as you see a man coming out of an alley on the opposite side of the street.\nThe way he walks gives away he is probably armed with a rifle concealed under his Jacket\n\nWhat do you do");
        ui.choice1.setText("You aim for the guy to shoot him before he can open fire");
        ui.choice2.setText("You sprint to him to see if you can tackle him");
        ui.choice3.setText("You go back in the alley you came from and walk to the other exit of the alley");

        game.nextPosition1 = "safeConvoy";
        game.nextPosition2 = "runToTackle";
        game.nextPosition3 = "leftExitAlley";
    }
    public void runToTackle() {
        ui.mainTextArea.setText("You sprint to him, only te see him toss a grenade at the convoy. The grenade lands as the guy opens fire.\n\nThe explosion triggers a chain explosion of the convoy trucks exploding. You get blown to ground from the shock. Before you can get up the street get swarmed by Zombies");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");

        game.nextPosition1 = "Death";
    }
//    FRONTDOOR NO SOLDIER
    public void frontDoorNoSoldier() {
        ui.mainTextArea.setText("You enter the hallway as the elevator goes back down. Your older female neighbour comes out of her apartment and asks:\n'Would you be a dear and help me down to the lobby in the elevator?'\nThe elevator comes back up\n\nWhat do you do?");
        ui.choice1.setText("You leave her where she is standing and go down the stairs");
        ui.choice2.setText("You help her and take the elevator down");
        ui.choice3.setText("");

        game.nextPosition1 = "leaveStaircase";
        game.nextPosition2 = "leaveElevator";
    }
    public void leaveElevator() {
        ui.mainTextArea.setText("As the elevator starts going down you hear a loud scream coming from multiple floors up. The scream comes in fast and as it seems right next to you the hatch on the ceiling of the elevator breaks open as the janitor falls between you and your neighbour");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "elevatorChaos";
    }
    public void elevatorChaos() {
        ui.mainTextArea.setText("The janitor slowly starts moving again. He stands back up and you see his eyes dull and grey. As he snaps his neck in place again he sees you and in a flash his teeth are drilled in to your neck, you choke on your own blood and life fades away.");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "Death";
    }
//    LEAVE STAIRCASE
    public void leaveStaircase() {
        ui.mainTextArea.setText("When you arrive downstairs and open the door to the entry hall you see the doorman dead at his desk.\n\nWhat do you do?");
        ui.choice1.setText("You walk to the front door and go outside");
        ui.choice2.setText("You walk to the doorman and search his body");

        game.nextPosition1 = "frontDoorConvoy";
        game.nextPosition2 = "searchDoorMan";
    }
    public void searchDoorMan() {
        ui.mainTextArea.setText("You check the body of the doorman and in his inside pocket you find a car key.\n\nWhat do you do?");
        ui.choice1.setText("Go to the front door to exit the apartment complex");
        ui.choice2.setText("Take the stairs further down to the garage of the apartment complex");

        game.nextPosition1 = "frontDoorConvoy";
        game.nextPosition2 = "downToGarageDoorman";
    }
    public void downToGarageDoorman() {
        ui.mainTextArea.setText("You walk in to the garage and continuously click on the key to find the car that belongs to the doorman.");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "enterDoormanCar";
    }
    public void enterDoormanCar() {
        ui.mainTextArea.setText("The car from the doorman unlocks 2 rows over. You walk to it and enter the car.\n\nWhat do you do?");
        ui.choice1.setText("Call your brother");
        ui.choice2.setText("Drive the car out of the garage");

        game.nextPosition1 = "phone";
        game.nextPosition2 = "driveAlone";
    }
    public void driveAlone() {
        ui.mainTextArea.setText("You drive out of the garage and take a right in to the still standing convoy.\nA soldier comes walking up to you and goes: 'You can drive around the trucks, here is a map locating the quarantine zone. Drive there and you will be safe'\nHe hands over a map that shows where to go");
        ui.choice1.setText("Drive to the quarantine zone");
        ui.choice2.setText("Call your brother");

        game.nextPosition1 = "driveToQuarantine";
        game.nextPosition2 = "phone";
    }
    public void driveToQuarantine() {
        ui.mainTextArea.setText("You start driving past the trucks. All of the sudden you hear screams coming from the soldiers, shots are being fired. An explosion at the back of the trucks hit and in a chain reactions the trucks explode. Driving next to it you car gets blasted in to the buildings. You lose consciousness");
        ui.choice1.setText(">");
        ui.choice2.setText("");

        game.nextPosition1 = "Death";
    }

//    DEATH
    public void Death() {
        vm.showTitleScreen();
        ui.titleNameLabel.setText("GAME OVER");
        ui.titleNameLabel.setForeground(Color.red);
        ui.startButton.setText("Restart");

        game.nextPosition1 = "Restart";
    }
//    Victory
    public void Victory() {
        vm.victoryScreen();
        ui.victoryTextArea.setText("You've finished the game alive in one of the ways possible!!\n\nWant to try again?");
        ui.startButton.setText("Restart");

        game.nextPosition1 = "Restart";
    }
}































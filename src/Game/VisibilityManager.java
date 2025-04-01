package Game;

public class VisibilityManager {
    UI ui;
    public VisibilityManager(UI userInterface) {
        ui = userInterface;
    }
    public void showTitleScreen(){

        //show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButton.setVisible(true);

        //hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.victoryPanel.setVisible(false);
    }
    public void titleMainScreen(){

        //hide titleScreen
        ui.titleNamePanel.setVisible(false);
        ui.startButton.setVisible(false);
        //show game screen - playerPanel
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(false);
    }
    public void playingScreen(){
        //hide titleScreen
        ui.startButton.setVisible(false);
        ui.titleNamePanel.setVisible(false);
        //show game screen + playerPanel
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
    public void victoryScreen(){
        ui.victoryPanel.setVisible(true);
        ui.startButton.setVisible(true);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.titleNamePanel.setVisible(false);
    }
}

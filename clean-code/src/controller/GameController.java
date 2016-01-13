package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import messages.GameMessages;
import models.CpuPlayerModel;
import models.GameObjectModel;
import models.HumanPlayerModel;

import org.apache.commons.lang3.Validate;

/**
 * @author Dominic Dahnelt
 */
public class GameController {
    private InputStreamReader     isr                 = new InputStreamReader(
                                                              System.in);
    private BufferedReader        br                  = new BufferedReader(isr);
    private HumanPlayerModel      humanPlayer;
    private CpuPlayerModel        cpuPlayer;

    private boolean               isEndOfGame         = false;
    private String                input               = "0";

    private static final String   CPU_NAME            = "CPU";
    private static final String   END_OF_GAME         = "e";
    private static final String   GAME_RULES          = "r";
    private static final String   STONE               = "Stein";
    private static final String   SCISSORS            = "Schere";
    private static final String   PAPER               = "Papier";
    private static final String   SAURIAN             = "Echse";
    private static final String   SPOCK               = "Spock";
    private static final int      POINTS_AT_WIN       = 1;

    private List<GameObjectModel> gameObjects         = new ArrayList();

    /** Public Constructor */
    public GameController() {     
        initGame();
        startGame();
    }

    /** Start the game */
    private void startGame() {  
        while (!isEndOfGame) {
            try {
                System.out.println(GameMessages.getChoiceInputMessage());
                input = br.readLine();
                if (input.equals(GAME_RULES) || input.equals(END_OF_GAME)) {
                    switch(input){
                    case END_OF_GAME:
                        System.out.println(GameMessages.getEndOfGameMessage());
                        this.isEndOfGame = true;
                        break;
                    case GAME_RULES:
                        System.out.println(GameMessages.getGameRules());
                        break;
                    }
                } else {
                    humanPlayer.setChoice(new GameObjectModel(
                            decodeInput(input)));
                    cpuPlayer.setChoice(new GameObjectModel(decodeInput(Integer
                            .toString(cpuPlayer.getCpuChoice()))));

                    // Human Player won
                    if (hasHumanPlayerWon(humanPlayer, cpuPlayer)) {
                        humanPlayer.setScore(humanPlayer.getScore()
                                + POINTS_AT_WIN);
                        System.out.println(GameMessages.getWinMessage());

                        // Undecided
                    } else if (humanPlayer.getChoice().getGameObjectName()
                            .equals(cpuPlayer.getChoice().getGameObjectName())) {
                        System.out.println(GameMessages.getUndecidedMessage());

                        // HumanPlayer lost
                    } else {
                        cpuPlayer
                                .setScore(cpuPlayer.getScore() + POINTS_AT_WIN);
                        System.out.println(GameMessages.getLostMessage());
                    }
                    System.out.println(GameMessages.getGameScoreMessage(
                            humanPlayer.getScore(), cpuPlayer.getScore()));
                }
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }

    private String decodeInput(String input) {
        String choice = "";
        switch (input) {
        case "1":
            choice = STONE;
            break;
        case "2":
            choice = SCISSORS;
            break;
        case "3":
            choice = PAPER;
            break;
        case "4":
            choice = SAURIAN;
            break;
        case "5":
            choice = SPOCK;
            break;        
        default:
            choice = GameMessages.getInputErrorMessge();
        }
        return choice;
    }

    /** Initialize Game */
    private void initGame() {
        System.out.println(GameMessages.getGameRules());
        initPlayers();
        this.gameObjects = initGameObjects(new ArrayList<String>(Arrays.asList(
                STONE, PAPER, SCISSORS, SAURIAN, SPOCK)));
        resetScores(this.humanPlayer, this.cpuPlayer);
    }

    /** Reset scores from all players */
    private void resetScores(HumanPlayerModel human, CpuPlayerModel cpu) {
        human.setScore(0);
        cpu.setScore(0);
    }

    /** Initialize GameObject by given List */
    private List<GameObjectModel> initGameObjects(List<String> gameObjectNames) {
        Validate.notNull(gameObjectNames);
        List<GameObjectModel> gameObjectList = new ArrayList();
        for (String objectName : gameObjectNames) {
            gameObjectList.add(new GameObjectModel(objectName));
        }
        return gameObjectList;
    };

    /** Initialize human-player and cpu-player */
    private void initPlayers() {

        try {
            System.out.println(GameMessages.getNameInputMessage());
            String input = br.readLine();
            this.humanPlayer = new HumanPlayerModel(input);

        } catch (Exception e) {
            System.out.println("InputError " + e.getMessage());
        }
        this.cpuPlayer = new CpuPlayerModel(CPU_NAME);     
    }

    /**
     * Cheacks if the humanPlayer won the round
     * 
     * @return boolean
     */
    private boolean hasHumanPlayerWon(HumanPlayerModel human, CpuPlayerModel cpu) {
        boolean isHumanWinner = false;
        switch (human.getChoice().getGameObjectName()) {
        case STONE:
            if (cpu.equals(SCISSORS) || cpu.equals(SAURIAN)) {
                isHumanWinner = true;
            }
            break;
        case SCISSORS:
            if (cpu.equals(PAPER) || cpu.equals(SAURIAN)) {
                isHumanWinner = true;
            }
            break;
        case PAPER:
            if (cpu.equals(STONE) || cpu.equals(SPOCK)) {
                isHumanWinner = true;
            }
            break;
        case SAURIAN:
            if (cpu.equals(SPOCK) || cpu.equals(PAPER)) {
                isHumanWinner = true;
            }
            break;
        case SPOCK:
            if (cpu.equals(STONE) || cpu.equals(SCISSORS)) {
                isHumanWinner = true;
            }
            break;
        }
        return isHumanWinner;
    }
}

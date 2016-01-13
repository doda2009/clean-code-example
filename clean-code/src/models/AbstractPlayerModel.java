package models;

import org.apache.commons.lang3.Validate;

/**
 * Abstract class for players
 * 
 * @author Dominic Dahnelt
 */
public class AbstractPlayerModel {

    /** Name of player */
    public String          playerName;

    /** Score of player */
    public int             score;

    /** Choice of Player */
    public GameObjectModel choice;

    /** Public Constructor */
    public AbstractPlayerModel(String name) {
        Validate.notBlank(name);
        this.playerName = name;
    }

    /** Returns name of player */
    public String getName() {
        return this.playerName;
    }

    /** Returns score of player */
    public int getScore() {
        return this.score;
    }

    /** Set name of player */
    public void setName(String name) {
        this.playerName = name;
    }

    /** Set score of player */
    public void setScore(int score) {
        this.score = score;
    }

    /** Returns players choice of GameObject */
    public GameObjectModel getChoice() {
        return choice;
    }

    /** Set players choice of GameObject */
    public void setChoice(GameObjectModel choice) {
        this.choice = choice;
    }

}

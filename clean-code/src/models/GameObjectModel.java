package models;

import org.apache.commons.lang3.Validate;

/**
 * @author Dominic Dahnelt
 */

public class GameObjectModel {
    /** Name of GameObject */
    private String gameObjectName;

    /** Public Constructor */
    public GameObjectModel(String name) {
        Validate.notBlank(name);
        this.gameObjectName = name;
    }

    /** Returns the name of the GameObject */
    public String getGameObjectName() {
        return this.gameObjectName;
    }
}

package messages;

/**
 * @author Dominic Dahnelt
 */

public class GameMessages {

    private static final String MSG_NAME        = "Bitte gib deinen Namen ein:";
    private static final String MSG_CHOICE      = "Bitte triff deine Auswahl:";
    private static final String MSG_INPUT_ERROR = "Deine Auswahl wurde nicht erkannt. Bitte versuch es noch einmal.";
    private static final String MSG_END_OF_GAME = "Das Spiel ist beendet!";
    private static final String MSG_WIN         = "Du hast die Runde gewonnen!";
    private static final String MSG_LOST        = "Du hast die Runde verloren!";
    private static final String MSG_UNDECIDED   = "Die Runde geht untentschieden aus!";
    private static final String MSG_PLAYER      = "Player:";
    private static final String MSG_CPU         = "CPU:";
    private static final String MSG_RULES       = " #### TextGames - Stein-Schere-Papier-Echse-Spock ### \n"
                                                        + "Spielregeln \n"
                                                        + "Stein-Schere-Papier mit folgenden erweiterten Regeln:\n"
                                                        + "Basisregeln:\n"
                                                        + "- Stein schlägt Schere \n"
                                                        + "- Schere schneidet Papier\n"
                                                        + "- Papier wickelt Stein ein\n"
                                                        + "Erweiterte Regeln:\n"
                                                        + "- Schere tötet Echse\n"
                                                        + "- Echse frisst Spock\n"
                                                        + "- Echse siegt über Papier\n"
                                                        + "- Spock zermalmt Stein\n"
                                                        + "- Spock triumphiert über Schere\n"
                                                        + "- Papier schlägt Spock\n"
                                                        + "- Stein tötet Echse\n"
                                                        + "#################################\n"
                                                        + "Spielablauf: \n"
                                                        + "Gib eine Zahl ein von 1 - 5 und bestätige mit 'ENTER'\n"
                                                        + "Die Zahlen stehen für: \n"
                                                        + "1 = Stein\n"
                                                        + "2 = Schere\n"
                                                        + "3 = Papier\n"
                                                        + "4 = Echse\n"
                                                        + "5 = Spock\n"
                                                        + "####\n"
                                                        + "Weitere verfügbare Optionen:\n"
                                                        + "Zum Beenden des Spiels gib 'e' ein und bestätige mit 'ENTER'\n"
                                                        + "Um die Spielregeln nochmal anzuzeigen, gib'r' ein und bestätige mit 'ENTER'\n"
                                                        + "\n" + "\n";

    /** Returns message for enter input */
    public static String getNameInputMessage() {
        return MSG_NAME;
    }

    /** Returns message for choosing a GameObject */
    public static String getChoiceInputMessage() {
        return MSG_CHOICE;
    }

    /** Returns message for choosing unknown input by human player */
    public static String getInputErrorMessge() {
        return MSG_INPUT_ERROR;

    }

    /** Returns message for End of Game */
    public static String getEndOfGameMessage() {
        return MSG_END_OF_GAME;
    }

    /** Returns rules for this game */
    public static String getGameRules() {
        return MSG_RULES;
    }

    /** Returns win-message for humanPlayer */
    public static String getWinMessage() {
        return MSG_WIN;
    }

    /** Returns lost-message for humanPlayer */
    public static String getLostMessage() {
        return MSG_LOST;
    }

    /** Returns undecided-message for humanPlayer */
    public static String getUndecidedMessage() {
        return MSG_UNDECIDED;
    }

    /** Returns undecided-message for humanPlayer */
    public static String getGameScoreMessage(int playerPoints, int cpuPoints) {
        return MSG_PLAYER + " " + playerPoints + " " + MSG_CPU + " "
                + cpuPoints;
    }

}

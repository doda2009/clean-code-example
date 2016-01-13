import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StoneScissorsPaperSaurianSpock {

	private static int getNpcChoice() {
		int cpuChoice;
		double random = Math.random() * 5;
		cpuChoice = (int) random + 1;
		return cpuChoice;
	}

	public static void printRules() {
		System.out
				.print("#### TextGames - Stein-Schere-Papier-Echse-Spock ### \n");
		System.out.println("Spielregeln:");
		System.out
				.println("Stein-Schere-Papier mit folgenden erweiterten Regeln:");
		System.out.println("Basisregeln:");
		System.out.println("- Stein schlägt Schere ");
		System.out.println("- Schere schneidet Papier");
		System.out.println("- Papier wickelt Stein ein");
		System.out.println("Erweiterte Regeln:");
		System.out.println("- Schere tötet Echse");
		System.out.println("- Echse frisst Spock");
		System.out.println("- Echse siegt über Papier");
		System.out.println("- Spock zermalmt Stein");
		System.out.println("- Spock triumphiert über Schere");
		System.out.println("- Papier schlägt Spock");
		System.out.println("- Stein tötet Echse");
		System.out.println("#################################");
		System.out.println("Spielablauf: ");
		System.out
				.println("Gib eine Zahl ein von 1 - 5 und bestätige mit 'ENTER'");
		System.out.println("Zum Beenden gib 'e' ein und bestätige mit 'ENTER'");
		System.out
				.println("Um die Spielregeln nochmal anzuzeigen, gib'r' ein und bestätige mit 'ENTER'");
		System.out.println("Die Zahlen stehen für: ");
		System.out.println("1 = Stein");
		System.out.println("2 = Schere");
		System.out.println("3 = Papier");
		System.out.println("4 = Echse");
		System.out.println("5 = Spock");
	}

	public static void main(String[] args) { //
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		printRules();
		System.out.println("\nDeine Auswahl:");

		String input, choiceName;
		input = "0";
		
		boolean endOfGame = false;
		int playerScore = 0;
		int cpuScore = 0;
		while (endOfGame == false) {
			try {
				input = br.readLine();

				String playersChoice = getChoiceName(input);
				System.out.println("Du hast '" + playersChoice
						+ "' ausgewählt.");
				switch (input) {
				case "e":
					endOfGame = true;
					break;
				case "r":
					printRules();
					break;
				default:
					if (!playersChoice.contains("Falsche Eingabe")) {
						//
						int cpuChoice = getNpcChoice();
						String cpuChoiceName = getChoiceName(String
								.valueOf(cpuChoice));
						System.out.println("Der Computer hat '" + cpuChoiceName
								+ "' ausgewählt.");

						if (!playersChoice.equals(cpuChoiceName)) {

							boolean playerWon = compareChoices(playersChoice,
									cpuChoiceName);

							if (playerWon) {
								playerScore++;
								System.out.println("Du hast gewonnen!");
							} else {
								cpuScore++;
								System.out.println("Du hast verloren");
							}
						} else {
							System.out.println("Unentschieden!");
						}
						System.out.println("Spielstand: Player: " + playerScore
								+ " CPU: " + cpuScore);
					}
				}
			} catch (IOException e) {
				System.out.println("ERROR " + e.getMessage());
			}
		}
		System.out.println("Das Spiel ist beendet!");
	}

	private static String getChoiceName(String choice) {
		String choiceName;
		switch (choice) {
		case "1":
			choiceName = "Stein";
			break;
		case "2":
			choiceName = "Schere";
			break;
		case "3":
			choiceName = "Papier";
			break;
		case "4":
			choiceName = "Echse";
			break;
		case "5":
			choiceName = "Spock";
			break;
		case "e":
			choiceName = "Spielende";
			break;
		case "r":
			choiceName = "Spielregeln";
			break;
		default:
			choiceName = "Falsche Eingabe. Versuchs nochmal!";
		}
		return choiceName;
	}

	private static boolean compareChoices(String player, String cpu) {
		boolean playerWon = false;
		switch (player) {
		case "Stein":
			if (cpu.equals("Schere") || cpu.equals("Echse")) {
				playerWon = true;
			}

			break;
		case "Schere":
			if (cpu.equals("Papier") || cpu.equals("Echse")) {
				playerWon = true;
			}
			break;
		case "Papier":
			if (cpu.equals("Stein") || cpu.equals("Spock")) {
				playerWon = true;
			}
			break;
		case "Echse":
			if (cpu.equals("Spock") || cpu.equals("Papier")) {
				playerWon = true;
			}
			break;
		case "Spock":
			if (cpu.equals("Stein") || cpu.equals("Schere")) {
				playerWon = true;
			}
			break;
		}
		return playerWon;
	}
}

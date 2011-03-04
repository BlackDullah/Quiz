import java.io.Console;

public class Quiz {

	int quizPosition = 0;
	int points = 0;

	UserName userName;
	Reader reader;
	String myString = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Quiz quiz = new Quiz();

	}

	public Quiz() {
		reader = new Reader();
		userName = new UserName();
		reader.quizStart();

		name();
	}

	public void name() {

		Console console = System.console();
		userName.name = console.readLine("Geben Sie Ihren Vornamen an: ");
		System.out.println("Hallo " + userName.name);

		System.out.println("Ich habe ein kleines Quiz fuer dich erstellt...");
		quiz(0);
	}

	public void quiz(int position) {
		if (position >= (reader.values.size() - 1)) {
			quizend();
			return;
		}
		System.out.println(reader.values.get(position)[0]);
		Console console = System.console();
		myString = console.readLine("Antwort: ");

		if (myString.equalsIgnoreCase(reader.values.get(position + 1)[0])) {
			points++;
			System.out.println("Richtig, du hast " + points + " von 7 Punkten");
			position = position + 2;

			quiz(position);
		}

		else {
			points--;
			System.out
					.println("Falsch, du hast einen Punkt abgezogen bekommen. Dein aktueller Punktestand lautet: "
							+ points + " von 7 Punkten!");
			quiz(position);
		}

	}

	public void quizend() {
		System.out.println("Herlichen Glueckwunsch " + userName.name);
		System.out.println("du hast das Quiz erfolgreich beendet und " + points
				+ " von 7 Punkten erreicht!");

		System.out.println("Moechtest du das Quiz erneut starten?");
		System.out.println("Geben Sie JA oder NEIN ein!");

		Console console = System.console();
		String answer = console.readLine("Antwort: ");
		System.out.println("Text: " + answer);

		checkName(answer);
	}

	public void checkName(String ans) {

		if (ans.equalsIgnoreCase("JA")) {
			System.out.println(ans + " ich moechte das Quiz wiederholen!");

			quiz(0);

		} else {
			System.out.println("Bist du dir sicher?");

			Console console = System.console();
			String sure = console.readLine("Antwort: ");
			System.out.println("Text: " + sure);

			nachfragen(sure);

		}
	}

	public void nachfragen(String sure) {

		if (sure.equalsIgnoreCase("JA")) {
			System.out.println(userName.name + " hat das Spiel beendet!");
		} else if (sure.equals("NEIN")) {
			quizend();

		} else {
			checkName("");
		}

	}

}

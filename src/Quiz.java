import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Quiz {

	int quizPosition = 0;
	ArrayList<String[]> values = new ArrayList<String[]>();
	UserName userName;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Quiz quiz = new Quiz();
		quiz.quizStart();
	}

	public Quiz() {
		userName = new UserName();
	}

	public void quizStart() {
		BufferedReader reader;
		String zeile = null;

		try {
			reader = new BufferedReader(new FileReader("fragen.txt"));
			zeile = reader.readLine();

			while (zeile != null) {
				values.add(zeile.split(";"));
				zeile = reader.readLine();
			}
			// System.out.println(values.size());

		} catch (IOException e) {
			System.err.println("Error2 :" + e);
		}

		// showQuestions(values);
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
		if (position >= (values.size() - 1)) {
			quizend();
			return;
		}
		System.out.println(values.get(position)[0]);
		Console console = System.console();
		String myString = console.readLine("Antwort: ");

		if (myString.equalsIgnoreCase(values.get(position + 1)[0])) {
			System.out.println("Richtig");
			position = position + 2;
			quiz(position);
		}

		else {
			quiz(position);
		}

	}

	public void quizend() {
		System.out.println("Herlichen Glueckwunsch " + userName.name);
		System.out.println("du hast das Quiz erfolgreich beendet!");

		System.out.println("Moechtest du das Quiz erneut starten?");
		System.out.println("Geben Sie JA oder NEIN ein!");

		Console console = System.console();
		String answer = console.readLine("Antwort: ");
		System.out.println("Text: " + answer);

		checkName(answer);
	}

	public void checkName(String ans) {

		if (ans.equals("JA")) {
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

		if (sure.equals("JA")) {
			System.out.println(userName.name + " hat das Spiel beendet!");
		} else if (sure.equals("NEIN")) {
			quizend();

		} else {
			checkName("");
		}

	}

}

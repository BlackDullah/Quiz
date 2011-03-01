import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Quiz {

	int quizPosition = 0;
	static ArrayList<String[]> values = new ArrayList<String[]>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

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

		System.out.println("Ein kleines Quiz...");
		quiz(0);
	}

	public static void quiz(int position) {
		if (position >= 9) {
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

	public static void ende() {
		System.out
				.println("Herlichen Gl�ckwunsch, Sie haben das Quiz erfolgreich beendet!");
	}

}

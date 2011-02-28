import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Quiz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader reader;
		String zeile = null;
		ArrayList<String[]> values = new ArrayList<String[]>();

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

		showQuestions(values);

		System.out.println("Ein kleines Quiz...");
		// frage1();
	}

	public static void showQuestions(ArrayList<String[]> values) {
		// System.out.println(values.get(0)[0]);
		// System.out.println(values.get(1)[0]);

		for (int i = 1; i < 10; i++) {
			System.out.println(values.get(i)[0]);
			i++;
		}
	}

	public static void frage1() {

		System.out
				.println("Die erste Frage lautet: In welcher Sprache ist dieses Programm geschrieben?");
		Console console = System.console();
		String myString = console.readLine("Antwort: ");

		if (myString.equalsIgnoreCase("Java")) {
			System.out.println("Richtig");
			frage2();

		}

		else {
			frage1();
		}

	}

	public static void frage2() {

		System.out.println("Wie hei§t dieses Progrmm?");
		Console console = System.console();
		String myString = console.readLine("Antwort: ");

		if (myString.equalsIgnoreCase("Quiz")) {
			System.out.println("Richtig");

		}

		else {
			frage2();
		}

	}

}

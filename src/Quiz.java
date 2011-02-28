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

		try {
			reader = new BufferedReader(new FileReader("fragen.txt"));
			String zeile = reader.readLine();
			ArrayList<String> values = new ArrayList<String>();
			while (zeile != null) {
				values.add(zeile.split(";").toString());

			}
			System.out.println(values.size());
			System.out.println(zeile);

		} catch (IOException e) {
			System.err.println("Error2");
		}

		System.out.println("Ein kleines Quiz...");
		frage1();

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

		System.out.println("XXXX");
		Console console = System.console();
		String myString = console.readLine("Antwort: ");

		if (myString.equalsIgnoreCase("Java")) {
			System.out.println("Richtig");

		}

		else {
			frage2();
		}

	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	ArrayList<String[]> values = new ArrayList<String[]>();

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
	}
}

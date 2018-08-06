package utf8ToAnsi;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;

/**
 * Main-Method class, excecutes the program
 * 
 * @author Karim Omar
 * @version 2018-08-02
 *
 */

public class CorrectionExec {

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		// changeing java charset to ANSI
		System.setProperty("file.encoding", "Cp1252");
		Field charset = Charset.class.getDeclaredField("defaultCharset");
		charset.setAccessible(true);
		charset.set(null, null);
		
		
		Correction c = new Correction();
		c.chooseFile(args);
		String name = c.getNewName().replace("\\", "\\\\");
		String text = c.getText();
		try (PrintWriter out = new PrintWriter(name)) {
			out.write(text);

			JOptionPane.showMessageDialog(null, "Konvertieren abgeschlossen!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}

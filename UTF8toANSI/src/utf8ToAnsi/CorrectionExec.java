package utf8ToAnsi;

import java.io.FileNotFoundException;
import utf8ToAnsi.Correction;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;

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
		c.chooseFile();
		ArrayList<String> name = c.getNewName();
		ArrayList<String> text = c.getText();
		
		for(int i=0; i<name.size();i++) {
			String name1=name.get(i);
			String text1=text.get(i);
			try (PrintWriter out = new PrintWriter(name1)) {
				out.write(text1);
	
				JOptionPane.showMessageDialog(null, "Konvertieren abgeschlossen!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}

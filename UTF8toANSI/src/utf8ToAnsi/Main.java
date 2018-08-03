package utf8ToAnsi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * Main-Method class, excecutes the program
 * @author Karim Omar
 * @version 2018-08-02
 *
 */

public class Main {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		//changeing java charset to ANSI
		System.setProperty("file.encoding","Cp1252");
		Field charset = Charset.class.getDeclaredField("defaultCharset");
		charset.setAccessible(true);
		charset.set(null,null);
		Correction c= new Correction();
		c.chooseFile();
		String name=c.getNewName().replace("\\","\\\\");
		System.out.println(name);
		String text=c.getText();
		try(PrintWriter out=new PrintWriter(name)){
			out.write(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

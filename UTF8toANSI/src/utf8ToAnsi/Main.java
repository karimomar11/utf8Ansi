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
 * 
 * @author Karim Omar
 * @version 2018-08-02
 *
 */

public class Main {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Correction c= new Correction();
		c.chooseFile();
		String name=c.getNewName().replace("\\","\\\\");
		System.out.println(name);
		String text=c.getText();
		try(PrintWriter out=new PrintWriter(name)){
			out.write(text);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

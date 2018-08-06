package utf8ToAnsi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;


/**
 * necessary methods for converting
 * 
 * @author Karim Omar
 * @version 2018-08-02
 *
 */
public class Correction {

	private ArrayList<String> text;
	private ArrayList<String> newName;
	
	public Correction() {
		this.text=null;
		this.newName=null;
	}
	/**
	 * Method for correcting the input text
	 * 
	 * @param csv input text
	 * @return corrected text
	 */
	public static String correctedCSV(String csv) {
		ArrayList<String> list = new ArrayList<String>();

		String correct = csv;

		list.add(correct);

		correct = correct.replace("Ä", "Ae");
		list.add(correct);

		correct = list.get(1);
		correct = correct.replace("Ö", "Oe");
		list.add(correct);

		correct = list.get(2);
		correct = correct.replace("Ü", "Ue");
		list.add(correct);

		correct = list.get(3);
		correct = correct.replace("ä", "ae");
		list.add(correct);

		correct = list.get(4);
		correct = correct.replace("ö", "oe");
		list.add(correct);

		correct = list.get(5);
		correct = correct.replace("ü", "ue");
		list.add(correct);

		correct = list.get(6);
		correct = correct.replace("ß", "ss");
		list.add(correct);

		return correct;
	}

	/**
	 * Method which is choosing the file to correct and sets the attributes
	 */
	public void chooseFile()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		this.text=new ArrayList<String>();
		this.newName=new ArrayList<String>();
		String[] data = new String[3];
		// changeing java charset to UTF-8
		System.setProperty("file.encoding", "UTF-8");
		Field charset = Charset.class.getDeclaredField("defaultCharset");
		charset.setAccessible(true);
		charset.set(null, null);

		// open file
		String path = "C:\\\\Users\\\\administrator\\\\Documents\\\\TESTING";
		String name = "";
		String newName = "";
		String t = "";
		ArrayList<String> filesOfDir=new ArrayList<String>();
		File[] files = new File(path).listFiles();
		for(File f:files) {
			if(f.isFile()) {
				filesOfDir.add(f.getAbsolutePath());
			}
		}

		//file = args[0];
		for(int i=0;i<filesOfDir.size();i++) {
			ArrayList<String> list = new ArrayList<String>();
			String text = null;
			String actualFile = filesOfDir.get(i);
			try (BufferedReader br = new BufferedReader(new FileReader(actualFile))) {
	
				// running through every line of this file
				while ((text = br.readLine()) != null) {
					// saving every line into list
					list.add(text);
				}
	
				for (int ii = 0; ii < list.size(); ii++) {
					// putting every line aligned into string
					t += Correction.correctedCSV(list.get(ii)) + " \n";
				}
	
				File path1 = new File(actualFile);
		
				name = path1.getName();
				newName = actualFile.replace(name, "ANSI_FILES\\\\ansi_" + name);
	
				data[0] = t;
				data[1] = newName;
	
				//setText(data[0]);
				//setNewName(data[1]);
				this.text.add(t);
				this.newName.add(newName.replace("\\", "\\\\"));
				
				t="";
				
				path1.deleteOnExit();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// getters and setters

	public ArrayList<String> getText() {
		return text;
	}

	public void setText(ArrayList<String> text) {
		this.text = text;
	}

	public ArrayList<String> getNewName() {
		return newName;
	}

	public void setNewName(ArrayList<String> newName) {
		this.newName = newName;
	}
}

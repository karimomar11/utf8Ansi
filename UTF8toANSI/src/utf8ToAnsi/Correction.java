package utf8ToAnsi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * necessary methods for converting
 * @author Karim Omar
 * @version 2018-08-02
 *
 */
public class Correction {
	
	private String text;
	private String newName;
	/**
	 * Method for correcting the input text
	 * @param csv input text
	 * @return corrected text
	 */
	public static String correctedCSV(String csv) {
		ArrayList<String> list= new ArrayList<String>();
		
		String correct = csv;
			
		list.add(correct);
		
		correct = correct.replace("Ä", "Ae");
		list.add(correct);
		
		correct = list.get(1);
		correct=correct.replace("Ö", "Oe");
		list.add(correct);

		correct = list.get(2);
		correct=correct.replace("Ü", "Ue");
		list.add(correct);

		correct = list.get(3);
		correct=correct.replace("ä", "ae");
		list.add(correct);

		correct = list.get(4);
		correct=correct.replace("ö", "oe");
		list.add(correct);

		correct = list.get(5);
		correct=correct.replace("ü", "ue");
		list.add(correct);

		correct = list.get(6);
		correct=correct.replace("ß", "ss");
		list.add(correct);
	
		return correct;
	}
	
	/**
	 * Method which is choosing the file to correct
	 * and sets the attributes
	 */
	public void chooseFile() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String[] data = new String[2];
		//changeing java charset to UTF-8
				System.setProperty("file.encoding","UTF-8");
				Field charset = Charset.class.getDeclaredField("defaultCharset");
				charset.setAccessible(true);
				charset.set(null,null);
				
				
				//open file
				String file="";
				String name="";
				String newName="";
				String t="";
				JFileChooser chooser =new JFileChooser();
				int returnValue = chooser.showOpenDialog(null);
				
				if(returnValue==JFileChooser.APPROVE_OPTION) {
					file=chooser.getSelectedFile().getAbsolutePath();
					name=chooser.getSelectedFile().getName();
				}
				
				ArrayList<String> list = new ArrayList<String>();
				String text=null;
				
				try (BufferedReader br = new BufferedReader(new FileReader(file))){
					
					//running through every line of this file
		 			while((text=br.readLine())!=null) {
						//saving every line into list
						list.add(text);
					}
					
						
					
					
					for(int i=0;i<list.size();i++) {
						//putting every line aligned into string 
						t+=Correction.correctedCSV(list.get(i))+" \n";
					}
					
					newName=file.replace(name, "ansi_"+name);
					
					data[0]= t;
					data[1]=newName;
					
					setText(data[0]);
					setNewName(data[1]);
					
				} 
				catch (IOException e) {
		            e.printStackTrace();
		        }
		
	}

	//getters and setters
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
}

package utf8ToAnsi;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test {
	public static void main(String[]args) {
		try(PrintWriter out =new PrintWriter("C:\\Users\\administrator\\Desktop\\haha.csv");) {
			out.println("HALLO");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

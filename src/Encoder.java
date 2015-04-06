import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Encoder {
	private File f;
	private ArrayList<String> letters = new ArrayList<String>();
	private String encodString;

	public Encoder(String filename)
	{
		File file = new File(filename);
		f = file;
	}
	
	public void write(String plaintext) throws IOException
	{
		for(int j = 0;j<plaintext.length()-1;j++)
		{
			letters.add(plaintext.substring(j, j+1));
		}
		//encoding letters in message provided
		for(int j = 0;j<letters.size();j++)
		{
			char c = letters.get(j).charAt(0);
			int encodChar = (int) c;
			encodChar = encodChar+17;
			encodString = ":" + encodChar;
		}
		
		FileWriter writer = new FileWriter(f,false);		
		writer.write(encodString);

	}
	
	public List<String> read()
	{
		return null;
		
	}
}

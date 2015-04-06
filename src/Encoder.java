import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Encoder {
	private File f;
	private ArrayList<String> letters = new ArrayList<String>();

	public Encoder(String filename)
	{
		File file = new File(filename);
		f = file;
	}
	
	public void write(String plaintext)
	{
		for(int j = 0;j<plaintext.length()-1;j++)
			{
				letters.add(plaintext.substring(j, j+1));
			}
		for(int j = 0;j<letters.size())
		

	}
	
	public List<String> read()
	{
		return null;
	}
}

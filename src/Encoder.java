import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Encoder {
	private File f;
	private ArrayList<String> user = new ArrayList<String>();
	private ArrayList<String> message = new ArrayList<String>();
	private ArrayList<String> readoutput = new ArrayList<String>();
	
	public Encoder(String filename)
	{
		File file = new File(filename);
		f = file;
	}
	
	public void write(String plaintext) throws IOException
	{
		user = new ArrayList<String>();
		message = new ArrayList<String>();
		String encodUser = "";
		String encodMessage = "";
		String encodFull = "";
		String[] usmes = plaintext.split("\t");
		
		
		for(int j = 0;j<usmes[0].length();j++)
		{
			user.add(usmes[0].substring(j, j+1));
		}
		//encoding letters in message provided
		for(int j = 0;j<usmes[1].length();j++)
		{
			message.add(usmes[1].substring(j,j+1));
		}
		
		for(int i = 0;i<user.size();i++)
		{
			char c = user.get(i).charAt(0);
			int encodChar = (int) c;
			encodChar = encodChar+2;
			encodUser = encodUser + "" + (char)encodChar;
		}
		for(int i = 0;i<message.size();i++)
		{
			char c = message.get(i).charAt(0);
			int encodChar = (int) c;
			encodChar = encodChar+2;
			encodMessage = encodMessage + "" + (char)encodChar;
		}
		
		encodFull = encodUser + ":" + encodMessage;
		try{
			FileWriter writer = new FileWriter(f, false);	
			System.out.println(encodFull);	
			writer.write(encodFull);
			writer.write("\n");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	}	
	}
	
	public List<String> read() throws FileNotFoundException
	{

			Scanner reader = new Scanner(f);
				while(reader.hasNextLine() == true)
			{
				String fullstring = reader.nextLine();
				String[] usmes = fullstring.split(":");
				String enuserName = usmes[0];
				String realUser = "";
				String realMessage = "";
				String[] indivwords = usmes[1].split("\"");
				
				for(int i = 0;i < enuserName.length();i++)
				{
					char c = enuserName.charAt(0);
					int realChar = (int) c;
					realChar = realChar - 2;
					realUser = realUser + "" + (char)realChar;
				}
				
				readoutput.add(realUser);
				
				for(int i = 0;i < indivwords.length;i++)
				{
					for(int j = 0;j<indivwords[i].length();i++)
					{
							char c = enuserName.charAt(0);
							int realChar = (int) c;
							realChar = realChar - 2;
							realMessage = realMessage + "" + (char)realChar;
					}
					realMessage += " ";
				}
				readoutput.add(realMessage);
			}
			return readoutput;
			

	}
	
	public static void main(String[] args)
	{
		Encoder en = new Encoder("file.txt");
		try {
			en.write("diana	hello. how are you?" +"");
			System.out.println(en.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


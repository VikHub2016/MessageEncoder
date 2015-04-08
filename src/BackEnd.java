import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BackEnd 
{
	
	
	
	public List<String> getMessages(String username)
	{
		
		List<String> list = new ArrayList<String>();
		Encoder x = new Encoder("file.txt");
		List<String> userMessages = new ArrayList<String>();
		userMessages = x.read();
		for(int i = 0; i < userMessages.size(); i = i + 2)
		{
			if(userMessages.get(i).equals(username))
			{
				list.add(userMessages.get(i+1));
			}
		}
		
		if(!(list==null))
		{
			return list;
		}
		return null;
	
	}
	
	public void addMessage(String username, String msg)
	{
		
		Encoder x = new Encoder("file.txt");
		String message = (username + "\t" + msg);
		try {
			x.write(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<String> getUsers()
	{
		List<String> list = new ArrayList<String>();
		Encoder x = new Encoder("file.txt");
		List<String> userMessages = new ArrayList<String>();
		userMessages = x.read();
		for(int i = 0; i < userMessages.size(); i = i + 2)
		{
			list.add(userMessages.get(i));
		}
		
		if(!(list==null))
		{
			return list;
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

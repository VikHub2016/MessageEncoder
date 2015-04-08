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
				list.add(userMessages.get(i));
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
		String encoded;
		Encoder x = new Encoder("file.txt");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

import java.util.ArrayList;
import java.util.List;


public class BackEnd 
{
	
	
	
	public List<String> getMessages(String username)
	{
		
		List<String> list = new ArrayList<String>();
		Encoder x = new Encoder(username + ".txt");
		List<String> userMessages = new ArrayList<String>();
		userMessages = x.read();
		for(int i = 0; i < userMessages.size(); i++)
		{
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

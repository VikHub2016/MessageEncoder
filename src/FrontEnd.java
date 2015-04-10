import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.control.ComboBox;

import javax.swing.*;
public class FrontEnd {

	
	public FrontEnd() throws FileNotFoundException
	{
		BackEnd b = new BackEnd();
		ArrayList<String> usernames = new ArrayList<String>(b.getUsers());
		
		
		JFrame frame = new JFrame("Message Encoder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500,500));
		frame.setLocation(500,200);
		Box main = Box.createVerticalBox();
		Box titleBox = Box.createHorizontalBox();	
		Box userBox = Box.createHorizontalBox();	
		Box usersBox = Box.createHorizontalBox();	
		Box msgBox = Box.createHorizontalBox();	
		Box getMsgBox = Box.createHorizontalBox();	
		Box msgBox2 = Box.createHorizontalBox();	

		frame.add(main);
		main.add(titleBox);
		main.add(userBox);
		main.add(usersBox);
		main.add(msgBox);
		main.add(getMsgBox);
		main.add(msgBox2);

		
		JLabel a = new JLabel("Message Encoder");

		JLabel user = new JLabel("Input Name:");
		JTextPane username = new JTextPane();
		JButton done = new JButton("Done");
		
		JLabel users = new JLabel("Which username?");
		JComboBox<String> list = new JComboBox(usernames.toArray());
		
		JLabel msg = new JLabel("Enter Message:");
		JTextPane message = new JTextPane();
		message.setMinimumSize(new Dimension(100,100));
		message.setMaximumSize(new Dimension(400,200));

		JLabel openMsg = new JLabel("Open Messages For:");
		
		JComboBox<String> userList = new JComboBox(usernames.toArray());

		JTextPane message2 = new JTextPane();
		message2.setEditable(false);
		
		list.setMinimumSize(new Dimension(100,25));

		
		list.setMaximumSize(new Dimension(100,25));
		username.setMaximumSize(new Dimension(100,25));
		titleBox.add(Box.createVerticalStrut(150));

		titleBox.add(a);
		titleBox.add(Box.createVerticalStrut(150));

		userBox.add(Box.createHorizontalStrut(50));

		userBox.add(user);
		userBox.add(Box.createHorizontalStrut(50));

		userBox.add(username);
		
		
		usersBox.add(users);
		userBox.add(Box.createHorizontalStrut(50));
		usersBox.add(list);
		
		msgBox.add(msg);
		msgBox.add(message);
		msgBox.add(Box.createHorizontalStrut(50));
		msgBox.add(done);
		
		getMsgBox.add(openMsg);
		getMsgBox.add(userList);
		
		msgBox2.add(message2);
		
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String in = username.getText();
				BackEnd a = new BackEnd();
				a.addMessage(in, message.getText());
			}
			});
		
		
		frame.pack();
		frame.setVisible(true);
	
	}
public static void main(String[] args)
{
	SwingUtilities.invokeLater(new Runnable() {
	public void run(){
		try {
			new FrontEnd();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}});
}
}

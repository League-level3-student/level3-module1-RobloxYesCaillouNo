package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{

	public static void main(String[] args) {
	_02_LogSearch method = new _02_LogSearch();
	method.Gui();
}

HashMap<Integer, String> logSearch = new HashMap<Integer, String>();
	
JButton button = new JButton("Add entry");
JButton button0 = new JButton("Search By ID");
JButton button1 = new JButton("View list");
JButton button2 = new JButton("Remove Entry");
 public void Gui() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setVisible(true);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(button);
		panel.add(button0);
		panel.add(button1);
		panel.add(button2);
		button.addActionListener(this);
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.pack();
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource() == button) {
		String IDtext = JOptionPane.showInputDialog("Enter an ID number");
		String Name = JOptionPane.showInputDialog("Enter a name"); 
		int ID = Integer.parseInt(IDtext);
		logSearch.put(ID, Name);
		
	} else if (e.getSource() == button0) {
		String IDNum = JOptionPane.showInputDialog("Enter an ID number");
		int ID1 = Integer.parseInt(IDNum);
		
		if (logSearch.containsKey(ID1)) {
			JOptionPane.showMessageDialog(null, logSearch.get(ID1) );
		} 
		else {
			JOptionPane.showMessageDialog(null, "That entry does not exist :(");
		}
	}
	else if (e.getSource() == button1) {
		
	Object[] keyArray = logSearch.keySet().toArray();
	String list = "";
	
	for (Object key : keyArray) {
	
		String line = "ID: " + key + " " + "Name: " + logSearch.get(key);
		list += line + "\n"; 
	}
			JOptionPane.showMessageDialog(null, list);
		
		
	}
	else if (e.getSource() == button2) {
	String IDExist = JOptionPane.showInputDialog("Enter an ID");	
	int IDExists = Integer.parseInt(IDExist);
	
	if (logSearch.containsKey(IDExists)) {
	logSearch.remove(IDExists);	
	}
	else {
		JOptionPane.showMessageDialog(null, "The ID isn't on the list... :P");
	}
	
	}
	
}
 	
 
 
	/* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	

	
}

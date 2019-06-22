package _04_HangMan;

import java.util.Stack;

import javax.swing.JOptionPane;

public class HangMan{
	
	public static void main(String[] args) {
	Stack<Utilities> words = new Stack<Utilities>();
		
		
		String input = JOptionPane.showInputDialog("How many words would you like to guess up to 266??");
		int inputt = Integer.parseInt(input);
		
	Utilities.readRandomLineFromFile("dictionary.txt");
	if (words.contains(input)) {
		
	}
	
	}
	
}

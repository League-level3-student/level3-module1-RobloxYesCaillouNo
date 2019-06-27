package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	static String word;
	static String line = "";
	static int lives = 10;

	static JLabel label = new JLabel();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	Stack<String> words = new Stack<String>();

	public static void main(String[] args) {
		HangMan hangman = new HangMan();
		hangman.setup();
		hangman.accesories();

	}

	public void accesories() {
		
		String input = JOptionPane.showInputDialog("How many words would you like to guess up to 266??");
		int inputt = Integer.parseInt(input);
		lives = 10;
		
		
		for (int i = 0; i < inputt; i++) {
			String dictionary = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(dictionary)) {
				words.push(dictionary);
			}

		}
		

		word = words.pop();
			
			int length = word.length();
			System.out.println(word);
			line = "";
			for (int i = 0; i < length; i++) {
				line += "_";
			}
		
		label.setText(line + lives);
	}

	public void setup() {
		
		frame.setVisible(true);
		frame.setSize(500, 50);
		panel.add(label);
		frame.addKeyListener(this);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (word.contains(e.getKeyChar() + "")) {
			String guess = e.getKeyChar() + "";

			for (int i = 0; i < word.length(); i++) {
				if (word.substring(i, i + 1).equals(guess)) {
					line = line.substring(0, i) + guess + line.substring(i + 1);
				}
			}

		} else if (!word.contains(e.getKeyChar() + "")) {
			lives = lives-1;
		
		} 
			

		
		if (lives <= 0) {
		int yesno =	JOptionPane.showConfirmDialog(null, "You lose. Would you like to try again?","Game over! :P", JOptionPane.YES_NO_OPTION);
		
		if (yesno == 0) {
			accesories();
			
		}
		else if (yesno == 1) {
			System.exit(yesno);
		}
		}
		if (!line.contains("_")) {

			word = words.pop();
			
			int length = word.length();
			System.out.println(word);
			line = "";
			for (int i = 0; i < length; i++) {
				line += "_";
			}
		}
		label.setText(line + lives); 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

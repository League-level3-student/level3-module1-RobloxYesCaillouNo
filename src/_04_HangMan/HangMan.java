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
	static String line;
	static int lives = 10;

	static JLabel label = new JLabel();

	public static void main(String[] args) {
		HangMan hangman = new HangMan();
		hangman.accesories();

	}

	public void accesories() {
		Stack<String> words = new Stack<String>();

		String input = JOptionPane.showInputDialog("How many words would you like to guess up to 266??");
		int inputt = Integer.parseInt(input);

		for (int i = 0; i < inputt; i++) {
			String dictionary = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(dictionary)) {
				words.push(dictionary);
			}

		}
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setSize(500, 50);
		panel.add(label);
		frame.addKeyListener(this);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		word = words.pop();

		label.setText(line + lives);
		if (!words.contains("_")) {
			words.pop();
			int length = word.length();
			System.out.println(word);
			line = "";
			for (int i = 0; i < length; i++) {
				line += "_";
			}
		}
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

		} else {
			lives--;

		}
		label.setText(line + lives);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

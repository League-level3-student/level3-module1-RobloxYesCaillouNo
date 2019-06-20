package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	public static void main(String[] args) {
		new _02_TextUndoRedo();
		_02_TextUndoRedo method = new _02_TextUndoRedo();

		method.thing();
	}

	JLabel label = new JLabel();

	Stack<Character> saved = new Stack<Character>();

	public void thing() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setVisible(true);
		frame.setSize(500, 50);
		panel.add(label);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		String text = label.getText();
		char character = arg0.getKeyChar();
		label.setText(label.getText() + character);
		if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

			saved.push(text.charAt(text.length() - 1));
			label.setText(text.substring(0, text.length() - 1));
		}
		if (arg0.getKeyCode() == KeyEvent.VK_CONTROL && !saved.isEmpty()) {
			
			label.setText(text + saved.pop());
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

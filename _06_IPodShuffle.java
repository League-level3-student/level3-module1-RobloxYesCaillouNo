package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	ArrayList<String> songs = new ArrayList<String>();
	Song currentSong;
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		
		
		
	
		
		songs.add("https://www.youtube.com/watch?v=F1IhgZTe_n0.mp3");
		songs.add("https://www.youtube.com/watch?v=Axf-F8q_LSE.mp3");
		songs.add("https://www.youtube.com/watch?v=M42sz3y-Qj0.mp3");
		songs.add("https://www.youtube.com/watch?v=ePv2X_CCaGg.mp3");
		songs.add("https://www.youtube.com/watch?v=Akwm2UZJ34o.mp3");
		songs.add("https://www.youtube.com/watch?v=FJfBJ6Y2Qac.mp3");
		
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
		
		
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
		Song song = new Song("demo.mp3");
		song.play();
	}
	JButton button;
	Random random = new Random();
	public void button() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(50, 20);
		frame.add(panel);
		button = new JButton("Suprise Me!");
		frame.pack();
		button.addActionListener(this);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == button) {
		currentSong.stop();
		currentSong = 	songs.get(random.nextInt(6));
			
		
		
		}
	}
}
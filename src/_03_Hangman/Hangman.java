package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel liveCount= new JLabel();
	int lives = 50;
	String displayPop;
	String newDisplay;
	char[] newLetter;
	int complete = 0;
	StringBuilder sb;
	Stack<String> rounds = new Stack<String>();
	ArrayList<String> usedBefore = new ArrayList<String>();

	public static void main(String[] args) {
		Hangman hang = new Hangman();
		hang.setup();

	}

	void setup() {
		frame.add(panel);
		frame.pack();
		panel.add(label);
		panel.add(liveCount);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(this);
		String wordsInput = JOptionPane
				.showInputDialog("Enter a number of rounds you would like to play (from 1 to 266)");
		int numWords = Integer.parseInt(wordsInput);
		for (int i = 0; i < numWords; i++) {
			String random = Utilities.readRandomLineFromFile("dictionary.txt");
			rounds.push(random);
		}
		String display = rounds.pop();
		displayPop = display;
		sb = new StringBuilder(display.length());
		for (int i = 0; i < displayPop.length(); i++) {
			sb.append("_ ");
		}
		newDisplay = sb.toString();
		newLetter = newDisplay.toCharArray();
		label.setText(newDisplay);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		liveCount.setText(""+lives);
		int charPosition = 0;
		char pressed1 = e.getKeyChar();

		StringBuilder containsChar = new StringBuilder(displayPop.length());
		if (displayPop.contains("" + pressed1)) {

			for (int i = 0; i < displayPop.length(); i++) {
				if ((displayPop.charAt(i)) == (pressed1)) {
					charPosition = i;
					newLetter[charPosition * 2] = (pressed1);
					System.out.println("New Word: " + new String(newLetter) + " \nPosition " + i);
					label.setText(new String(newLetter));
					if (!label.getText().contains("_")) {

						displayPop = rounds.pop();
						sb = new StringBuilder(displayPop.length());
						for (int j = 0; j < displayPop.length(); j++) {
							sb.append("_ ");
						}
						newDisplay = sb.toString();
						newLetter = newDisplay.toCharArray();
						label.setText(newDisplay);
					}

				}

			}

		} else {
			lives--;
			if (lives==0) {
				System.out.println("Game Over!!!!!! Restarting...");
				lives=50;
				displayPop = rounds.pop();
				sb = new StringBuilder(displayPop.length());
				for (int j = 0; j < displayPop.length(); j++) {
					sb.append("_ ");
				}
				newDisplay = sb.toString();
				newLetter = newDisplay.toCharArray();
				label.setText(newDisplay);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
//Step 1: When the program starts, it will ask the user for a number (up to the total words in the file). Then the 
//program will read that many words from the "dictionary.txt" file and push them to a Stack. 
//Use the readRandomLineFromFile method in the Utilities class. The words should be selected randomly so 
//not every game is played with the same set of words. You can use the Stack's contains() method to make sure
//there are no duplicate words.

//Step 2: Pop the word off the top of the stack and use a JLabel to display a blank line for all the characters in the word. 
//Collect key inputs from the user. If the user guesses a letter, fill in the blank space. Otherwise, take off a life.

//Step 3: When a word has been solved, pop the next one off the stack and start a new round. It is up to you if you want to 
//reset the lives.

//Step 4: If they run out of lives, give them a game over message.

//Step 5: Don't end the program on game over. Ask the user if they would like to play again and run the game again with new 
//words if they choose yes.

package _00_IntroToStacks;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo {
	
JFrame frame= new JFrame();
JPanel panel=new JPanel();
JLabel label= new JLabel();
void setup() {
	frame.add(panel);
	panel.add(label);
}
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */


}

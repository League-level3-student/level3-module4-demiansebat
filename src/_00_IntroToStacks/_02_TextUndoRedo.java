package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	public static void main(String[] args) {
		_02_TextUndoRedo bruh= new _02_TextUndoRedo();
		bruh.setup();
	}
JFrame frame= new JFrame();
JPanel panel=new JPanel();
JLabel label= new JLabel();
String labelLength;
Stack<String> lastChar = new Stack<String>();

void setup() {
	frame.add(panel);
	panel.add(label);
	frame.addKeyListener(this);    
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.pack();/* 
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
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub

	if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
		labelLength=label.getText();
		int len=labelLength.length();
		String sub=labelLength.substring(0,len-1);
		String sub2=labelLength.substring(len-1,len);
		lastChar.add(sub2);
		label.setText(sub);
	}
	else {
		char pressed=e.getKeyChar();
		label.setText(label.getText()+pressed);
	}
	
	if (e.getKeyCode()==KeyEvent.VK_U) {
		if(lastChar.isEmpty()==false) {
		String lastPop=lastChar.pop();
		label.setText(label.getText()+lastPop);
	}}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}

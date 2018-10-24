package p3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Design the interface of a JPanel in which the
 * player interact with. Also controls which button
 * is clicked.
 * 
 * Date: 24/10-2018
 * @author Mattias Jönsson
 *
 */
public class SSPUserInput extends JPanel {
	private SSPController controller;
	private JButton btnRock = new JButton("Rock");
	private JButton btnScissors = new JButton("Scissors");
	private JButton btnPaper = new JButton("Paper");
	private JButton btnNewGame = new JButton("New Game");
	private JButton btnQuit = new JButton("Quit");
	private JPanel panelChoiceButtons = new JPanel();
	private String choise="";
	private String winner="";
	public SSPUserInput(SSPController controller) {
		this.controller = controller;

		/*
		 * Sets the JPanel to 300 pixels wide and 200 pixels high 
		 * Sets the layout of the to a grid with 3 rows and 1 column
		 */
		setPreferredSize(new Dimension(300,200));
		setLayout(new GridLayout(3,1));
		
		setButtonSizes();				
		gameButtonSettings();
		
		add(panelChoiceButtons);
		add(btnNewGame);
		add(btnQuit);
		
		isClicked();
	}
	/*
	 * Sets the sizes of each button
	 */
	private void setButtonSizes() {
		btnRock.setPreferredSize(new Dimension(93,60));
		btnScissors.setPreferredSize(new Dimension(93,60));
		btnPaper.setPreferredSize(new Dimension(93,60));
		btnNewGame.setPreferredSize(new Dimension(290,60));
		btnQuit.setPreferredSize(new Dimension(290,60));
	}
	/*
	 * Sets the settings for the game buttons
	 */
	private void gameButtonSettings() {
		panelChoiceButtons.setLayout(new GridLayout(1,3));
		panelChoiceButtons.add(btnRock);
		panelChoiceButtons.add(btnScissors);
		panelChoiceButtons.add(btnPaper);
	}
	/*
	 * For when a button is clicked	
	 */
	private void isClicked() {
		isClicked clicked = new isClicked();
		btnRock.addActionListener( clicked );
		btnScissors.addActionListener( clicked );
		btnPaper.addActionListener( clicked );
		btnNewGame.addActionListener( clicked );
		btnQuit.addActionListener( clicked );
	}
	/*
	 * Controls the events of the button in which the player chooses to press
	 */
	private void gameButtonEvent() {
		winner = controller.winnerOfRound(choise);
		controller.showChoise(choise);
		controller.pointCounter(winner);
		controller.winnerOfGame();			
		controller.setPoints();
	}
	private class isClicked implements ActionListener {
		public void actionPerformed(ActionEvent e) {				
			if( e.getSource() == btnRock ) {
				choise="Rock";
				gameButtonEvent();
			}
			if( e.getSource() == btnScissors ) {
				choise="Scissors";	
				gameButtonEvent();
			}
			if( e.getSource() == btnPaper ) {
				choise="Paper";	
				gameButtonEvent();
			}
			if( e.getSource() == btnNewGame ) {
				controller.newGame();
			}
			if( e.getSource() == btnQuit ) {				
				controller.quit();
			}			
		}
	}	
}

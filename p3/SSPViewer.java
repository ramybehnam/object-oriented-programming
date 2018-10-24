package p3;

import java.awt.*;
import javax.swing.*;

/**
 * Design the interface of a JPanel in which the
 * player sees the scores of both the player and the
 * computer. Also shows what the player and the
 * computer has chosen.  
 * 
 * Date: 24/10-2018
 * @author Mattias Jönsson
 *
 */
public class SSPViewer extends JPanel{
	private JLabel lblInfo = new JLabel("",JLabel.CENTER);
	private JLabel lblPlayerName = new JLabel("",JLabel.CENTER);
	private JLabel lblComputerName = new JLabel("",JLabel.CENTER);
	private JLabel lblPlayerPoints = new JLabel("",JLabel.CENTER);
	private JLabel lblComputerPoints = new JLabel("",JLabel.CENTER);
	private JLabel lblPlayerChoice = new JLabel("",JLabel.CENTER);
	private JLabel lblComputerChoice = new JLabel("",JLabel.CENTER);
	
	public SSPViewer() {
		setPreferredSize(new Dimension(200,200));	

		labelSetSizes();
		
		lblInfo.setText("First to 3 wins!");
		lblPlayerName.setText("Player");
		lblComputerName.setText("Computer");
	
		
		setFontSize(lblInfo, 20f);
		setFontSize(lblPlayerName, 20f);
		setFontSize(lblComputerName, 20f);
		setFontSize(lblPlayerPoints, 20f);
		setFontSize(lblComputerPoints, 20f);
		setFontSize(lblPlayerChoice, 20f);
		setFontSize(lblComputerChoice, 20f);
		
		add(lblInfo);
		add(lblPlayerName);
		add(lblComputerName);
		add(lblPlayerPoints);
		add(lblComputerPoints);
		add(lblPlayerChoice);
		add(lblComputerChoice);
	}
	public void labelSetSizes() {
		lblInfo.setPreferredSize(new Dimension(190,40));
		lblPlayerName.setPreferredSize(new Dimension(90,40));
		lblComputerName.setPreferredSize(new Dimension(90,40));
		lblPlayerPoints.setPreferredSize(new Dimension(90,40));
		lblComputerPoints.setPreferredSize(new Dimension(90,40));
		lblPlayerChoice.setPreferredSize(new Dimension(90,40));
		lblComputerChoice.setPreferredSize(new Dimension(90,40));
	}
	/*
	 * Changes the label of the players and the computers score
	 * 
	 * @param playerPoints		the points the player has
	 * @param computerPoints	the points the computer has
	 */
	public void setPoints(int playerPoints, int computerPoints) {
		lblPlayerPoints.setText(Integer.toString(playerPoints));
		lblComputerPoints.setText(Integer.toString(computerPoints));
	}
	/*
	 * Sets the font size
	 * 
	 * @param label		the label which font will be changed
	 * @param size		the fonts size the label will be change to
	 */
	private void setFontSize(JLabel label, float size) {
		label.setFont(getFont().deriveFont(size));
	}
	/*
	 * Shows the winner of the game
	 * 
	 * @param winner	the "name" of the winner of the game  
	 */
	public void showWinner(String winner) {		
		lblInfo.setText(winner+" wins this game!");
		setFontSize(lblInfo,15f);
	}
	/*
	 * Shows the player's and the computer's choice
	 * 
	 * @param pChoice	the choice of the player
	 * @param cChoice	the choice of the computer
	 */
	public void showChoise(String pChoice, String cChoice) {
		lblPlayerChoice.setText(pChoice);
		lblComputerChoice.setText(cChoice);
	}
	/*
	 * Empties the points and the choices for both
	 * the player and computer
	 */
	public void empty() {
		lblPlayerPoints.setText("0");
		lblComputerPoints.setText("0");
		lblPlayerChoice.setText("");
		lblComputerChoice.setText("");
	}
}

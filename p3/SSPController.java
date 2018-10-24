package p3;

import java.util.Random;

/**
 * Controls what is happening in the game
 * 
 * Date: 24/10-2018
 * @author Mattias Jönsson
 *
 */
public class SSPController {
	private SSPViewer viewer; 
	private SSPPlayer computerPlayer;
	private int playerPoints = 0;
	private int computerPoints = 0;
	private String computerChoice = "";

	public SSPController(SSPPlayer computerPlayer, SSPViewer viewer) {
		this.viewer = viewer;
		this.computerPlayer = computerPlayer;			
		setPoints();
	}
	/*
	 * Check if there is a winner of the round
	 * 
	 * @return winner	the "name" of the winner of the round
	 */
	public String winnerOfRound(String pChoise) {
		String winner = "";
		if(playerPoints<3 && computerPoints<3 ) {			
			computerChoice = computerPlayer.computerChoise();
			if(pChoise=="Rock"&&computerChoice=="Scissors"){ winner = "Player";}
			else if(pChoise=="Rock"&&computerChoice=="Paper"){ winner = "Computer";}
			else if(pChoise=="Scissors"&&computerChoice=="Rock"){ winner = "Computer";}
			else if(pChoise=="Scissors"&&computerChoice=="Paper"){ winner = "Player";}
			else if(pChoise=="Paper"&&computerChoice=="Scissors"){ winner = "Computer";}
			else if(pChoise=="Paper"&&computerChoice=="Rock"){ winner = "Player";}							
		}
		return winner;
	}
	/*
	 * Increases the points of the winner of the round with 1
	 */
	public void pointCounter(String winner) {
		if(winner=="Player") playerPoints++;
		else if(winner=="Computer") computerPoints++;		
	}
	/*
	 * Checks whether or not there is a winner of the game
	 */
	public void winnerOfGame() {		
		if(is3points(playerPoints))viewer.showWinner("Player");
		if(is3points(computerPoints))viewer.showWinner("Computer");
		
	}
	/*
	 * Sets the points in "SSPViewer" to what point the player and the computer has
	 */
	public void setPoints(){
		if(playerPoints<=3 && computerPoints<=3 ) this.viewer.setPoints(playerPoints, computerPoints);
	}
	/*
	 * Shows the choice of the player in "SSPViewer"
	 */
	public void showChoise(String pChoise) {		
		if(playerPoints<3 && computerPoints<3 ) this.viewer.showChoise(pChoise, computerChoice);
	}
	/*
	 * Quits the game
	 */
	public void quit() {
		System.exit(0);
	}	
	/*
	 * Starts a new game
	 */
	public void newGame() {
		this.computerPoints = 0;
		this.playerPoints = 0;
		this.viewer.empty();
	}
	/*
	 * Checks if the point is 3
	 * 
	 * @param points	the points in which the method checks
	 */
	public boolean is3points(int points) {
		if(points==3) return true;
		else return false;		
	}
}

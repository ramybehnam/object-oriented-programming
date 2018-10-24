package p3;

import java.util.Random;

public class SSPPlayer {	
	public String computerChoise() {
		Random rnd = new Random();
		int rand = rnd.nextInt(3)+1;
		String str = "";
		switch(rand) {
		case 1: str = "Rock"; break;
		case 2: str = "Scissors"; break;
		case 3: str = "Paper"; break;
		}
		return str;
	}
}

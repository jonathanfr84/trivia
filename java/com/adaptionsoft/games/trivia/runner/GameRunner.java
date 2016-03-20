
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		launchAGame();
		
	}

	public static void launchAGame() {
		Game aGame = new Game();
		boolean playerContinues;
		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");
		
		Random rand = new Random();
	
		do {
			
			playerContinues = aGame.roll(rand.nextInt(5) + 1);
			if (playerContinues == true) {
				if (rand.nextInt(9) == 7) {
					notAWinner = aGame.wrongAnswer();
				} else {
					notAWinner = aGame.wasCorrectlyAnswered();
				}
			}
			
			
			
		} while (notAWinner);
		
	}
	
}

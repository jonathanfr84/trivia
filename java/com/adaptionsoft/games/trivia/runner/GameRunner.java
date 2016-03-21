
package com.adaptionsoft.games.trivia.runner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		List<String> players = new ArrayList<String>();
		players.add("Chet");
		players.add("Pat");
		players.add("Sue");
		launchAGame(players);
		
	}

	public static void launchAGame(List<String> players) {
		Game aGame = new Game();
		boolean playerContinues;

		for (String player : players) {
			aGame.add(player);
		}
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

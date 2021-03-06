package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList<String> players = new ArrayList<String>();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    int timesSixWasGot = 0;
    int[] highscores= new int[6];

    LinkedList<String> popQuestions = new LinkedList<String>();
    LinkedList<String> scienceQuestions = new LinkedList<String>();
    LinkedList<String> sportsQuestions = new LinkedList<String>();
    LinkedList<String> rockQuestions = new LinkedList<String>();
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast("Pop Question " + i);
			scienceQuestions.addLast(("Science Question " + i));
			sportsQuestions.addLast(("Sports Question " + i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }

	public String createRockQuestion(int index){
		return "Rock Question " + index;
	}

	public boolean add(String playerName) {
		
		
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}
	
	public boolean removePlayer(Object object) {
	 	  players.remove(object);
	 	  return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public boolean roll(int roll) {
		System.out.println(currentPlayer() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (roll == 6) {
			return checkIfPlayerGotThirdSix(roll);
		} else {
			if (inPenaltyBox[currentPlayer]) {
				playerIsInPenaltyBox(roll);
			} else {
				movePlayer(roll);
				askQuestion();
			}
		}
		
		return true;
		
	}

	private void movePlayer(int roll) {
		places[currentPlayer] = places[currentPlayer] + roll;
		if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
		
		System.out.println(currentPlayer() 
				+ "'s new location is " 
				+ places[currentPlayer]);
		System.out.println("The category is " + currentCategory());
	}

	private void playerIsInPenaltyBox(int roll) {
		if (roll % 2 != 0) {
			isGettingOutOfPenaltyBox = true;
			
			System.out.println(currentPlayer() + " is getting out of the penalty box");
			movePlayer(roll);
		} else {
			System.out.println(currentPlayer() + " is not getting out of the penalty box");
			isGettingOutOfPenaltyBox = false;
			}
	}

	private Object currentPlayer() {
		return players.get(currentPlayer);
	}

	private boolean checkIfPlayerGotThirdSix(int roll) {
		timesSixWasGot++;
		if (timesSixWasGot == 3) {
			System.out.println(currentPlayer() + " got the third " + roll + " so he/she is going to be eliminated");
			removePlayer(currentPlayer());
			return false;
		} else {
			return true;
		}
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}


	// randomly return a category
	private String currentCategory() {
		
		int categoryType = places[currentPlayer] % 4;
		
		switch (categoryType) {
		case 0:
			return "Pop";
		case 1:
			return "Science";
		case 2:
			return "Sports";
		default:
			break;
		}
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
			if (isGettingOutOfPenaltyBox) {
				increasePlayerScore();
				boolean winner = didPlayerWin();
				nextPlayer();
				return winner;
			} else {
				nextPlayer();
				return true;
			}
		} else {
			increasePlayerScore();
			boolean winner = didPlayerWin();
			nextPlayer();
			return winner;
		}
	}

	private void increasePlayerScore() {
		textIfAnswerIsCorrect();
		purses[currentPlayer]++;
		System.out.println(currentPlayer() 
				+ " now has "
				+ purses[currentPlayer]
				+ " Gold Coins.");
	}

	
	public boolean wrongAnswer(){
		textIfAnswerIsNotCorrect();
		System.out.println(currentPlayer()+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		nextPlayer();
		return true;
	}

	private void nextPlayer() {
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
	}

	private void textIfAnswerIsCorrect() {
		System.out.println("Answer was correct!!!!");
	}
	
	private void textIfAnswerIsNotCorrect() {
		System.out.println("Question was incorrectly answered");
	}

	/**
	 * Tells if the last player won.
	 */
	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}

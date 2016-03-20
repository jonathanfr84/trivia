package com.adaptionsoft.games.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.adaptionsoft.games.trivia.runner.GameRunner;

public class GameTests {
	
	private static final String GAME_EXPECTED_WITH_FIVE = "Chet was added\r\n" + 
			"They are player number 1\r\n" + 
			"Pat was added\r\n" + 
			"They are player number 2\r\n" + 
			"Sue was added\r\n" + 
			"They are player number 3\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 6\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Chet now has 1 Gold Coins.\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 1\r\n" + 
			"Pat's new location is 1\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 0\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Pat now has 1 Gold Coins.\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 2\r\n" + 
			"Sue's new location is 2\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 0\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Sue now has 1 Gold Coins.\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 3\r\n" + 
			"Chet's new location is 3\r\n" + 
			"The category is Rock\r\n" + 
			"Rock Question 0\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Chet now has 2 Gold Coins.\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 4\r\n" + 
			"Pat's new location is 5\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 1\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Pat now has 2 Gold Coins.\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 5\r\n" + 
			"Sue's new location is 7\r\n" + 
			"The category is Rock\r\n" + 
			"Rock Question 1\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Sue now has 2 Gold Coins.\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 6\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Chet now has 3 Gold Coins.\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 1\r\n" + 
			"Pat's new location is 6\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 1\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Pat now has 3 Gold Coins.\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 2\r\n" + 
			"Sue's new location is 9\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 2\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Sue now has 3 Gold Coins.\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 3\r\n" + 
			"Chet's new location is 6\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 2\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Chet now has 4 Gold Coins.\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 4\r\n" + 
			"Pat's new location is 10\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 3\r\n" + 
			"Question was incorrectly answered\r\n" + 
			"Pat was sent to the penalty box\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 5\r\n" + 
			"Sue's new location is 2\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 4\r\n" + 
			"Question was incorrectly answered\r\n" + 
			"Sue was sent to the penalty box\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 6\r\n" + 
			"Chet got the third 6 so he/she is going to be eliminated\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 1\r\n" + 
			"Pat's new location is 7\r\n" + 
			"The category is Rock\r\n" + 
			"Rock Question 2\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Pat now has 5 Gold Coins.\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 2\r\n" + 
			"Sue is not getting out of the penalty box\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 3\r\n" + 
			"Pat's new location is 10\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 5\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Pat now has 6 Gold Coins.\r\n";

	private static final String GAME_EXPECTED_WITH_ONE = "Chet was added\r\n" + 
			"They are player number 1\r\n" + 
			"Pat was added\r\n" + 
			"They are player number 2\r\n" + 
			"Sue was added\r\n" + 
			"They are player number 3\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 2\r\n" + 
			"Chet's new location is 2\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 0\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Chet now has 1 Gold Coins.\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 3\r\n" + 
			"Pat's new location is 3\r\n" + 
			"The category is Rock\r\n" + 
			"Rock Question 0\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Pat now has 1 Gold Coins.\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 4\r\n" + 
			"Sue's new location is 4\r\n" + 
			"The category is Pop\r\n" + 
			"Pop Question 0\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Sue now has 1 Gold Coins.\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 5\r\n" + 
			"Chet's new location is 7\r\n" + 
			"The category is Rock\r\n" + 
			"Rock Question 1\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Chet now has 2 Gold Coins.\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 6\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Pat now has 2 Gold Coins.\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 1\r\n" + 
			"Sue's new location is 5\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 0\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Sue now has 2 Gold Coins.\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 2\r\n" + 
			"Chet's new location is 9\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 1\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Chet now has 3 Gold Coins.\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 3\r\n" + 
			"Pat's new location is 6\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 1\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Pat now has 3 Gold Coins.\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 4\r\n" + 
			"Sue's new location is 9\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 2\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Sue now has 3 Gold Coins.\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 5\r\n" + 
			"Chet's new location is 2\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 2\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Chet now has 4 Gold Coins.\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 6\r\n" + 
			"Question was incorrectly answered\r\n" + 
			"Pat was sent to the penalty box\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 1\r\n" + 
			"Sue's new location is 10\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 3\r\n" + 
			"Question was incorrectly answered\r\n" + 
			"Sue was sent to the penalty box\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 2\r\n" + 
			"Chet's new location is 4\r\n" + 
			"The category is Pop\r\n" + 
			"Pop Question 1\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Chet now has 5 Gold Coins.\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 3\r\n" + 
			"Pat is getting out of the penalty box\r\n" + 
			"Pat's new location is 9\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 3\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Pat now has 4 Gold Coins.\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 4\r\n" + 
			"Sue is not getting out of the penalty box\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 5\r\n" + 
			"Chet's new location is 9\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 4\r\n" + 
			"Question was incorrectly answered\r\n" + 
			"Chet was sent to the penalty box\r\n" + 
			"Pat is the current player\r\n" + 
			"They have rolled a 6\r\n" + 
			"Pat got the third 6 so he/she is going to be eliminated\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 1\r\n" + 
			"Sue is getting out of the penalty box\r\n" + 
			"Sue's new location is 10\r\n" + 
			"The category is Sports\r\n" + 
			"Sports Question 4\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Sue now has 5 Gold Coins.\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 2\r\n" + 
			"Chet is not getting out of the penalty box\r\n" + 
			"Sue is the current player\r\n" + 
			"They have rolled a 3\r\n" + 
			"Sue is getting out of the penalty box\r\n" + 
			"Sue's new location is 1\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 5\r\n" + 
			"Answer was correct!!!!\r\n" + 
			"Sue now has 6 Gold Coins.\r\n";

	private static final String ROLL_WITH_THREE = "Chet was added\r\n" + 
			"They are player number 1\r\n" + 
			"Pat was added\r\n" + 
			"They are player number 2\r\n" + 
			"Sue was added\r\n" + 
			"They are player number 3\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 3\r\n" + 
			"Chet's new location is 3\r\n" + 
			"The category is Rock\r\n" + 
			"Rock Question 0\r\n";

	private static final String ROLL_WITH_ONE = "Chet was added\r\n" + 
			"They are player number 1\r\n" + 
			"Pat was added\r\n" + 
			"They are player number 2\r\n" + 
			"Sue was added\r\n" + 
			"They are player number 3\r\n" + 
			"Chet is the current player\r\n" + 
			"They have rolled a 1\r\n" + 
			"Chet's new location is 1\r\n" + 
			"The category is Science\r\n" + 
			"Science Question 0\r\n";
	
	private Game game;
	
	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void game_is_created_correctly() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		assertEquals("", stream.toString());
	}
	
	@Test
	public void one_player_can_be_added() {
		game.add("Jonathan");
		assertEquals(1, game.howManyPlayers());
	}
	
	@Test
	public void two_players_can_be_added() {
		game.add("Jonathan");
		game.add("Paco");
		assertEquals(2, game.howManyPlayers());
	}
	
	@Test
	public void one_player_can_be_removed() {
		game.add("Jonathan");
		game.removePlayer("Jonathan");
		assertEquals(0, game.howManyPlayers());
	}
	
	//Se trata de una limitación del código. Debería aceptar más de 7
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void when_seven_players_are_added_get_an_excepction() {
		game.add("Jonathan");
		game.add("Paco");
		game.add("Antonio");
		game.add("Pepe");
		game.add("Juan");
		game.add("Manuel");
		game.add("Jordi");
		assertEquals(7, game.howManyPlayers());
	}
	
	@Test
	public void when_player_is_added_his_name_is_written() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		game.add("Jonathan");
		assertEquals("Jonathan was added\r\n" + 
				"They are player number 1\r\n", stream.toString());
		System.setOut(System.out);
	}
	
	@Test
	public void one_roll_with_result_one() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		Game game = new Game();
		game.add("Chet");
		game.add("Pat");
		game.add("Sue");
		game.roll(1);
		assertEquals(ROLL_WITH_ONE, stream.toString());

	}
	
	@Test
	public void one_roll_with_result_three() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		Game game = new Game();
		game.add("Chet");
		game.add("Pat");
		game.add("Sue");
		game.roll(3);
		assertEquals(ROLL_WITH_THREE, stream.toString());

	}
	
    @Test
    public void one_game_rolling_one(){
        assertEquals(GAME_EXPECTED_WITH_ONE, launchAGame(1));
    }

    @Test
    public void one_game_rolling_three(){
        assertEquals(GAME_EXPECTED_WITH_FIVE, launchAGame(5));
    }
   
    public String launchAGame(int roll){
		boolean playerContinues;
        Random random = new Random(1);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream stringWriter = new PrintStream(stream);
        System.setOut(stringWriter);
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        boolean notAWinner = false;
        do {

        	playerContinues = aGame.roll((roll++)%6+1);
        	if (playerContinues == true) {
	            if (random.nextInt(9) == 7) {
	                notAWinner = aGame.wrongAnswer();
	            } else {
	                notAWinner = aGame.wasCorrectlyAnswered();
	            }
        	}

        } while (notAWinner);

        return stream.toString();
    }
	
}

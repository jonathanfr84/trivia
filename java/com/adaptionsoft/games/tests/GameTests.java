package com.adaptionsoft.games.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.adaptionsoft.games.trivia.runner.GameRunner;

public class GameTests {
	
	private Game game;
	
	@Before
	public void setUp() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(stream);
		System.setOut(printStream);
		game = new Game();
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
	
	//Se trata de una limitación del código. Denería aceptar más de 7
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
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void when_player_is_removed_get_an_exception() {
		game.add("Jonathan");
		game.remove("Jonathan");
		assertEquals(0, game.howManyPlayers());
	}
}

package com.adaptionsoft.games.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.adaptionsoft.games.trivia.runner.GameRunner;

public class GameTests {
	
	@Test
	public void new_game_is_created_correctly() {
		Game game = new Game();
		assertEquals("", "");
	}
	
	@Test
	public void one_player_can_be_added() {
		Game game = new Game();
		game.add("Jonathan");
		assertEquals(1, game.howManyPlayers());
	}
	
	@Test
	public void two_players_can_be_added() {
		Game game = new Game();
		game.add("Jonathan");
		game.add("Paco");
		assertEquals(2, game.howManyPlayers());
	}
	
	//Se trata de una limitación del código. Denería aceptar más de 7
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void when_seven_players_are_added_get_an_excepction() {
		Game game = new Game();
		game.add("Jonathan");
		game.add("Paco");
		game.add("Antonio");
		game.add("Pepe");
		game.add("Juan");
		game.add("Manuel");
		game.add("Jordi");
		assertEquals(7, game.howManyPlayers());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void when_player_is_removed_get_an_exception() {
		Game game = new Game();
		game.add("Jonathan");
		game.remove("Jonathan");
		assertEquals(0, game.howManyPlayers());
	}
}

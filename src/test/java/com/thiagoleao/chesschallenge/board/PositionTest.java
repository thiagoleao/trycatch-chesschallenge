package com.thiagoleao.chesschallenge.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PositionTest {
	
	private Position position;

	@Test
	public void testDefaultConstructor() {
		position = new Position();
		assertEquals(-1, position.getColumn());
		assertEquals(-1, position.getRow());
	}
	
	@Test
	public void testConstructorWithParameters() {
		position = new Position(2, 2);
		assertEquals(2, position.getColumn());
		assertEquals(2, position.getRow());
	}


}

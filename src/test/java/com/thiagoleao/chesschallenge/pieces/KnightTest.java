package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnightTest {

	private Knight knight = new Knight();
	
	@Test
	public void testPieceSymbol_isTheCorrectSymbol() {
		assertEquals(new String("N"), knight.getPieceSymbol());
	}
	
	@Test
	public void testKnight_IsAttackingPosition_moveAsAKnight() {
		knight.getPosition().setColumn(0);
		knight.getPosition().setRow(2);
		assertTrue(knight.isAttackPosition(2, 3));
	}

	@Test
	public void testKnight_IsAttackingPosition_onNextPosition() {
		assertFalse(knight.isAttackPosition(0, 0));
		
	}

}

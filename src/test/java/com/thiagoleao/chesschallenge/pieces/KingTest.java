package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class KingTest {

	private King king = new King();
	
	@Test
	public void testPieceSymbol_isTheCorrectSymbol() {
		assertEquals(new String("K"), king.getPieceSymbol());
	}
	
	@Test
	public void testKing_IsAttackingPosition_onDiagonalNextPosition() {
		assertTrue(king.isAttackPosition(0, 0));
	}
	
	@Test
	public void testKing_IsAttackingPosition_onSameRowNextPosition() {
		king.getPosition().setColumn(1);
		king.getPosition().setRow(2);
		assertTrue(king.isAttackPosition(2, 1));
	}

	@Test
	public void testBishop_IsAttackingPosition_onSecondNextPosition() {
		assertFalse(king.isAttackPosition(0, 2));
		
	}

}

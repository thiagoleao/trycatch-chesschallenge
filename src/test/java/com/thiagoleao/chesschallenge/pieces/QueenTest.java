package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueenTest {

	private Queen queen = new Queen();
	
	@Test
	public void testPieceSymbol_isTheCorrectSymbol() {
		assertEquals(new String("Q"), queen.getPieceSymbol());
	}
	
	@Test
	public void testQueen_IsAttackingPosition_onSameRow() {
		assertTrue(queen.isAttackPosition(0, 0));
	}

	@Test
	public void testQueen_IsAttackingPosition_sameMoveAsAKnight() {
		queen.getPosition().setColumn(0);
		queen.getPosition().setRow(2);
		assertFalse(queen.isAttackPosition(2, 3));
		
	}

}

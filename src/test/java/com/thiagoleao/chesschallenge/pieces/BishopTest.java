package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {

	private Bishop bishop = new Bishop();
	
	@Test
	public void testPieceSymbol_isTheCorrectSymbol() {
		assertEquals(new String("B"), bishop.getPieceSymbol());
	}
	
	@Test
	public void testBishop_IsAttackingPosition_onDiagonal() {
		assertTrue(bishop.isAttackPosition(0, 0));
	}

	@Test
	public void testBishop_IsAttackingPosition_onSameRow() {
		assertFalse(bishop.isAttackPosition(0, 1));
		
	}

}

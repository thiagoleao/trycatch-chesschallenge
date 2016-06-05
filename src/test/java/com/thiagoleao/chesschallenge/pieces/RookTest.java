package com.thiagoleao.chesschallenge.pieces;

import static org.junit.Assert.*;

import org.junit.Test;

public class RookTest {

	private Rook rook = new Rook();
	
	@Test
	public void testPieceSymbol_isTheCorrectSymbol() {
		assertEquals(new String("R"), rook.getPieceSymbol());		
	}

	@Test
	public void testRook_IsAttackingPosition_onSameRow() {
		assertTrue(rook.isAttackPosition(-1, -1));
	}

	@Test
	public void testRook_IsAttackingPosition_onDiagonal() {
		assertFalse(rook.isAttackPosition(0, 3));
	}

}

package com.thiagoleao.chesschallenge.board;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Piece;

public class ChessBoardConfigurationTest {

	private ChessBoardConfiguration configuration;
	
	@Before
	public void init() {
		configuration = new ChessBoardConfiguration(new ChessBoardSize(7, 7));
	}
	
	@Test
	public void testConstructor() {
		assertEquals(7, configuration.getChessBoardSize().getWidth());
		assertEquals(49, configuration.getChessBoardSize().getLength());
		assertEquals(0, configuration.getAttempt());
		assertEquals(null, configuration.getId());
	}
	
	@Test
	public void testAllocateAPieceAtValidPosition() {
		Piece piece = new King(); 
		int positionAllocated = configuration.allocateAPieceAtAValidPosition(piece, 0);
		assertEquals(0, positionAllocated);
	}
	
	@Test
	public void testRemovingAPieceFromAPosition() {
		Piece piece = new King();
		configuration.allocateAPieceAtAValidPosition(piece, 0);
		configuration.removePiece(piece);
	}

	@Test(expected = NoPieceWasFoundException.class)
	public void testRemovingPieceFromAPosition_positionWithNoPiece_throwingException() {
		Piece piece = new King();
		configuration.removePiece(piece);
	}
}

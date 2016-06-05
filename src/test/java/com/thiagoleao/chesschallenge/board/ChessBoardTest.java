package com.thiagoleao.chesschallenge.board;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.thiagoleao.chesschallenge.pieces.Bishop;
import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Knight;
import com.thiagoleao.chesschallenge.pieces.Queen;
import com.thiagoleao.chesschallenge.pieces.Rook;

public class ChessBoardTest {

	private ChessBoard chessBoard;
	
	@Before
	public void init() {
		chessBoard = new ChessBoard(new ChessBoardSize(7, 7));
	}
	
	@Test
	public void testConstructor() {
		assertEquals(7, chessBoard.getChessBoardSize().getHeight());
		assertEquals(7, chessBoard.getChessBoardSize().getWidth());
		assertNotNull(chessBoard.getPieceList());
	}
	
	@Test
	public void testAddingKingList() {
		chessBoard.addPieceList(Arrays.asList(new King(), new King(), new King()));
		assertEquals(3, chessBoard.getPieceList().size());
	}
	
	@Test
	public void testAddingQueenList() {
		chessBoard.addPieceList(Arrays.asList(new Queen(), new Queen()));
		assertEquals(2, chessBoard.getPieceList().size());
	}
	
	@Test
	public void testAddingBishopList() {
		chessBoard.addPieceList(Arrays.asList(new Bishop(), new Bishop(), new Bishop(), new Bishop(), new Bishop()));
		assertEquals(5, chessBoard.getPieceList().size());
	}
	
	@Test
	public void testAddingRookList() {
		chessBoard.addPieceList(Arrays.asList(new Rook()));
		assertEquals(1, chessBoard.getPieceList().size());
	}
	
	@Test
	public void testAddingKnightList() {
		chessBoard.addPieceList(Arrays.asList(new Knight(), new Knight(), new Knight(), new Knight()));
		assertEquals(4, chessBoard.getPieceList().size());
	}
	
	@Test
	public void testAddingAMultiplePieceList() {
		chessBoard.addPieceList(Arrays.asList(new Knight(), new King(), new Queen(), new Rook(), new Bishop()));
		assertEquals(5, chessBoard.getPieceList().size());
	}

}

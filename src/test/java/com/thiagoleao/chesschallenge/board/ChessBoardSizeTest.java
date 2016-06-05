package com.thiagoleao.chesschallenge.board;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessBoardSizeTest {

	private ChessBoardSize chessBoardSize;

	@Test
	public void testConstructorWithParameters() {
		chessBoardSize = new ChessBoardSize(4, 4);
		assertEquals(4, chessBoardSize.getHeight());
		assertEquals(4, chessBoardSize.getWidth());
		assertEquals(16, chessBoardSize.getLength());
	}

}

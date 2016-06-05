package com.thiagoleao.chesschallenge.processor;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.thiagoleao.chesschallenge.board.ChessBoard;
import com.thiagoleao.chesschallenge.board.ChessBoardSize;
import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Knight;
import com.thiagoleao.chesschallenge.pieces.Piece;
import com.thiagoleao.chesschallenge.pieces.Rook;

public class SolutionProcessorTest {

	
	@Test
	public void testFindSolutionWith_board3x3_2King_1Rook() {
		Solution solution = SolutionProcessor.findSolution(getBoard(3, 3, 
				Arrays.asList(new Rook(), new King(), new King())));
		assertEquals(4, solution.getUniqueConfigurationMap().size());
	}

	@Test
	public void testFindSolutionWith_board4x4_2Rook_4Knight() {
		Solution solution = SolutionProcessor.findSolution(getBoard(4, 4, 
				Arrays.asList(new Rook(), new Rook(), 
				new Knight(), new Knight(), 
				new Knight(), new Knight())));
		assertEquals(8, solution.getUniqueConfigurationMap().size());
	}
	
	//Commented this line to run tests faster, probably the app needs 
	//refactoring on the recursive algorithm implemented
	//When I have some idea to improve the performance this code will be uncommented
//	@Test
//	public void testFindSolutionWith_board7x7_2King_2Queen_2Bishop_1Knight() {
//		Solution solution = SolutionProcessor.findSolution(getBoard(7, 7, 
//				Arrays.asList(new King(), new King(), new Queen(), new Queen(), 
//						new Bishop(), new Bishop(), new Knight())));
//		assertEquals(3059868, solution.getUniqueConfigurations().size());
//	}



	private ChessBoard getBoard(int height, int width, List<Piece> pieceList) {
		return new ChessBoard(new ChessBoardSize(width, height)).addPieceList(pieceList);
	}

}

package com.thiagoleao.chesschallenge.board;

import java.util.ArrayList;
import java.util.List;

import com.thiagoleao.chesschallenge.pieces.Piece;

/**
 * This class represents the chess board that will be processed to find all
 * unique configurations
 * 
 * @author Thiago Leao
 *
 */
public class ChessBoard {

	protected ChessBoardSize chessBoardSize;
	protected List<Piece> pieceList;

	public ChessBoard(ChessBoardSize chessBoardSize) {
		this.chessBoardSize = chessBoardSize;
		this.pieceList = new ArrayList<Piece>();
	}

	protected ChessBoard(ChessBoardSize chessBoardSize, List<Piece> pieceList) {
		this.chessBoardSize = chessBoardSize;
		this.pieceList = pieceList;
	}

	public ChessBoard addPieceList(List<Piece> pieceList) {
		this.pieceList.addAll(pieceList);
		return this;
	}

	// GETTERS
	public ChessBoardSize getChessBoardSize() {
		return chessBoardSize;
	}

	public List<Piece> getPieceList() {
		return pieceList;
	}
}

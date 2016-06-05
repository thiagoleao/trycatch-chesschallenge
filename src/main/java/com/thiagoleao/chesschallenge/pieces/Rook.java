package com.thiagoleao.chesschallenge.pieces;

/**
 * This class represents the {@link Piece} {@link Rook} for the chess game
 * 
 * @author Thiago Leao
 *
 */
public class Rook extends AbstractPiece {

	private static final String SYMBOL = "R";

	public boolean isAttackPosition(int column, int row) {
		return getPosition().getRow() == row || getPosition().getColumn() == column;
	}

	public String getPieceSymbol() {
		return SYMBOL;
	}

}

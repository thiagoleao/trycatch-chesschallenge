package com.thiagoleao.chesschallenge.pieces;

/**
 * This class represents the {@link Piece} {@link Queen} for the chess game
 * 
 * @author Thiago Leao
 *
 */
public class Queen extends AbstractPiece {

	private static final String SYMBOL = "Q";

	public boolean isAttackPosition(int column, int row) {
		if (Math.abs(getPosition().getRow() - row) == Math.abs(getPosition().getColumn() - column)) {
			return true;
		}
		if (getPosition().getRow() == row || getPosition().getColumn() == column) {
			return true;
		}
		return false;
	}

	public String getPieceSymbol() {
		return SYMBOL;
	}
}

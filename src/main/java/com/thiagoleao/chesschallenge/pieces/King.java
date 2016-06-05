package com.thiagoleao.chesschallenge.pieces;

/**
 * This class represents the {@link Piece} {@link King} for the chess game
 * 
 * @author Thiago Leao
 *
 */
public class King extends AbstractPiece {

	private static final String SYMBOL = "K";

	public boolean isAttackPosition(int column, int row) {
		if (Math.abs(getPosition().getRow() - row) == 1 && Math.abs(getPosition().getColumn() - column) == 1) {
			return true;
		}
		if ((getPosition().getRow() == row && Math.abs(getPosition().getColumn() - column) == 1)
				|| (getPosition().getColumn() == column && Math.abs(getPosition().getRow() - row) == 1)) {
			return true;
		}
		return false;
	}

	public String getPieceSymbol() {
		return SYMBOL;
	}

}

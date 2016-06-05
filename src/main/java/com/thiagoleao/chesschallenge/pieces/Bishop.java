package com.thiagoleao.chesschallenge.pieces;

/**
 * This class represents the {@link Piece} {@link Bishop} for the chess game
 * 
 * @author Thiago Leao
 *
 */
public class Bishop extends AbstractPiece {

	private static final String SYMBOL = "B";

	public boolean isAttackPosition(int column, int row) {
		return Math.abs(getPosition().getColumn() - column) == Math.abs(getPosition().getRow() - row);
	}

	public String getPieceSymbol() {
		return SYMBOL;
	}

}

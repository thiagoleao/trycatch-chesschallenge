package com.thiagoleao.chesschallenge.pieces;

/**
 * This class represents the {@link Piece} {@link Knight} for the chess game
 * 
 * @author Thiago Leao
 *
 */
public class Knight extends AbstractPiece {

	private static final String SYMBOL = "N";

	public boolean isAttackPosition(int column, int row) {
		int _row = Math.abs(getPosition().getRow() - row);
		int _column = Math.abs(getPosition().getColumn() - column);
		return ((_row == 2 && _column == 1) || (_row == 1 && _column == 2));
	}

	public String getPieceSymbol() {
		return SYMBOL;
	}
}

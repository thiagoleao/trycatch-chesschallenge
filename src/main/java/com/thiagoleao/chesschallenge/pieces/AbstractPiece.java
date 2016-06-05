package com.thiagoleao.chesschallenge.pieces;

import com.thiagoleao.chesschallenge.board.Position;

/**
 * This class contains all functionalities of a chess {@link Piece}
 * 
 * @author Thiago Leao
 *
 */
public abstract class AbstractPiece implements Piece {

	private Position position;

	public AbstractPiece() {
		position = new Position();
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return getPieceSymbol();
	}

	@Override
	public boolean equals(Object piece) {
		if (piece == null) {
			return false;
		}
		return getPieceSymbol().equals(((Piece) piece).getPieceSymbol());
	}

	@Override
	public int hashCode() {
		return getPieceSymbol().charAt(0);
	}

}

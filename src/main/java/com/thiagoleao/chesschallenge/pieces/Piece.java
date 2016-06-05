package com.thiagoleao.chesschallenge.pieces;

import com.thiagoleao.chesschallenge.board.Position;

/**
 * This interface represents a chess {@link Piece} and it declare all shared
 * methods
 * 
 * @author Thiago Leao
 *
 */
public interface Piece {

	Position getPosition();

	boolean isAttackPosition(int column, int row);

	String getPieceSymbol();

}

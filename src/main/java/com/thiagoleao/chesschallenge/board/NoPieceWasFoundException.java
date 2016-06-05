package com.thiagoleao.chesschallenge.board;

/**
 * This class represents a specialized. It will be thrown when there is no piece
 * to remove from a set
 * 
 * @author Thiago Leao
 *
 */
public class NoPieceWasFoundException extends RuntimeException {

	private static final long serialVersionUID = -758946175344778239L;

	@Override
	public String getMessage() {
		return "No piece was found!";
	}

}

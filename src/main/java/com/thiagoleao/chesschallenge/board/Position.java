package com.thiagoleao.chesschallenge.board;

/**
 * This class represents a single position in a chess {@link ChessBoard}
 * 
 * @author Thiago Leao
 *
 */
public class Position {
	private int row = -1;
	private int column = -1;

	public Position() {
	}

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
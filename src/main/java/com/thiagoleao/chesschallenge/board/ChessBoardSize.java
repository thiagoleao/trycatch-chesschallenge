package com.thiagoleao.chesschallenge.board;

/**
 * This class represents the size of a {@link ChessBoard}
 * 
 * @author Thiago Leao
 *
 */
public class ChessBoardSize {
	private int width;
	private int height;
	private int length;

	public ChessBoardSize(int width, int height) {
		this.width = width;
		this.height = height;
		this.length = width * height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}
}
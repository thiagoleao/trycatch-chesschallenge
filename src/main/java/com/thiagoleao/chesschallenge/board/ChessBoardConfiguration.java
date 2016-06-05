package com.thiagoleao.chesschallenge.board;

import java.util.HashMap;
import java.util.UUID;

import com.thiagoleao.chesschallenge.pieces.Piece;

/**
 * This class keeps all information about the configuration of pieces in the
 * chess board.
 * 
 * @author Thiago Leao
 *
 */
public class ChessBoardConfiguration extends ChessBoard implements Cloneable {

	public static final int NULL = -1;
	private int attempt;
	private UUID id;
	private HashMap<Integer, Piece> piecePositionMap;

	public ChessBoardConfiguration(ChessBoardSize chessBoardSize) {
		super(chessBoardSize);
		this.attempt = 0;
		this.piecePositionMap = new HashMap<>(chessBoardSize.getLength());
	}

	@SuppressWarnings("unchecked")
	private ChessBoardConfiguration(ChessBoard chessBoard, int attempt, HashMap<Integer, Piece> piecesPosition) {
		super(chessBoard.getChessBoardSize(), chessBoard.getPieceList());
		this.attempt = attempt;
		this.piecePositionMap = (HashMap<Integer, Piece>) piecesPosition.clone();
	}

	// GETTERS AND SETTERS
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	public int getAttempt() {
		return attempt;
	}

	public UUID getId() {
		StringBuilder builder = new StringBuilder();

		if (id == null && piecePositionMap.size() > 0) {
			// Creates a string representation for
			// board configuration
			for (int i = 0; i < chessBoardSize.getLength(); i++) {
				Piece piece = piecePositionMap.get((Integer) i);
				String symbol = " ";
				if (piece != null) {
					symbol = piece.getPieceSymbol();
				}
				builder.append(symbol);
			}
			// creates an id based on a string with positions configuration
			this.id = UUID.nameUUIDFromBytes(builder.toString().getBytes());

		}
		return id;
	}

	public int allocateAPieceAtAValidPosition(Piece piece, int startPosition) {
		for (int position = startPosition; position < chessBoardSize.getLength(); position++) {
			if (piecePositionMap.get((Integer) position) == null) {
				int column = position % chessBoardSize.getWidth();
				int row = position / chessBoardSize.getWidth();
				if (isPositionValid(piece, column, row)) {
					allocateAPieceAtAPosition(piece, column, row);
					return position;
				}
			}
		}
		return NULL;
	}

	public void removePiece(Piece piece) {
		int position = piece.getPosition().getColumn() + chessBoardSize.getWidth() * piece.getPosition().getRow();
		if (piecePositionMap.remove((Integer) position) == null) {
			throw new NoPieceWasFoundException();
		}
	}

	private void allocateAPieceAtAPosition(Piece piece, int column, int row) {
		piece.getPosition().setColumn(column);
		piece.getPosition().setRow(row);
		piecePositionMap.put(row * chessBoardSize.getWidth() + column, piece);

	}

	private boolean isPositionValid(Piece _piece, int column, int row) {
		for (Piece piece : piecePositionMap.values()) {
			if (piece.isAttackPosition(column, row)) {
				return false;
			}
			_piece.getPosition().setColumn(column);
			_piece.getPosition().setRow(row);
			if (_piece.isAttackPosition(piece.getPosition().getColumn(), piece.getPosition().getRow())) {
				return false;
			}
		}
		return true;
	}

	private ChessBoardConfiguration printBoardHeaderAndFooter(StringBuilder builder) {
		for (int column = 0; column < chessBoardSize.getWidth(); column++) {
			builder.append("*");
			builder.append("-");
		}
		return this;
	}

	private ChessBoardConfiguration printBoardBody(StringBuilder builder) {
		int height = chessBoardSize.getLength() / chessBoardSize.getWidth();
		int position = 0;
		for (int row = 0; row < height; row++) {
			if (row != 0) {
				printBoardHeaderAndFooter(builder);
			}
			builder.append("*\n");
			for (int column = 0; column < chessBoardSize.getWidth(); column++) {
				builder.append("|");
				Piece piece = piecePositionMap.get(Integer.valueOf(position++));
				String symbol = " ";
				if (piece != null) {
					symbol = piece.getPieceSymbol();
				}
				builder.append(symbol);
			}
			builder.append("|\n");
		}
		return this;
	}

	private String getText(StringBuilder builder) {
		builder.append("*");
		return builder.toString();
	}

	@Override
	public ChessBoardConfiguration clone() {
		ChessBoard chessBoard = new ChessBoard(chessBoardSize, pieceList);
		return new ChessBoardConfiguration(chessBoard, attempt, piecePositionMap);
	}

	@Override
	public boolean equals(Object configuration) {
		if (configuration == null) {
			return false;
		}
		return getId().equals(((ChessBoardConfiguration) configuration).getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return printBoardHeaderAndFooter(builder).printBoardBody(builder).printBoardHeaderAndFooter(builder)
				.getText(builder);
	}

}

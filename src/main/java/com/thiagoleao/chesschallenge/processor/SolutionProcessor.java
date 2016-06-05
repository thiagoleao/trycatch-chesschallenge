package com.thiagoleao.chesschallenge.processor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.thiagoleao.chesschallenge.board.ChessBoard;
import com.thiagoleao.chesschallenge.board.ChessBoardConfiguration;
import com.thiagoleao.chesschallenge.pieces.Piece;

/**
 * 
 * This class is responsible for the magic, to find the solution for the
 * challenge
 * 
 * @author Thiago Leao
 *
 */
public class SolutionProcessor {

	private SolutionProcessor() {
		// not to be initialized
	}

	/**
	 * This private class is used as a variable auxiliary to count positions
	 * that are being accessed
	 * 
	 * @author Thiago Leao
	 *
	 */
	private static class PositionCounter {
		public PositionCounter() {
			this.index = 0;
			this.startPosition = 0;
		}

		public PositionCounter(int index, int startPosition) {
			this.index = index;
			this.startPosition = startPosition;
		}

		int index;
		int startPosition;
	}

	/**
	 * Process a chess {@link ChessBoard} to find all unique configurations for
	 * the set of {@link Piece} inputed
	 * 
	 * @param board
	 * @return a solution for the chess challenge
	 */
	public static Solution findSolution(ChessBoard board) {
		long start = System.currentTimeMillis();

		Set<List<Piece>> pieceListSet = new HashSet<List<Piece>>();

		Shift shift = new Shift(pieceListSet);
		shift.getPartitionList().addAll(board.getPieceList());
		pieceListSet = recursiveShifts(shift);

		Solution solution = new Solution();
		Set<ChessBoardConfiguration> configurationSet = new HashSet<>();

		pieceListSet.forEach( pieceList -> {
			ChessBoardConfiguration configuration = new ChessBoardConfiguration(board.getChessBoardSize());
			configuration.addPieceList(pieceList);
			configurationSet.addAll(findConfigurations(configurationSet, configuration, new PositionCounter()));
		});

		long stop = System.currentTimeMillis();

		solution.addChessBoardConfigurations(configurationSet);
		solution.setElapsedTime(stop - start);

		return solution;
	}

	/**
	 * Fill {@link ChessBoardConfiguration} object with pieces on all possible
	 * positions
	 * 
	 * @param configurationSet
	 * @param chessBoardConfiguration
	 * @param p
	 * 
	 */
	private static Set<ChessBoardConfiguration> findConfigurations(Set<ChessBoardConfiguration> configurationSet,
			ChessBoardConfiguration chessBoardConfiguration, PositionCounter p) {
		if (p.index == chessBoardConfiguration.getPieceList().size()) {
			configurationSet.add(chessBoardConfiguration);
		} else {

			Piece piece = chessBoardConfiguration.getPieceList().get(p.index);
			int position = p.startPosition;

			while (position < chessBoardConfiguration.getChessBoardSize().getLength()) {
				int piecePosition = chessBoardConfiguration.allocateAPieceAtAValidPosition(piece, position);
				if (piecePosition == ChessBoardConfiguration.NULL) {
					break;
				} else {
					configurationSet = findConfigurations(configurationSet, chessBoardConfiguration.clone(),
							new PositionCounter(p.index + 1, piecePosition + 1));
					chessBoardConfiguration.removePiece(piece);
					position = piecePosition + 1;
				}
			}
		}
		return configurationSet;
	}

	/**
	 * Algorithm responsible to execute shifts between pieces in a chess board
	 * 
	 * @param shift
	 */
	private static Set<List<Piece>> recursiveShifts(Shift shift) {
		int x = shift.getPartitionList().size();
		// Overwritten equals method of Piece to keep no repeated elements in
		// the set
		if (x == 0) {
			shift.getPieceListSet().add(shift.getGatheringList());
		} else {
			for (int i = 0; i < x; i++) {

				List<Piece> _gathering = new ArrayList<Piece>(shift.getGatheringList());
				List<Piece> _partition = new ArrayList<Piece>(shift.getPartitionList());

				_gathering.add(_partition.remove(i));

				Shift _shift = new Shift(shift.getPieceListSet());
				_shift.getGatheringList().addAll(_gathering);
				_shift.getPartitionList().addAll(_partition);

				shift.setPieceListSet(recursiveShifts(_shift));
			}
		}
		return shift.getPieceListSet();
	}

}

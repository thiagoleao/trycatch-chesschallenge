package com.thiagoleao.chesschallenge.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.thiagoleao.chesschallenge.pieces.Piece;

/**
 * This class encapsulates the necessary lists for the shift between pieces at
 * chess board positions
 * 
 * @author Thiago Leao
 *
 */
public class Shift {

	private Set<List<Piece>> pieceListSet;
	private List<Piece> gatheringList;
	private List<Piece> partitionList;

	public Shift(Set<List<Piece>> pieceListSet) {
		this.pieceListSet = pieceListSet;
		gatheringList = new ArrayList<>();
		partitionList = new ArrayList<>();
	}

	public Set<List<Piece>> getPieceListSet() {
		return pieceListSet;
	}

	public void setPieceListSet(Set<List<Piece>> pieceListSet) {
		this.pieceListSet = pieceListSet;
	}

	public List<Piece> getGatheringList() {
		return gatheringList;
	}

	public List<Piece> getPartitionList() {
		return partitionList;
	}

}

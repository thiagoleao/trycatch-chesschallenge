package com.thiagoleao.chesschallenge;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import com.thiagoleao.chesschallenge.board.ChessBoard;
import com.thiagoleao.chesschallenge.board.ChessBoardSize;
import com.thiagoleao.chesschallenge.pieces.Bishop;
import com.thiagoleao.chesschallenge.pieces.King;
import com.thiagoleao.chesschallenge.pieces.Knight;
import com.thiagoleao.chesschallenge.pieces.Queen;
import com.thiagoleao.chesschallenge.processor.Solution;
import com.thiagoleao.chesschallenge.processor.SolutionProcessor;

public class Main {

	public static void main(String[] args) {
		
		PrintStream out = System.out;
		
		out.println("==========================================================================");
		out.println("*                          CHESS CHALLENGE                               *");
		out.println("==========================================================================");
		out.println("							Author: Thiago Leao");
		out.println("							2016");
		
		//ChessBoard board = new ChessBoard(new ChessBoardSize(3,3));
		//ChessBoard board = new ChessBoard(new ChessBoardSize(4,4));
		ChessBoard board = new ChessBoard(new ChessBoardSize(7,7));
		
		//board.addPieceList(Arrays.asList(new King(), new King(), new Rook()));
		//board.addPieceList(Arrays.asList(new Rook(), new Rook(), new Knight(), new Knight(), new Knight(), new Knight()));
		board.addPieceList(Arrays.asList(new King(), new King(), new Queen(), new Queen(), new Bishop(), new Bishop(), new Knight()));
		 
		Solution solution = SolutionProcessor.findSolution(board);
		solution.printTotalUniqueConfigurations();
		solution.printElapsedTime();
		
		out.println("==========================================================================");
		
		System.out.println("Do you want to print all unique board configurations?");
		System.out.println("1-yes\n2-no");
		Scanner in = new Scanner(System.in);
		int answer = in.nextInt();
		
		if(answer == 1) {
			solution.printChessBoards();
		}
		
		in.close();
		out.println("==========================================================================");
	}
}

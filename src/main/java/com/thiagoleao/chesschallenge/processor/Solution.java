package com.thiagoleao.chesschallenge.processor;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.thiagoleao.chesschallenge.board.ChessBoardConfiguration;

/**
 * This class represents the solution for the challenge
 * 
 * @author Thiago Leao
 *
 */
public class Solution {

	private int attempts;
	private int nonUniqueConfigurationCounter;
	private long elapsedTime;
	private PrintStream output;
	private Map<UUID, ChessBoardConfiguration> uniqueConfigurationMap;

	public Solution() {
		init();
	}

	public Map<UUID, ChessBoardConfiguration> getUniqueConfigurationMap() {
		return uniqueConfigurationMap;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public Integer getNonUniqueConfigurationCounter() {
		return nonUniqueConfigurationCounter;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public void addChessBoardConfigurations(Set<ChessBoardConfiguration> configurationSet) {
		for (ChessBoardConfiguration configuration : configurationSet) {

			attempts++;
			configuration.setAttempt(attempts);
			UUID id = configuration.getId();
			ChessBoardConfiguration preceding = uniqueConfigurationMap.get(id);

			if (preceding == null) {
				uniqueConfigurationMap.put(id, configuration);
			} else {
				nonUniqueConfigurationCounter++;
			}

		}
	}

	public void printTotalUniqueConfigurations() {
		output.println("Total unique configurations: " + uniqueConfigurationMap.size());
	}

	public void printElapsedTime() {
		output.println("Elapsed time: " + (double) elapsedTime / 1000 + " seconds");
	}

	public void printChessBoards() {
		uniqueConfigurationMap.values().forEach(config -> {
			output.println(config.toString());
		});
	}

	private void init() {
		this.uniqueConfigurationMap = new HashMap<>();
		this.nonUniqueConfigurationCounter = 0;
		this.attempts = 0;
		this.output = System.out;
	}
}

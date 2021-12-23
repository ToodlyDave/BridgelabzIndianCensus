package com.entity;

public class CSVStateCensus {

	String state;
	long population;
	int areaInSqKm;
	double densityPerSqKm;

	public CSVStateCensus(String state, long population, int areaInSqKm, double densityPerSqKm) {
		super();
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

}

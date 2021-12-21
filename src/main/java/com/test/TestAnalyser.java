package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.analyser.StateCensusAnalyser;
import com.exceptions.InvalidFile;

public class TestAnalyser {
	
	StateCensusAnalyser analyser;
	
	@Before
	public void initialization() {
		analyser = new StateCensusAnalyser();
	}

	@Test
	public void testRecordMatch() throws InvalidFile {
		analyser.loadData("src/main/resources/IndiaStateCensusData.csv");
		assertEquals(true, analyser.checkData());
	}
	@Test(expected = InvalidFile.class)
	public void testFileCheckSad() throws InvalidFile {
		analyser.loadData("src/main/resources/IndiaStateCensusDat.csv");
	}
}

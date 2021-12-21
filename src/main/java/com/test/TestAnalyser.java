package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.analyser.StateCensusAnalyser;
import com.exceptions.InvalidDelimiter;
import com.exceptions.InvalidFile;
import com.exceptions.InvalidType;

public class TestAnalyser {

	StateCensusAnalyser analyser;

	@Before
	public void initialization() {
		analyser = new StateCensusAnalyser();
	}

	@Test
	public void testRecordMatch() throws InvalidFile, InvalidType, InvalidDelimiter {
		analyser.loadData("src/main/resources/IndiaStateCensusData.csv");
		assertEquals(true, analyser.checkData());
	}

	@Test(expected = InvalidFile.class)
	public void testFileCheckSad() throws InvalidFile, InvalidType, InvalidDelimiter  {
		analyser.loadData("src/main/resources/IndiaStateCensusDat.csv");
	}

	@Test(expected = InvalidType.class)
	public void testTypeCheckSad() throws InvalidFile, InvalidType, InvalidDelimiter  {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWrongType.csv");
	}
	
	@Test(expected = InvalidDelimiter.class)
	public void testDelimiterCheckSad() throws InvalidFile, InvalidType, InvalidDelimiter  {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWrongDelimiter.csv");
	}
}

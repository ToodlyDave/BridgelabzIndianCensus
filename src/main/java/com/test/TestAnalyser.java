package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.analyser.CSVStates;
import com.analyser.StateCensusAnalyser;
import com.exceptions.InvalidDelimiter;
import com.exceptions.InvalidFile;
import com.exceptions.InvalidHeader;
import com.exceptions.InvalidType;

public class TestAnalyser {

	StateCensusAnalyser analyser;
	CSVStates codeAnalyser;

	@Before
	public void initialization() {
		analyser = new StateCensusAnalyser();
		codeAnalyser = new CSVStates();
	}

	@Test
	public void testRecordMatch() throws Exception {
		analyser.loadData("src/main/resources/IndiaStateCensusData.csv");
		assertEquals(true, analyser.checkData(29));
	}

	@Test(expected = InvalidFile.class)
	public void testFileCheckSad() throws Exception {
		analyser.loadData("src/main/resources/IndiaStateCensusDat.csv");
	}

	@Test(expected = InvalidType.class)
	public void testTypeCheckSad() throws Exception {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWrongType.csv");
	}

	@Test(expected = InvalidDelimiter.class)
	public void testDelimiterCheckSad() throws Exception {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWrongDelimiter.csv");
	}

	@Test(expected = InvalidHeader.class)
	public void testHeaderCheckSad() throws Exception {
		analyser.loadData("src/main/resources/IndiaStateCensusDataWrongHeader.csv");
		analyser.checkHeader();
	}

	@Test
	public void testCodeRecordMatch() throws Exception {
		codeAnalyser.loadData("src/main/resources/IndiaStateCode.csv");
		assertEquals(true, codeAnalyser.checkData(37));
	}

	@Test(expected = InvalidFile.class)
	public void testCodeFileCheckSad() throws Exception {
		codeAnalyser.loadData("src/main/resources/IndiaStateCod.csv");
	}

	@Test(expected = InvalidType.class)
	public void testCodeTypeCheckSad() throws Exception {
		codeAnalyser.loadData("src/main/resources/IndiaStateCodeDataWrongType.csv");
	}

	@Test(expected = InvalidDelimiter.class)
	public void testCodeDelimiterCheckSad() throws Exception {
		codeAnalyser.loadData("src/main/resources/IndiaStateCodeDataWrongDelimiter.csv");
	}

	@Test(expected = InvalidHeader.class)
	public void testCodeHeaderCheckSad() throws Exception {
		codeAnalyser.loadData("src/main/resources/IndiaStateCodeDataWrongHeader.csv");
		codeAnalyser.checkHeader();
	}
}

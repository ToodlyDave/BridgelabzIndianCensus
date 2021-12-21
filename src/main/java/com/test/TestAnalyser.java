package com.test;

import org.junit.Test;

import com.analyser.StateCensusAnalyser;

public class TestAnalyser {

	@Test
	public void testCensusAnalyser() {
		StateCensusAnalyser analyser = new StateCensusAnalyser();
		analyser.loadData();
	}
}

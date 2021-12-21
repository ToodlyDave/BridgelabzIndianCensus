package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.analyser.StateCensusAnalyser;

public class TestAnalyser {
	
	StateCensusAnalyser analyser;
	
	@Before
	public void initialization() {
		analyser = new StateCensusAnalyser();
	}

	@Test
	public void testRecordMatch() {
		analyser.loadData();
		assertEquals(true, analyser.checkData());
	}
}

package com.analyser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.entity.CSVStateCensus;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class StateCensusAnalyser {

	ArrayList<CSVStateCensus> censusData = new ArrayList<CSVStateCensus>();

	public void loadData() {

		try {
			CSVReader reader = new CSVReader(new FileReader("src/main/resources/IndiaStateCensusData.csv"));
			String[] record;
			record = reader.readNext();
			while ((record = reader.readNext()) != null) {
				censusData.add(new CSVStateCensus(record[0], Long.parseLong(record[1]), Integer.parseInt(record[2]),
						Double.parseDouble(record[3])));
			}

			for (CSVStateCensus data : censusData) {
				System.out.println(data);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkData() {
		if (censusData.size() == 29)
			return true;
		return false;
	}
}

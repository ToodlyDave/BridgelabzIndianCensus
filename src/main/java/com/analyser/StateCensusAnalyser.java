package com.analyser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.entity.CSVStateCensus;
import com.exceptions.InvalidDelimiter;
import com.exceptions.InvalidFile;
import com.exceptions.InvalidHeader;
import com.exceptions.InvalidType;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class StateCensusAnalyser {

	ArrayList<CSVStateCensus> censusData = new ArrayList<CSVStateCensus>();

	public void loadData(String filePath) throws InvalidFile, InvalidType, InvalidDelimiter, InvalidHeader {

		try {

			CSVReader reader = new CSVReader(new FileReader(filePath));
			String[] record;
			record = reader.readNext();

			if (!checkHeader(record))
				throw new InvalidHeader(" This is an invalid header");
			while ((record = reader.readNext()) != null) {
				if (record.length != 4)
					throw new InvalidDelimiter();
				censusData.add(new CSVStateCensus(record[0], Long.parseLong(record[1]), Integer.parseInt(record[2]),
						Double.parseDouble(record[3])));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new InvalidFile(" This was an invalid File");
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			throw new InvalidType(" This record had an invalid type ");
		}

	}

	public boolean checkHeader(String[] record) {
		return (record[0].compareTo("State") + record[1].compareTo("Population") + record[2].compareTo("AreaInSqKm")
				+ record[3].compareTo("DensityPerSqKm") == 0);
	}

	public boolean checkData() {
		if (censusData.size() == 29)
			return true;
		return false;
	}
}

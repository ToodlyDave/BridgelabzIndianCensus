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
	String[] header;

	public String[] getHeader() {
		return this.header;
	}

	public void loadData(String filePath) throws InvalidFile, InvalidType, InvalidDelimiter {

		try {

			CSVReader reader = new CSVReader(new FileReader(filePath));
			String[] record;
			header = reader.readNext();

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

	public boolean checkHeader() throws InvalidHeader {
		boolean headerCorrect = (header[0].compareTo("State") + header[1].compareTo("Population")
				+ header[2].compareTo("AreaInSqKm") + header[3].compareTo("DensityPerSqKm") == 0);

		if (!headerCorrect)
			throw new InvalidHeader(" This is an invalid header");

		return true;
	}

	public boolean checkData(int recordCount) {
		if (censusData.size() == recordCount)
			return true;
		return false;
	}
}

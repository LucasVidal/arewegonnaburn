package com.amazinglystupidsoftware.arewegonnaburn.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.amazinglystupidsoftware.arewegonnaburn.AreWeGonnaBurnApplication;

public class VenueCSVStub {
	
	private static VenueCSVStub _INSTANCE;

	protected static VenueCSVStub getInstance() {
		if (_INSTANCE == null)
			_INSTANCE = new VenueCSVStub();

		return _INSTANCE;
	}
	

	protected List<String> getLines() {
		List<String> list = new ArrayList<String>();
		BufferedReader br;
		try {
			InputStream is = AreWeGonnaBurnApplication.getContext().getAssets().open("registro-locales-bailables.csv");
			br = new BufferedReader(new InputStreamReader(is));
			String strLine= br.readLine(); //Discards first line
			while ((strLine = br.readLine()) != null) {
				list.add(strLine);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}
		return list;
	}
}

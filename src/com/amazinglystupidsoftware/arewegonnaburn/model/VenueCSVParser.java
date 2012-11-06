package com.amazinglystupidsoftware.arewegonnaburn.model;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.amazinglystupidsoftware.arewegonnaburn.model.service.VenueServiceModel;

public class VenueCSVParser {
	
	private static VenueCSVParser _INSTANCE;

	protected static VenueCSVParser getInstance() {
		if (_INSTANCE == null)
			_INSTANCE = new VenueCSVParser();

		return _INSTANCE;
	}

	protected List<VenueServiceModel> getVenueServiceModels() {
		List<VenueServiceModel> list = new ArrayList<VenueServiceModel>();
		for (String line : VenueCSVStub.getInstance().getLines())
			list.add(new VenueServiceModel(line.split(";")));
		return list;
	}
	

	protected int parseLeft (String str)
	{
		int i;
		for (i=0;(i<str.length() && Character.isDigit(str.charAt(i)));i++);
		try {
			return Integer.parseInt(str.substring(0, i));
		}
		catch (NumberFormatException e)
		{
			Log.e(VenueCSVParser.class.getSimpleName(),"Invalid number: "+str+".");
			return -1;
		}
	}

}

package com.amazinglystupidsoftware.arewegonnaburn.model;

import java.util.ArrayList;
import java.util.List;

import com.amazinglystupidsoftware.arewegonnaburn.model.service.VenueServiceModel;

public class VenueDAO {

	private static VenueDAO _INSTANCE;
	
	public static VenueDAO getInstance()
	{
		if (_INSTANCE==null)
			_INSTANCE = new VenueDAO();
		
		return _INSTANCE;
	}

	private List<Venue> venueList=null;

	public List<Venue> getAll() {
		venueList = new ArrayList<Venue>();
		for (VenueServiceModel vnc : VenueCSVParser.getInstance().getVenueServiceModels())
			venueList.add(convertFromServiceModel(vnc));
		
		//removing invalid venues
		List<Venue> toRemove = new ArrayList<Venue>();
		
		for (Venue v: venueList)
			if (!v.isValid())
				toRemove.add(v);
		
		venueList.removeAll(toRemove);
		
		return venueList;
	}
	
	private Venue convertFromServiceModel(VenueServiceModel vsm)
	{
		VenueCSVParser parser = VenueCSVParser.getInstance();
		return new Venue (
				parser.humanizeString(vsm.getNumber()),
				parser.humanizeString(vsm.getNombre()), 
				parser.humanizeString(vsm.getDomicilio()+vsm.getNro_domicilio()), 
				parser.parseLeft(vsm.getCapacidad())
				);
	}

	public Venue getVenueWithId(String venueId) {
		if (venueList == null) 
			venueList = getAll();
		
		for (Venue v : venueList)
			if (v.getId().toLowerCase().equals(venueId))
				return v;
		
		return null;
	}
}

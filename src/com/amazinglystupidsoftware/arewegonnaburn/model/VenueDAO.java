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

	public List<Venue> getAll() {
		List<Venue> list = new ArrayList<Venue>();
		for (VenueServiceModel vnc : VenueCSVParser.getInstance().getVenueServiceModels())
			list.add(convertFromServiceModel(vnc));
		
		//removing invalid venues
		List<Venue> toRemove = new ArrayList<Venue>();
		
		for (Venue v: list)
			if (!v.isValid())
				toRemove.add(v);
		
		list.removeAll(toRemove);
		
		return list;
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
}

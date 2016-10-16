package apaw.p2.sport.controllers;

import java.util.List;

import apaw.p2.sport.daos.DaoFactory;
import apaw.p2.sport.entities.Sport;
import apaw.p2.sport.wrappers.SportListWrapper;
import apaw.p2.sport.wrappers.SportWrapper;

public class SportController {

	public boolean createSport(String name) {
	    Sport sport = DaoFactory.getFactory().getSportDao().findSportByName(name);
	    
	    if (sport != null){
	        return false;
	    } else{
	        DaoFactory.getFactory().getSportDao().create(new Sport(name));
	        return true;
	    }
	}

	public SportListWrapper sportList() {
		List<Sport> sports = DaoFactory.getFactory().getSportDao().findAll();
		SportListWrapper sportListWrapper = new SportListWrapper();
		for (Sport sport : sports) {
			sportListWrapper.addSportWrapper(new SportWrapper(sport.getName()));
		}
		return sportListWrapper;
	}

}

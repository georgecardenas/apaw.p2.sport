package apaw.p2.sport.api;

import apaw.p2.sport.controllers.SportController;
import apaw.p2.sport.exceptions.DuplicateSportNameException;
import apaw.p2.sport.wrappers.SportListWrapper;

public class SportResource {

	// POST **/sports   body="name"
	public void createSport(String name) throws DuplicateSportNameException{
		if (!new SportController().createSport(name)){
		    throw new DuplicateSportNameException("" + name);
		}
	}

	// GET **/sports
	public SportListWrapper sportList() {
		return new SportController().sportList();
	}

}

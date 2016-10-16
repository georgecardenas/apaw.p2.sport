package apaw.p2.sport.controllers;

import java.util.List;

import apaw.p2.sport.daos.DaoFactory;
import apaw.p2.sport.entities.Sport;
import apaw.p2.sport.entities.User;
import apaw.p2.sport.wrappers.UserListWrapper;
import apaw.p2.sport.wrappers.UserWrapper;

public class UserController {

	public boolean createUser(String nick, String email) {
	    User user = DaoFactory.getFactory().getUserDao().findUserByNick(nick);
	    
	    if (user != null){
	        return false;
	    } else{
	        DaoFactory.getFactory().getUserDao().create(new User(nick, email));
	        return true;
	    }
	}
	
	public boolean addSportToUser(String nick, String sport) {
        Sport sportResult = DaoFactory.getFactory().getSportDao().findSportByName(sport);
        
        if (sportResult == null){
            return false;
        } else{
            DaoFactory.getFactory().getUserDao().addSportToUser(nick, sportResult);
            return true;
        }
    }

	public UserListWrapper userList() {
		List<User> users = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : users) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(),user.getEmail()));
		}
		return userListWrapper;
	}

    public UserListWrapper userListBySport(String sport) {
        Sport sportResult = DaoFactory.getFactory().getSportDao().findSportByName(sport);
        UserListWrapper userListWrapper = new UserListWrapper();
        
        if (sportResult == null){
            return userListWrapper;
        }
        
        List<User> users = DaoFactory.getFactory().getUserDao().findUsersBySport(sportResult);
        for (User user : users) {
            userListWrapper.addUserWrapper(new UserWrapper(user.getNick(),user.getEmail()));
        }
        return userListWrapper;
    }

}

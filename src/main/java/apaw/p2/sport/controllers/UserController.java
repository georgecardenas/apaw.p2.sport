package apaw.p2.sport.controllers;

import java.util.List;

import apaw.p2.sport.daos.DaoFactory;
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

	public UserListWrapper userList() {
		List<User> users = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : users) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(),user.getEmail()));
		}
		return userListWrapper;
	}

}

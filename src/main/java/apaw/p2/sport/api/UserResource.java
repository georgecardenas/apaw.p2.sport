package apaw.p2.sport.api;

import apaw.p2.sport.controllers.UserController;
import apaw.p2.sport.exceptions.DuplicateUserNickException;
import apaw.p2.sport.wrappers.UserListWrapper;

public class UserResource {

	// POST **/users   body="nick:email"
	public void createUser(String nick, String email) throws DuplicateUserNickException{
		if (!new UserController().createUser(nick, email)){
		    throw new DuplicateUserNickException("" + nick);
		}
	}

	// GET **/users
	public UserListWrapper userList() {
		return new UserController().userList();
	}

}

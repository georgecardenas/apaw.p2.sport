package apaw.p2.sport.api;

import apaw.p2.sport.controllers.UserController;
import apaw.p2.sport.exceptions.DuplicateUserNickException;
import apaw.p2.sport.exceptions.SportNotFoundException;
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
	
	// PUT **/users/{nick}/sport
    public void addSportToUser(String nick, String sport) throws SportNotFoundException {
        if (!new UserController().addSportToUser(nick, sport)){
            throw new SportNotFoundException("" + sport);
        }
    }

    public UserListWrapper getUserListbySport(String sport) {
        return new UserController().userListBySport(sport);
    }

}

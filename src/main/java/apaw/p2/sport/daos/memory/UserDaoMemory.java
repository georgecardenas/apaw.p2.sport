package apaw.p2.sport.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import apaw.p2.sport.daos.UserDao;
import apaw.p2.sport.entities.Sport;
import apaw.p2.sport.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer,User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	}

    @Override
    public User findUserByNick(String nick) {
        List<User> users = this.findAll();
        for (User user : users){
            if (nick.equals(user.getNick())){
                return user;
            }
        }
        return null;
    }

    @Override
    public void addSportToUser(String nick, Sport sport) {
        User user = findUserByNick(nick);
        user.getSports().add(sport);
    }

    @Override
    public List<User> findUsersBySport(Sport sport) {
        List<User> users = this.findAll();
        List<User> result = new ArrayList<User>();
        
        for (User user : users){
            if (user.getSports().contains(sport)){
                result.add(user);
            }
        }
        return result;
    }
}
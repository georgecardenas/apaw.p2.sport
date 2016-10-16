package apaw.p2.sport.daos;

import apaw.p2.sport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
    User findUserByNick(String nick);
}

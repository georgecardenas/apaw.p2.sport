package apaw.p2.sport.daos;

import java.util.List;

import apaw.p2.sport.entities.Sport;
import apaw.p2.sport.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
    User findUserByNick(String nick);

    void addSportToUser(String nick, Sport sport);

    List<User> findUsersBySport(Sport sport);
}

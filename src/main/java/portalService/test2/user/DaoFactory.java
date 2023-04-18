package portalService.test2.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portalService.test2.connection.ConnectionMaker;
import portalService.test2.connection.JejuConnectionMaker;

public class DaoFactory {

    public UserDao userDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    private ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}

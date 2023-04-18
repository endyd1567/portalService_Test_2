package portalService.test2.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import portalService.test2.connection.ConnectionMaker;
import portalService.test2.connection.HallaConnectionMaker;
import portalService.test2.connection.JejuConnectionMaker;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {


    @Test
    public void get() throws SQLException {

        Long id = 1l;
        String name = "umdu";
        String password = "1234";

        JejuConnectionMaker jejuConnectionMaker = new JejuConnectionMaker();
        UserDao userDao = new UserDao(jejuConnectionMaker);
        User user = userDao.findById(1l);

        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPassword()).isEqualTo(password);
    }

    @Test
    public void insert() throws SQLException {

        String name = "엄두용";
        String password = "1234";
        User user = new User();
        user.setName(name);
        user.setPassword(password);


        JejuConnectionMaker jejuConnectionMaker = new JejuConnectionMaker();
        UserDao userDao = new UserDao(jejuConnectionMaker);
        userDao.insert(user);

        assertThat(user.getId()).isGreaterThan(1l);

        User insertedUser = userDao.findById(user.getId());

        assertThat(insertedUser.getId()).isEqualTo(user.getId());
        assertThat(insertedUser.getName()).isEqualTo(user.getName());
        assertThat(insertedUser.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void getForHalla() throws SQLException {

        Long id = 1l;
        String name = "umdu";
        String password = "1234";

        HallaConnectionMaker hallaConnectionMaker = new HallaConnectionMaker();
        UserDao userDao = new UserDao(hallaConnectionMaker);
        User user = userDao.findById(1l);

        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getPassword()).isEqualTo(password);
    }

    @Test
    public void insertForHalla() throws SQLException {

        String name = "엄두용한라";
        String password = "1234한라";
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        HallaConnectionMaker hallaConnectionMaker = new HallaConnectionMaker();
        UserDao userDao = new UserDao(hallaConnectionMaker);
        userDao.insert(user);

        assertThat(user.getId()).isGreaterThan(1l);

        User insertedUser = userDao.findById(user.getId());

        assertThat(insertedUser.getId()).isEqualTo(user.getId());
        assertThat(insertedUser.getName()).isEqualTo(user.getName());
        assertThat(insertedUser.getPassword()).isEqualTo(user.getPassword());
    }

}